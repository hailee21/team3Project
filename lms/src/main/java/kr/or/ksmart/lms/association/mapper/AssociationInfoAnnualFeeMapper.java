package kr.or.ksmart.lms.association.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.AvailableInstitution;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.PaymentAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Mapper
public interface AssociationInfoAnnualFeeMapper {
	//연회비 개요 리스트 출력 mapper
	public List<InfoAnnualFee> selectInfoAnnualFeeList();
	
	//연회비 개요 추가 mapper
	public void insertInfoAnnualFee(InfoAnnualFee infoAnnualFee);

	//남은일을 업데이트 하기위한 교육원 사용권한 리스트 mapper
	public List<AvailableInstitution> selectAvailableInstitutionListForRemainingDateUpdate();

	//교육원 사용 여부 리스트 출력 mapper
	public List<AvailableInstitution> selectAvailableInstitutionList();

	//교육원 사용 여부 한개 출력 mapper
	public AvailableInstitution selectAvailableInstitution(String institutionCode);

	//교육원 사용 새로고침 mapper
	public void updateAvailableInstitution(AvailableInstitution availableInstitution);

	//연회비 결제 내역 리스트 출력 mapper
	public List<PaymentAnnualFee> selectPaymentAnnualFeeList();

	//연회비 결제 내역 한개 출력 mapper
	public PaymentAnnualFee selectAnnualFee(String paymentAnnualFeeCode);

	//교육원 코드 출력 mapper
	public List<String> selectinstitutionCodeList();

	//연회비 환불 정책 리스트 출력 mapper
	public List<RefundPolicy> selectRefundPolicyAnnualFeeList();
	
	//교육원 별 최근 결제 내역 출력 mapper
	public PaymentAnnualFee selectPaymentAnnualFeeListForRefund(Map<String, Object> map);

	//연회비 환불 추가 mapper
	public void insertRefundAnnualFee(RefundAnnualFee refundAnnualFee);

	//연회비 환불 리스트 출력 mapper
	public List<RefundAnnualFee> selectRefundAnnualFeeList();

	//연회비 환불 리스트에서 환불한 연회비 결제 PK 출력 mapper
	public List<String> selectRefundAnnualFeePAFCK(String institutionCode);
}