package kr.or.ksmart.lms.institution.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;
import kr.or.ksmart.lms.institution.vo.PaymentAnnualFee;

@Mapper
public interface InstitutionMapper {
    //institutionLayout 연회비 결제시 최근 연회비 개요 출력 mapper
    public InfoAnnualFeeByPayment selectInfoAnnualFee();

    //institutionLayout 연회비 결제 mapper
    public void insertPaymentAnnualFeey(PaymentAnnualFee paymentAnnualFee);
}
