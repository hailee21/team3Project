package kr.or.ksmart.lms.association.vo;

public class LicenseTestLocationDetail {
	private String licenseTestLocationDetailCode;
	private String licenseTestLocationCode;
	private String licenseTestLocationDetailClassroom;
	private String licenseTestLocationDetailUse;
	private String licenseTestLocationDetailMaximumNumber;
	private String licenseTestLocationDetailUseInsertDate;
	
	public String getLicenseTestLocationDetailCode() {
		return licenseTestLocationDetailCode;
	}
	public void setLicenseTestLocationDetailCode(String licenseTestLocationDetailCode) {
		this.licenseTestLocationDetailCode = licenseTestLocationDetailCode;
	}
	public String getLicenseTestLocationCode() {
		return licenseTestLocationCode;
	}
	public void setLicenseTestLocationCode(String licenseTestLocationCode) {
		this.licenseTestLocationCode = licenseTestLocationCode;
	}
	public String getLicenseTestLocationDetailClassroom() {
		return licenseTestLocationDetailClassroom;
	}
	public void setLicenseTestLocationDetailClassroom(String licenseTestLocationDetailClassroom) {
		this.licenseTestLocationDetailClassroom = licenseTestLocationDetailClassroom;
	}
	public String getLicenseTestLocationDetailUse() {
		return licenseTestLocationDetailUse;
	}
	public void setLicenseTestLocationDetailUse(String licenseTestLocationDetailUse) {
		this.licenseTestLocationDetailUse = licenseTestLocationDetailUse;
	}
	public String getLicenseTestLocationDetailMaximumNumber() {
		return licenseTestLocationDetailMaximumNumber;
	}
	public void setLicenseTestLocationDetailMaximumNumber(String licenseTestLocationDetailMaximumNumber) {
		this.licenseTestLocationDetailMaximumNumber = licenseTestLocationDetailMaximumNumber;
	}
	public String getLicenseTestLocationDetailUseInsertDate() {
		return licenseTestLocationDetailUseInsertDate;
	}
	public void setLicenseTestLocationDetailUseInsertDate(String licenseTestLocationDetailUseInsertDate) {
		this.licenseTestLocationDetailUseInsertDate = licenseTestLocationDetailUseInsertDate;
	}
	@Override
	public String toString() {
		return "LicenseTestLocationDetail [licenseTestLocationDetailCode=" + licenseTestLocationDetailCode
				+ ", licenseTestLocationCode=" + licenseTestLocationCode + ", licenseTestLocationDetailClassroom="
				+ licenseTestLocationDetailClassroom + ", licenseTestLocationDetailUse=" + licenseTestLocationDetailUse
				+ ", licenseTestLocationDetailMaximumNumber=" + licenseTestLocationDetailMaximumNumber
				+ ", licenseTestLocationDetailUseInsertDate=" + licenseTestLocationDetailUseInsertDate + "]";
	}
	
	
}
