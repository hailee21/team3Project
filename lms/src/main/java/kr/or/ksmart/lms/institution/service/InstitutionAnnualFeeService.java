package kr.or.ksmart.lms.institution.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionAnnualFeeMapper;
import kr.or.ksmart.lms.institution.vo.AvailableInstitution;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Service
@Transactional
public class InstitutionAnnualFeeService {
	@Autowired
	InstitutionAnnualFeeMapper institutionAnnualFeeMapper;

	//institutionLayout 교육원 연회비 뷰 service
	public Map<String, Object> getAnnualFee(String institutionCode) {
		System.out.println("[InstitutionService getAnnualFee] 호출");
		
		//기존 결제 내역 조회 select mapper 호출
		List<PaymentAnnualFee> paymentList = institutionAnnualFeeMapper.selectPaymentAnnualFeeList(institutionCode);
		
		//교육원 사용권한 조회 select mapper 호출
		AvailableInstitution availableInstitution = institutionAnnualFeeMapper.selectAvailableInstitution(institutionCode);

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.putIfAbsent("availableInstitution", availableInstitution);
		returnMap.putIfAbsent("paymentList", paymentList);
		return returnMap;
	}

	//institutionLayout 교육원 연회비 결제 뷰 service
	public Map<String, Object> getPaymentAnnualFee(String institutionCode) {
		System.out.println("[InstitutionService getPaymentAnnualFee] 호출");

		//결제 뷰에서 서비스 시작일, 서비스 종료일을 출력하기 위한 변수 선언 
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS"); //DB에 저장되는 형식과 동일한 형태
		Date now = new Date(); 
		Timestamp startDay = Timestamp.valueOf(dateFormat.format(now)); //오늘을 얻는다.
		long day = startDay.getTime(); //오늘을 Timestamp 형식으로 변경
		long oneDay = (1000*60*60*24); //Timestamp으로 하루 계산
		long oneYearLater = day + (oneDay*365); //오늘에 +1년을 함
		Timestamp oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater)); //오늘에 +1년을 한 결과를 Timestamp 형식으로 변경
		
		//기존 결제여부를 검사하기 위한 select mapper 호출
		AvailableInstitution availableInstitution = institutionAnnualFeeMapper.selectAvailableInstitution(institutionCode);
		//기존 결제여부 판별
		if(availableInstitution != null){
			//기존 결제가 있으면 서비스 시작일이 오늘이 아니라 기존 결제 서비스 종료일을 시작일로 계산하여 +1년을 한다.
			startDay = Timestamp.valueOf(availableInstitution.getPaymentAnnualFeeServiceEndDate());
			day = startDay.getTime();
			oneYearLater = day + (oneDay*365);
			oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater)); //최종적으로 얻어지는 서비스 종료일
		}

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		InfoAnnualFeeByPayment infoAnnualFee = institutionAnnualFeeMapper.selectInfoAnnualFee();
		returnMap.putIfAbsent("infoAnnualFee", infoAnnualFee);
		returnMap.putIfAbsent("startDay", startDay);
		returnMap.putIfAbsent("oneYearLaterDay", oneYearLaterDay);
		return returnMap;
	}
	
	//institutionLayout 교육원 연회비 결제 액션 service
	public void addPaymentAnnualFee(PaymentAnnualFee paymentAnnualFee) {
		System.out.println("[InstitutionService addPaymentAnnualFee] 호출");

		//테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String paymentAnnualFeeCode = "PAF" + nowDate + randomNo; //payment_annual_fee 테이블의 PK 형식에 맞게 변수를 선언한다.
		paymentAnnualFee.setPaymentAnnualFeeCode(paymentAnnualFeeCode); //선언된 변수를 paymentAnnualFee VO에 입력한다.
		
		//payment_annual_fee 테이블에 입력한다.
		institutionAnnualFeeMapper.insertPaymentAnnualFeey(paymentAnnualFee);
		
		//결제가 완료되면 사용여부 테이블을 업데이트 하기 위한 변수 선언
		//결제시 입력된 데이터를 기준으로 남은일을 계산한다.
		Timestamp startDate = Timestamp.valueOf(dateFormat.format(now));
		Timestamp endDate = Timestamp.valueOf(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
		long longStartDate = startDate.getTime();
		long longEndDate = endDate.getTime();
		long oneDay = (1000*60*60*24);
		int remainingDate = (int)((longEndDate - longStartDate) / oneDay); //종료일 - 시작일의 결과를 하루로 나누워서 계산한다.
		
		//기존 결제 여부를 검사하기 위한 select mapper 호출
		AvailableInstitution availableInstitution = institutionAnnualFeeMapper.selectAvailableInstitution(paymentAnnualFee.getInstitutionCode());
		if(availableInstitution == null){
			//기존 결제가 없으면 available_institution 테이블에 입력할 데이터들을 전부 설정한다.
			AvailableInstitution available = new AvailableInstitution();
			available.setInstitutionCode(paymentAnnualFee.getInstitutionCode());
			available.setInstitutionName(paymentAnnualFee.getInstitutionName());
			available.setPaymentAnnualFeeCode(paymentAnnualFee.getPaymentAnnualFeeCode());
			available.setPaymentAnnualFeeServiceStartDate(paymentAnnualFee.getPaymentAnnualFeeServiceStartDate());
			available.setPaymentAnnualFeeServiceEndDate(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
			available.setAvailableInstitutionAvailability("사용가능");
			available.setAvailableInstitutionRemainingDate(remainingDate);

			//available_institution 테이블 insert mapper 호출
			institutionAnnualFeeMapper.insertAvailableInstitution(available);
		} else {
			//기존 결제가 있으면 기존 결제 데이터에서 필요한 부분만 업데이트 한다.
			availableInstitution.setPaymentAnnualFeeServiceEndDate(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
			availableInstitution.setAvailableInstitutionAvailability("사용가능");
			availableInstitution.setAvailableInstitutionRemainingDate(remainingDate);
			
			//available_institution 테이블 update mapper 호출
			institutionAnnualFeeMapper.updateAvailableInstitution(availableInstitution);
		}
	}
}
