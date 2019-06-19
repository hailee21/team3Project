package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionMapper;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Service
@Transactional
public class InstitutionService {
	@Autowired
	InstitutionMapper institutionMapper;

	//institutionLayout 교육원 연회비 결제 뷰 service
	public Map<String, Object> getPaymentAnnualFee() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
		Date nowDate = new Date();
		Timestamp now = Timestamp.valueOf(dateFormat.format(nowDate));
		long today = now.getTime();
		long oneDay = (1000*60*60*24);
		long oneYearLater = today + (oneDay*365);
		Timestamp oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater));
		Map<String, Object> returnMap = new HashMap<String, Object>();
		InfoAnnualFeeByPayment infoAnnualFee = institutionMapper.selectInfoAnnualFee();
		returnMap.putIfAbsent("infoAnnualFee", infoAnnualFee);
		returnMap.putIfAbsent("now", now);
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
	}
}
