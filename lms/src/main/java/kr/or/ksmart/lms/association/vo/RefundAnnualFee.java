package kr.or.ksmart.lms.association.vo;

public class RefundAnnualFee {
	private String refundAnnualFeeCode;
	private String paymentAnnualFeeCode;
	private String institutionCode;
	private String institutionName;
	private String refundPolicyCode;
	private String infoAnnualFeeCode;
	private int refundAnnualFeePrice;
	private String paymentAnnualFeeServiceStartDate;
	private String paymentAnnualFeeServiceEndDate;
	private String infoInstitutionRemainingDate;
	private String paymentAnnualFeeDate;
	private String refundAnnualFeeDate;
	public String getRefundAnnualFeeCode() {
		return refundAnnualFeeCode;
	}
	public void setRefundAnnualFeeCode(String refundAnnualFeeCode) {
		this.refundAnnualFeeCode = refundAnnualFeeCode;
	}
	public String getPaymentAnnualFeeCode() {
		return paymentAnnualFeeCode;
	}
	public void setPaymentAnnualFeeCode(String paymentAnnualFeeCode) {
		this.paymentAnnualFeeCode = paymentAnnualFeeCode;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getRefundPolicyCode() {
		return refundPolicyCode;
	}
	public void setRefundPolicyCode(String refundPolicyCode) {
		this.refundPolicyCode = refundPolicyCode;
	}
	public String getInfoAnnualFeeCode() {
		return infoAnnualFeeCode;
	}
	public void setInfoAnnualFeeCode(String infoAnnualFeeCode) {
		this.infoAnnualFeeCode = infoAnnualFeeCode;
	}
	public int getRefundAnnualFeePrice() {
		return refundAnnualFeePrice;
	}
	public void setRefundAnnualFeePrice(int refundAnnualFeePrice) {
		this.refundAnnualFeePrice = refundAnnualFeePrice;
	}
	public String getPaymentAnnualFeeServiceStartDate() {
		return paymentAnnualFeeServiceStartDate;
	}
	public void setPaymentAnnualFeeServiceStartDate(String paymentAnnualFeeServiceStartDate) {
		this.paymentAnnualFeeServiceStartDate = paymentAnnualFeeServiceStartDate;
	}
	public String getPaymentAnnualFeeServiceEndDate() {
		return paymentAnnualFeeServiceEndDate;
	}
	public void setPaymentAnnualFeeServiceEndDate(String paymentAnnualFeeServiceEndDate) {
		this.paymentAnnualFeeServiceEndDate = paymentAnnualFeeServiceEndDate;
	}
	public String getInfoInstitutionRemainingDate() {
		return infoInstitutionRemainingDate;
	}
	public void setInfoInstitutionRemainingDate(String infoInstitutionRemainingDate) {
		this.infoInstitutionRemainingDate = infoInstitutionRemainingDate;
	}
	public String getPaymentAnnualFeeDate() {
		return paymentAnnualFeeDate;
	}
	public void setPaymentAnnualFeeDate(String paymentAnnualFeeDate) {
		this.paymentAnnualFeeDate = paymentAnnualFeeDate;
	}
	public String getRefundAnnualFeeDate() {
		return refundAnnualFeeDate;
	}
	public void setRefundAnnualFeeDate(String refundAnnualFeeDate) {
		this.refundAnnualFeeDate = refundAnnualFeeDate;
	}
	@Override
	public String toString() {
		return "RefundAnnualFee [refundAnnualFeeCode=" + refundAnnualFeeCode + ", paymentAnnualFeeCode="
				+ paymentAnnualFeeCode + ", institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", refundPolicyCode=" + refundPolicyCode + ", infoAnnualFeeCode=" + infoAnnualFeeCode
				+ ", refundAnnualFeePrice=" + refundAnnualFeePrice + ", paymentAnnualFeeServiceStartDate="
				+ paymentAnnualFeeServiceStartDate + ", paymentAnnualFeeServiceEndDate="
				+ paymentAnnualFeeServiceEndDate + ", infoInstitutionRemainingDate=" + infoInstitutionRemainingDate
				+ ", paymentAnnualFeeDate=" + paymentAnnualFeeDate + ", refundAnnualFeeDate=" + refundAnnualFeeDate
				+ "]";
	}
	
}
