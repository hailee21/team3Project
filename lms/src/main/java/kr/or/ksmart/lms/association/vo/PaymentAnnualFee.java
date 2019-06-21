package kr.or.ksmart.lms.association.vo;

public class PaymentAnnualFee {
	private String paymentAnnualFeeCode;
	private String institutionCode;
	private String institutionName;
	private String infoAnnualFeeCode;
	private int paymentAnnualFeePrice;
	private String paymentAnnualFeeServiceStartDate;
	private String paymentAnnualFeeServiceEndDate;
	private String paymentAnnualFeeDate;
	private String paymentAnnualFeeMethod;

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

	public String getInfoAnnualFeeCode() {
		return infoAnnualFeeCode;
	}

	public void setInfoAnnualFeeCode(String infoAnnualFeeCode) {
		this.infoAnnualFeeCode = infoAnnualFeeCode;
	}

	public int getPaymentAnnualFeePrice() {
		return paymentAnnualFeePrice;
	}

	public void setPaymentAnnualFeePrice(int paymentAnnualFeePrice) {
		this.paymentAnnualFeePrice = paymentAnnualFeePrice;
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

	public String getPaymentAnnualFeeDate() {
		return paymentAnnualFeeDate;
	}

	public void setPaymentAnnualFeeDate(String paymentAnnualFeeDate) {
		this.paymentAnnualFeeDate = paymentAnnualFeeDate;
	}

	public String getPaymentAnnualFeeMethod() {
		return paymentAnnualFeeMethod;
	}

	public void setPaymentAnnualFeeMethod(String paymentAnnualFeeMethod) {
		this.paymentAnnualFeeMethod = paymentAnnualFeeMethod;
	}

	@Override
	public String toString() {
		return "PaymentAnnualFee [infoAnnualFeeCode=" + infoAnnualFeeCode + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", paymentAnnualFeeCode=" + paymentAnnualFeeCode
				+ ", paymentAnnualFeeDate=" + paymentAnnualFeeDate + ", paymentAnnualFeeMethod="
				+ paymentAnnualFeeMethod + ", paymentAnnualFeePrice=" + paymentAnnualFeePrice
				+ ", paymentAnnualFeeServiceEndDate=" + paymentAnnualFeeServiceEndDate
				+ ", paymentAnnualFeeServiceStartDate=" + paymentAnnualFeeServiceStartDate + "]";
	}
	
	
}
