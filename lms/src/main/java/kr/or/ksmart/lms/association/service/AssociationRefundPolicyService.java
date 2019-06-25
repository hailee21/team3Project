package kr.or.ksmart.lms.association.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationRefundPolicyMapper;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Service
@Transactional
public class AssociationRefundPolicyService {
	@Autowired
	AssociationRefundPolicyMapper associationRefundPolicyMapper;
		
	//환불 정책 리스트 출력 service
	public Map<String, Object> getRefundPolicyList(){
		//환불 정책 리스트 출력을 위한 select mapper 호출
		List<RefundPolicy> refundPolicyAnnualFeeList = associationRefundPolicyMapper.selectRefundPolicyAnnualFeeList();//연회비
		List<RefundPolicy> refundPolicyLectureList = associationRefundPolicyMapper.selectRefundPolicyLectureList();//강의
		List<RefundPolicy> refundPolicyLicenseList = associationRefundPolicyMapper.selectRefundPolicyLicenseList();//자격시험
		
		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("refundPolicyAnnualFeeList", refundPolicyAnnualFeeList);
		returnMap.put("refundPolicyLectureList", refundPolicyLectureList);
		returnMap.put("refundPolicyLicenseList", refundPolicyLicenseList);
		return returnMap;
	}
	
	//환불 정책 추가 액션 service
	public void addRefundPolicy(RefundPolicy refundPolicy){
		//refund_policy 테이블에 입력할 PK 변수 얻기
		String refundPolicyPK = associationRefundPolicyMapper.selectRefundPolicyPk(); //refund_policy 테이블에서 마지막으로 입력된 PK 갑을 가져온다.
		int lastNo = Integer.parseInt(refundPolicyPK.substring(2)); //가져온 PK 값에서 문자를 제외한 숫자값을 얻는다.
		lastNo++; //얻은 숫자값에 +1을 한다.
		String refundPolicyCode = "RP"+lastNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		refundPolicy.setRefundPolicyCode(refundPolicyCode); //선언된 PK를 VO에 입력한다.

		//refund_policy 테이블에 입력 mapper 호출
		associationRefundPolicyMapper.insertRefundPolicy(refundPolicy);
	}
}
