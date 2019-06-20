package kr.or.ksmart.lms.institution.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Mapper
public interface InstitutionMapper {
    //institutionLayout 연회비 결제시 최근 연회비 개요 출력 mapper
    public InfoAnnualFeeByPayment selectInfoAnnualFee();
    
    //institutionLayout 연회비 결제 PK 출력 mapper
    public String selectPaymentAnnualFeePk();
    
    //institutionLayout 연회비 결제 추가 mapper
    public void insertPaymentAnnualFeey(PaymentAnnualFee paymentAnnualFee);
}
