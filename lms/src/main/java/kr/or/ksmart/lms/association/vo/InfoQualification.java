package kr.or.ksmart.lms.association.vo;

public class InfoQualification {
	private String infoQualificationCode;
	private String infoQualificationName;
	private String infoQualificationRequiredCode;
	private String infoQualificationTestUse;
	private String infoQualificationRequiredType;
	private String infoQualificationDescription;
	private String infoQualificationRenewalDate;
	public String getInfoQualificationCode() {
		return infoQualificationCode;
	}
	public void setInfoQualificationCode(String infoQualificationCode) {
		this.infoQualificationCode = infoQualificationCode;
	}
	public String getInfoQualificationName() {
		return infoQualificationName;
	}
	public void setInfoQualificationName(String infoQualificationName) {
		this.infoQualificationName = infoQualificationName;
	}
	public String getInfoQualificationRequiredCode() {
		return infoQualificationRequiredCode;
	}
	public void setInfoQualificationRequiredCode(String infoQualificationRequiredCode) {
		this.infoQualificationRequiredCode = infoQualificationRequiredCode;
	}
	public String getInfoQualificationTestUse() {
		return infoQualificationTestUse;
	}
	public void setInfoQualificationTestUse(String infoQualificationTestUse) {
		this.infoQualificationTestUse = infoQualificationTestUse;
	}
	public String getInfoQualificationRequiredType() {
		return infoQualificationRequiredType;
	}
	public void setInfoQualificationRequiredType(String infoQualificationRequiredType) {
		this.infoQualificationRequiredType = infoQualificationRequiredType;
	}
	public String getInfoQualificationDescription() {
		return infoQualificationDescription;
	}
	public void setInfoQualificationDescription(String infoQualificationDescription) {
		this.infoQualificationDescription = infoQualificationDescription;
	}
	public String getInfoQualificationRenewalDate() {
		return infoQualificationRenewalDate;
	}
	public void setInfoQualificationRenewalDate(String infoQualificationRenewalDate) {
		this.infoQualificationRenewalDate = infoQualificationRenewalDate;
	}
	@Override
	public String toString() {
		return "InfoQualification [infoQualificationCode=" + infoQualificationCode + ", infoQualificationName="
				+ infoQualificationName + ", infoQualificationRequiredCode=" + infoQualificationRequiredCode
				+ ", infoQualificationTestUse=" + infoQualificationTestUse + ", infoQualificationRequiredType="
				+ infoQualificationRequiredType + ", infoQualificationDescription=" + infoQualificationDescription
				+ ", infoQualificationRenewalDate=" + infoQualificationRenewalDate + "]";
	}
	
}
