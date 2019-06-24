package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Mapper
public interface RefundPolicyMapper {
	//associationLayout 연회비 환불 정책 리스트 출력 mapper
	public List<RefundPolicy> selectRefundPolicyAnnualFeeList();
	
	//associationLayout 강의 환불 정책 리스트 출력 mapper
	public List<RefundPolicy> selectRefundPolicyLectureList();
	
	//associationLayout 자격증 환불 정책 리스트 출력 mapper
	public List<RefundPolicy> selectRefundPolicyLicenseList();
	
	//associationLayout 환불 정책 PK 출력 mapper
	public String selectRefundPolicyPk();
	
	//associationLayout 환불 정책 추가 mapper
	public void insertRefundPolicy(RefundPolicy refundPolicy);
}