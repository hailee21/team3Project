package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.AvailableInstitution;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Mapper
public interface InstitutionMapper {
    //institutionLayout 연회비 결제시 최근 연회비 개요 출력 mapper
    public InfoAnnualFeeByPayment selectInfoAnnualFee();

    //institutionLayout 연회비 결제 내역 출력 mapper
    public List<PaymentAnnualFee> selectPaymentAnnualFeeList(String institutionCode);
    
    //institutionLayout 연회비 결제 PK 출력 mapper
    public String selectPaymentAnnualFeePk();
    
    //institutionLayout 연회비 결제 추가 mapper
    public void insertPaymentAnnualFeey(PaymentAnnualFee paymentAnnualFee);

    //institutionLayout 사용권한 출력 mapper
    public AvailableInstitution selectAvailableInstitution(String institutionCode);

    //institutionLayout 사용권한 추가 mapper
    public void insertAvailableInstitution(AvailableInstitution availableInstitution);

    //instituiionLayout 사용권한 수정 mapper
    public void updateAvailableInstitution(AvailableInstitution availableInstitution);
}
