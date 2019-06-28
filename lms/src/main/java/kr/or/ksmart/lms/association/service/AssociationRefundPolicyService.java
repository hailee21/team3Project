package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		String refundPolicyCode = "RP"+nowDate+randomNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		refundPolicy.setRefundPolicyCode(refundPolicyCode); //선언된 PK를 VO에 입력한다.

		//refund_policy 테이블에 입력 mapper 호출
		associationRefundPolicyMapper.insertRefundPolicy(refundPolicy);
	}
}
