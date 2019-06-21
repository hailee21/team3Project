package kr.or.ksmart.lms.association.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationMapper;
import kr.or.ksmart.lms.association.vo.AvailableInstitution;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.PaymentAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Service
@Transactional
public class AssociationService {
	@Autowired
	AssociationMapper associationMapper;
	
	//associationLayout 연회비 개요 리스트 출력 service
	public Map<String, Object> getInfoAnnualFeeList(){
		//연회비 개요 리스트 출력 select mapper 호출
		List<InfoAnnualFee> infoAnnualFeeList = associationMapper.selectInfoAnnualFeeList();

		//교육원 사용권한 리스트 출력 select mapper 호출
		List<AvailableInstitution> availableList = associationMapper.selectAvailableInstitutionList();

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("infoAnnualFeeList", infoAnnualFeeList);
		returnMap.put("availableList", availableList);
		return returnMap;
	}

	//associationLayout 교육원 사용권한 새로고침 service
	public void getAvailableInstitutionRefresh(){
		//교육원 사용권한 리스 출력 select mapper 호출
		List<AvailableInstitution> availableList = associationMapper.selectAvailableInstitutionList();

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
			associationMapper.updateAvailableInstitution(list);
		}
		
	}

	//associationLayout 연회비 개요 추가 액션 service
	public void addInfoAnnualFee(InfoAnnualFee infoAnnualFee) {
		//info_annual_fee 테이블에 입력할 PK 변수 얻기
		String infoAnnualFeePK = associationMapper.selectInfoAnnualFeePk(); //info_annual_fee 테이블에서 마지막으로 입력된 PK 갑을 가져온다.
		int lastNo = Integer.parseInt(infoAnnualFeePK.substring(3)); //가져온 PK 값에서 문자를 제외한 숫자값을 얻는다.
		lastNo++; //얻은 숫자값에 +1을 한다.
		String infoAnnualFeeCode = "IAF"+lastNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		infoAnnualFee.setInfoAnnualFeeCode(infoAnnualFeeCode); //선언된 PK를 VO에 입력한다.

		//info_annual_fee 테이블에 입력 mapper 호출
		associationMapper.insertInfoAnnualFee(infoAnnualFee);
	}
	
	//associationLayout 환불 정책 리스트 출력 service
	public Map<String, Object> getRefundPolicyList(){
		//환불 정책 리스트 출력을 위한 select mapper 호출
		List<RefundPolicy> refundPolicyAnnualFeeList = associationMapper.selectRefundPolicyAnnualFeeList();//연회비
		List<RefundPolicy> refundPolicyLectureList = associationMapper.selectRefundPolicyLectureList();//강의
		List<RefundPolicy> refundPolicyLicenseList = associationMapper.selectRefundPolicyLicenseList();//자격시험
		
		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("refundPolicyAnnualFeeList", refundPolicyAnnualFeeList);
		returnMap.put("refundPolicyLectureList", refundPolicyLectureList);
		returnMap.put("refundPolicyLicenseList", refundPolicyLicenseList);
		return returnMap;
	}
	
	//associationLayout 환불 정책 추가 service
	public void addRefundPolicy(RefundPolicy refundPolicy){
		//refund_policy 테이블에 입력할 PK 변수 얻기
		String refundPolicyPK = associationMapper.selectRefundPolicyPk(); //refund_policy 테이블에서 마지막으로 입력된 PK 갑을 가져온다.
		int lastNo = Integer.parseInt(refundPolicyPK.substring(2)); //가져온 PK 값에서 문자를 제외한 숫자값을 얻는다.
		lastNo++; //얻은 숫자값에 +1을 한다.
		String refundPolicyCode = "RP"+lastNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		refundPolicy.setRefundPolicyCode(refundPolicyCode); //선언된 PK를 VO에 입력한다.

		//refund_policy 테이블에 입력 mapper 호출
		associationMapper.insertRefundPolicy(refundPolicy);
	}

	//associationLayout 연회비 환불 리스트 폼 출력 service
	public Map<String, Object> getAssociationRefundAnnualFeeList(){
		//리스트 mapper 호출
		List<String> institutionCodeList = associationMapper.selectinstitutionCodeList();
		List<PaymentAnnualFee> paymentListForRefund = associationMapper.selectPaymentAnnualFeeListForRefund(institutionCodeList);
		List<PaymentAnnualFee> paymentList = associationMapper.selectPaymentAnnualFeeList();
		System.out.println(institutionCodeList);
		System.out.println(paymentListForRefund);
		System.out.println(paymentList);
		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("paymentList", paymentList);
		returnMap.put("paymentListForRefund", paymentListForRefund);
		return returnMap;
	}
	
	//associationLayout 연회비 환불 폼 출력 service
	public Map<String, Object> getRefundAnnualFeeForm(String paymentAnnualFeeCode){
		//연회비 환불 정책 리스트 출력을 위한 select mapper 호출
		List<RefundPolicy> refundPolicyAnnualFeeList = associationMapper.selectRefundPolicyAnnualFeeList();

		//해당 결제 내역 출력을 위한 select mapper 호출
		PaymentAnnualFee payment = associationMapper.selectAnnualFee(paymentAnnualFeeCode);
		
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
}
