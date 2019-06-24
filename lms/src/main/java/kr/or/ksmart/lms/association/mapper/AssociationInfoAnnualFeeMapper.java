package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.AvailableInstitution;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.PaymentAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Mapper
public interface AssociationInfoAnnualFeeMapper {
	//associationLayout 연회비 개요 리스트 출력 mapper
	public List<InfoAnnualFee> selectInfoAnnualFeeList();

	//associationLayout 연회비 개요 PK 출력 mapper
	public String selectInfoAnnualFeePk();
	
	//associationLayout 연회비 개요 추가 mapper
	public void insertInfoAnnualFee(InfoAnnualFee infoAnnualFee);

	//associationLayout 교육원 사용 여부 리스트 출력 mapper
	public List<AvailableInstitution> selectAvailableInstitutionList();

	//associationLayout 교육원 사용 여부 한개 출력 mapper
	public AvailableInstitution selectAvailableInstitution(String institutionCode);

	//associationLayout 교육원 사용 새로고침 mapper
	public void updateAvailableInstitution(AvailableInstitution availableInstitution);

	//associationLayout 연회비 결제 내역 리스트 출력 mapper
	public List<PaymentAnnualFee> selectPaymentAnnualFeeList();

	//associationLayout 연회비 결제 내역 한개 출력 mapper
	public PaymentAnnualFee selectAnnualFee(String paymentAnnualFeeCode);

	//associationLayout 교육원 코드 출력 mapper
	public List<String> selectinstitutionCodeList();

	//associationLayout 연회비 환불 정책 리스트 출력 mapper
	public List<RefundPolicy> selectRefundPolicyAnnualFeeList();
	
	//associationLayout 교육원 별 최근 결제 내역 출력 mapper
	public PaymentAnnualFee selectPaymentAnnualFeeListForRefund(String institutionCode);

	//associationLayout 연회비 환불 PK 출력 mapper
	public String selectRefundAnnualFeePK();

	//associationLayout 연회비 환불 추가 mapper
	public void insertRefundAnnualFee(RefundAnnualFee refundAnnualFee);

	//associationLayout 연회비 환불 리스트 출력 mapper
	public List<RefundAnnualFee> selectRefundAnnualFeeList();
}