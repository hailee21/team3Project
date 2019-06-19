package kr.or.ksmart.lms.association.vo;

public class AvailableInstitution {
	private String institutionCode;
	private String institutionName;
	private String paymentAnnualFeeCode;
	private String paymentAnnualFeeServiceStartDate;
	private String paymentAnnualFeeServiceEndDate;
	private int availableInstitutionRemainingDate;
	private String availableInstitutionAvailability;
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
	public String getPaymentAnnualFeeCode() {
		return paymentAnnualFeeCode;
	}
	public void setPaymentAnnualFeeCode(String paymentAnnualFeeCode) {
		this.paymentAnnualFeeCode = paymentAnnualFeeCode;
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
	public int getAvailableInstitutionRemainingDate() {
		return availableInstitutionRemainingDate;
	}
	public void setAvailableInstitutionRemainingDate(int availableInstitutionRemainingDate) {
		this.availableInstitutionRemainingDate = availableInstitutionRemainingDate;
	}
	public String getAvailableInstitutionAvailability() {
		return availableInstitutionAvailability;
	}
	public void setAvailableInstitutionAvailability(String availableInstitutionAvailability) {
		this.availableInstitutionAvailability = availableInstitutionAvailability;
	}
	@Override
	public String toString() {
		return "AvailableInstitution [institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", paymentAnnualFeeCode=" + paymentAnnualFeeCode + ", paymentAnnualFeeServiceStartDate="
				+ paymentAnnualFeeServiceStartDate + ", paymentAnnualFeeServiceEndDate="
				+ paymentAnnualFeeServiceEndDate + ", availableInstitutionRemainingDate="
				+ availableInstitutionRemainingDate + ", availableInstitutionAvailability="
				+ availableInstitutionAvailability + "]";
	}
	
}
