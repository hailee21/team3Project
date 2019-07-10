package kr.or.ksmart.lms.association.vo;

public class License {
	
	private String licenseCode;
	private String infoQualificationCode;
	private String infoQualificationName;
	private String memberCode;
	private String memberName;
	private String noticeAnnualLicenseTestResultDate;
	private String licenseIssueDate;
	private String licenseInsertDate;
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
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
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNoticeAnnualLicenseTestResultDate() {
		return noticeAnnualLicenseTestResultDate;
	}
	public void setNoticeAnnualLicenseTestResultDate(String noticeAnnualLicenseTestResultDate) {
		this.noticeAnnualLicenseTestResultDate = noticeAnnualLicenseTestResultDate;
	}
	public String getLicenseIssueDate() {
		return licenseIssueDate;
	}
	public void setLicenseIssueDate(String licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}
	public String getLicenseInsertDate() {
		return licenseInsertDate;
	}
	public void setLicenseInsertDate(String licenseInsertDate) {
		this.licenseInsertDate = licenseInsertDate;
	}
	@Override
	public String toString() {
		return "License [licenseCode=" + licenseCode + ", infoQualificationCode=" + infoQualificationCode
				+ ", infoQualificationName=" + infoQualificationName + ", memberCode=" + memberCode + ", memberName="
				+ memberName + ", noticeAnnualLicenseTestResultDate=" + noticeAnnualLicenseTestResultDate
				+ ", licenseIssueDate=" + licenseIssueDate + ", licenseInsertDate=" + licenseInsertDate + "]";
	}
	
}
