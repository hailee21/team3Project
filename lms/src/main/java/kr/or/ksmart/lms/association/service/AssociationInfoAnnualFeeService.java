package kr.or.ksmart.lms.association.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationInfoAnnualFeeMapper;
import kr.or.ksmart.lms.association.vo.AvailableInstitution;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.PaymentAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Service
@Transactional
public class AssociationInfoAnnualFeeService {
	@Autowired
	AssociationInfoAnnualFeeMapper associationInfoAnnualFeeMapper;
	
	//연회비 개요 리스트 출력 service
	public Map<String, Object> getInfoAnnualFeeList(){
		//연회비 개요 리스트 출력 select mapper 호출
		List<InfoAnnualFee> infoAnnualFeeList = associationInfoAnnualFeeMapper.selectInfoAnnualFeeList();

		//교육원 사용권한 리스트 출력 select mapper 호출
		List<AvailableInstitution> availableList = associationInfoAnnualFeeMapper.selectAvailableInstitutionList();

		//연회비 환불 리스트 출력 select mapper 호출
		List<RefundAnnualFee> refundAnnualList = associationInfoAnnualFeeMapper.selectRefundAnnualFeeList();

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("infoAnnualFeeList", infoAnnualFeeList);
		returnMap.put("availableList", availableList);
		returnMap.put("refundAnnualList", refundAnnualList);
		return returnMap;
	}

	//교육원 사용권한 새로고침 service
	public void getAvailableInstitutionRefresh(){
		//교육원 사용권한 리스 출력 select mapper 호출
		List<AvailableInstitution> availableList = associationInfoAnnualFeeMapper.selectAvailableInstitutionList();

		//오늘 날짜 계산한다.
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS"); //DB에 저장되는 형식과 동일한 형태
		Date now = new Date(); 
		Timestamp startDate = Timestamp.valueOf(dateFormat.format(now));
		long longStartDate = startDate.getTime();

		//교육원 사용권한 리스트 사이즈 만큼 반복하며 사용일을 업데이트 한다.
		for(AvailableInstitution list : availableList) {
			Timestamp endDate = Timestamp.valueOf(list.getPaymentAnnualFeeServiceEndDate());
			long longEndDate = endDate.getTime();
			long oneDay = (1000*60*60*24);
			int remainingDate = (int)((longEndDate - longStartDate) / oneDay); //종료일 - 시작일의 결과를 하루로 나누워서 계산한다.
			String availability = "사용가능";
			if(remainingDate <= 0 ){
				availability = "사용불가능";
				remainingDate = 0;
			}
			list.setAvailableInstitutionAvailability(availability);
			list.setAvailableInstitutionRemainingDate(remainingDate);
			//available_institution 테이블 update mapper 호출
			associationInfoAnnualFeeMapper.updateAvailableInstitution(list);
		}
		
	}

	//연회비 개요 추가 액션 service
	public void addInfoAnnualFee(InfoAnnualFee infoAnnualFee) {
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
		String infoAnnualFeeCode = "IAF"+nowDate+randomNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		infoAnnualFee.setInfoAnnualFeeCode(infoAnnualFeeCode); //선언된 PK를 VO에 입력한다.

		//info_annual_fee 테이블에 입력 mapper 호출
		associationInfoAnnualFeeMapper.insertInfoAnnualFee(infoAnnualFee);
	}

