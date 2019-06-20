package kr.or.ksmart.lms.association.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationMapper;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Service
@Transactional
public class AssociationService {
	@Autowired
	AssociationMapper associationMapper;
	
	//associationLayout 연회비 개요 리스트 출력 service
	public List<InfoAnnualFee> getInfoAnnualFeeList(){
		return associationMapper.selectInfoAnnualFeeList();
	}
	
	//associationLayout 환불 정책 리스트 출력 service
	public Map<String, Object> getRefundPolicyList(){
		List<RefundPolicy> refundPolicyAnnualFeeList = associationMapper.selectRefundPolicyAnnualFeeList();
		List<RefundPolicy> refundPolicyLectureList = associationMapper.selectRefundPolicyLectureList();
		List<RefundPolicy> refundPolicyLicenseList = associationMapper.selectRefundPolicyLicenseList();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("refundPolicyAnnualFeeList", refundPolicyAnnualFeeList);
		returnMap.put("refundPolicyLectureList", refundPolicyLectureList);
		returnMap.put("refundPolicyLicenseList", refundPolicyLicenseList);
		return returnMap;
	}
	
	//associationLayout 환불 정책 추가 service
	public void addRefundPolicy(RefundPolicy refundPolicy){
		String refundPolicyPK = associationMapper.selectRefundPolicyPk();
		int lastNo = Integer.parseInt(refundPolicyPK.substring(2));
		lastNo++;
		String refundPolicyCode = "RP"+lastNo;
		refundPolicy.setRefundPolicyCode(refundPolicyCode);
		associationMapper.insertRefundPolicy(refundPolicy);
	}
}
