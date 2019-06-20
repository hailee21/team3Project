package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionMapper;
import kr.or.ksmart.lms.institution.vo.AvailableInstitution;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Service
@Transactional
public class InstitutionService {
	@Autowired
	InstitutionMapper institutionMapper;

	//institutionLayout 교육원 연회비 뷰 service
	public List<PaymentAnnualFee> getAnnualFee(String institutionCode) {
		return institutionMapper.selectPaymentAnnualFeeList(institutionCode);
	}

	//institutionLayout 교육원 연회비 결제 뷰 service
	public Map<String, Object> getPaymentAnnualFee(String institutionCode) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
		AvailableInstitution availableInstitution = institutionMapper.selectAvailableInstitution(institutionCode);
		System.out.println(availableInstitution);
		Date now = new Date();
		Timestamp startDay = Timestamp.valueOf(dateFormat.format(now));
		long day = startDay.getTime();
		long oneDay = (1000*60*60*24);
		long oneYearLater = day + (oneDay*365);
		Timestamp oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater));
		if(availableInstitution != null){
			startDay = Timestamp.valueOf(availableInstitution.getPaymentAnnualFeeServiceEndDate());
			day = startDay.getTime();
			oneYearLater = day + (oneDay*365);
			oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater));
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		InfoAnnualFeeByPayment infoAnnualFee = institutionMapper.selectInfoAnnualFee();
		returnMap.putIfAbsent("infoAnnualFee", infoAnnualFee);
		returnMap.putIfAbsent("startDay", startDay);
		returnMap.putIfAbsent("oneYearLaterDay", oneYearLaterDay);
		return returnMap;
	}
	
	//institutionLayout 교육원 연회비 결제 액션 service
	public void addPaymentAnnualFee(PaymentAnnualFee paymentAnnualFee) {
		String paymentAnnualFeePk = institutionMapper.selectPaymentAnnualFeePk();
		int lastNo = Integer.parseInt(paymentAnnualFeePk.substring(3));
		lastNo++;
		String paymentAnnualFeeCode = "PAF" + lastNo;
		paymentAnnualFee.setPaymentAnnualFeeCode(paymentAnnualFeeCode);
		institutionMapper.insertPaymentAnnualFeey(paymentAnnualFee);
		AvailableInstitution availableInstitution = institutionMapper.selectAvailableInstitution(paymentAnnualFee.getInstitutionCode());
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
		Date nowDate = new Date();
		Timestamp now = Timestamp.valueOf(dateFormat.format(nowDate));
		Timestamp endDate = Timestamp.valueOf(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
		long today = now.getTime();
		long longEndDate = endDate.getTime();
		long oneDay = (1000*60*60*24);
		int remainingDate = (int)((longEndDate - today) / oneDay);
		if(availableInstitution == null){
			AvailableInstitution available = new AvailableInstitution();
			available.setInstitutionCode(paymentAnnualFee.getInstitutionCode());
			available.setInstitutionName(paymentAnnualFee.getInstitutionName());
			available.setPaymentAnnualFeeCode(paymentAnnualFee.getPaymentAnnualFeeCode());
			available.setPaymentAnnualFeeServiceStartDate(paymentAnnualFee.getPaymentAnnualFeeServiceStartDate());
			available.setPaymentAnnualFeeServiceEndDate(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
			available.setAvailableInstitutionAvailability("사용가능");
			available.setAvailableInstitutionRemainingDate(remainingDate);
			System.out.println(available);
			institutionMapper.insertAvailableInstitution(available);
		} else {
			availableInstitution.setPaymentAnnualFeeServiceEndDate(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
			availableInstitution.setAvailableInstitutionAvailability("사용가능");
			availableInstitution.setAvailableInstitutionRemainingDate(remainingDate);
			institutionMapper.updateAvailableInstitution(availableInstitution);
		}
	}
}