	//연회비 환불 리스트 폼 출력 service
	public Map<String, Object> getAssociationRefundAnnualFeeList(){
		//결재 내역이 있는 교육원 코드 리스트 mapper 호출
		List<String> institutionCodeList = associationInfoAnnualFeeMapper.selectinstitutionCodeList();
		
		//오늘 날짜 계산
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
		Date now = new Date(); 
		Timestamp today = Timestamp.valueOf(dateFormat.format(now));
		long longToday = today.getTime();
		
		//환불이 가능한 결재 내역 리스트 출력 mapper 호출
		List<PaymentAnnualFee> paymentListForRefund = new ArrayList<PaymentAnnualFee>();
		for(String institutionCode: institutionCodeList) {
			//각 교육원 코드로 환불 내역 조회 리스트 mapper 호출
			List<String> paymentAnnualFeeCodes = associationInfoAnnualFeeMapper.selectRefundAnnualFeePAFCK(institutionCode);

			//이미 환불한 결재내역이 출력이 되지않도록 처리
			boolean Check = false;
			if(paymentAnnualFeeCodes.size() > 0){
				Check = true;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("paymentAnnualFeeCodes", paymentAnnualFeeCodes);
			map.put("Check", Check);
			map.put("institutionCode", institutionCode);

			//교육원 코드 가장 최근에 결재한 목록 하나 출력 mapper 호출
			PaymentAnnualFee paymentAnnualFee = associationInfoAnnualFeeMapper.selectPaymentAnnualFeeListForRefund(map);
			
			//결제 내역의 서비스 종료일을 얻는다.
			Timestamp endDate = Timestamp.valueOf(paymentAnnualFee.getPaymentAnnualFeeServiceEndDate());
			long longEndDate = endDate.getTime();
			
			//서비스 종료일이 오늘보다 크면 환불이 가능한 결제 내역 리스트에 추가한다.
			if(longEndDate > longToday) {
				paymentListForRefund.add(paymentAnnualFee);
			}
		}
		
		//총 결제 내역 리스트 출력 mppaer 호출
		List<PaymentAnnualFee> paymentList = associationInfoAnnualFeeMapper.selectPaymentAnnualFeeList();

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("paymentList", paymentList);
		returnMap.put("paymentListForRefund", paymentListForRefund);
		return returnMap;
	}
	
	//연회비 환불 폼 출력 service
	public Map<String, Object> getRefundAnnualFeeForm(String paymentAnnualFeeCode){
		//연회비 환불 정책 리스트 출력을 위한 select mapper 호출
		List<RefundPolicy> refundPolicyAnnualFeeList = associationInfoAnnualFeeMapper.selectRefundPolicyAnnualFeeList();

		//해당 결제 내역 출력을 위한 select mapper 호출
		PaymentAnnualFee payment = associationInfoAnnualFeeMapper.selectAnnualFee(paymentAnnualFeeCode);
		
		//남은일 계산하기
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS"); //DB에 저장되는 형식과 동일한 형태
		Date now = new Date(); 
		Timestamp nowDate = Timestamp.valueOf(dateFormat.format(now));
		long longNowtDate = nowDate.getTime();
		Timestamp startDate = Timestamp.valueOf(payment.getPaymentAnnualFeeServiceStartDate());
		long longStartDate = startDate.getTime();
		Timestamp endDate = Timestamp.valueOf(payment.getPaymentAnnualFeeServiceEndDate());
		long longEndDate = endDate.getTime();
		long oneDay = (1000*60*60*24);
		int remainingDate = (int)((longEndDate - longStartDate) / oneDay);//결제 내역의 서비스 종
		if(longStartDate < longNowtDate) {
			//결제 내역의 서비스 시작일보다 오늘이 더 늦으면 서비스 종료일 - 오늘을 한다.
			remainingDate = (int)((longEndDate - longNowtDate) / oneDay);
		}
		
		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("refundPolicyAnnualFeeList", refundPolicyAnnualFeeList);
		returnMap.put("remainingDate",remainingDate);
		returnMap.put("payment",payment);
		return returnMap;
	}

	//연회비 환불 액션 출력 service
	public void addRefundAnnualFee(RefundAnnualFee refundAnnualFee){
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
		if(randomNo >= 10000) {
			randomNo = randomNo/10;
		}
		String refundAnnualFeeCode = "RAF"+nowDate+randomNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		refundAnnualFee.setRefundAnnualFeeCode(refundAnnualFeeCode);; //선언된 PK를 VO에 입력한다.
		System.out.println(refundAnnualFeeCode);
		
		//연회비 환불 추가를 위한 insert mapper 호출
		associationInfoAnnualFeeMapper.insertRefundAnnualFee(refundAnnualFee);

		//연회비 환불로 인한 사용권한 남은일 수정
		AvailableInstitution availableInstitution = associationInfoAnnualFeeMapper.selectAvailableInstitution(refundAnnualFee.getInstitutionCode());
		availableInstitution.setPaymentAnnualFeeServiceEndDate(refundAnnualFee.getPaymentAnnualFeeServiceEndDate());
		associationInfoAnnualFeeMapper.updateAvailableInstitution(availableInstitution);
		System.out.println(availableInstitution);

		//사용권한 새로고침 매소드 호출
		getAvailableInstitutionRefresh();
	}
}
