package kr.or.ksmart.lms.association.vo;

public class LicenseTestLocation {
    private String licenseTestLocationCode;
    private String licenseTestLocationRegion;
    private String licenseTestLocationAddress;
    private String licenseTestLocationAddressDetail;
    private String licenseTestLocationUse;
    private int licenseTestLocationMaximumNumber;
    private String licenseTestLocationInsertDate;
	public String getLicenseTestLocationCode() {
		return licenseTestLocationCode;
	}
	public void setLicenseTestLocationCode(String licenseTestLocationCode) {
		this.licenseTestLocationCode = licenseTestLocationCode;
	}
	public String getLicenseTestLocationRegion() {
		return licenseTestLocationRegion;
	}
	public void setLicenseTestLocationRegion(String licenseTestLocationRegion) {
		this.licenseTestLocationRegion = licenseTestLocationRegion;
	}
	public String getLicenseTestLocationAddress() {
		return licenseTestLocationAddress;
	}
	public void setLicenseTestLocationAddress(String licenseTestLocationAddress) {
		this.licenseTestLocationAddress = licenseTestLocationAddress;
	}
	public String getLicenseTestLocationAddressDetail() {
		return licenseTestLocationAddressDetail;
	}
	public void setLicenseTestLocationAddressDetail(String licenseTestLocationAddressDetail) {
		this.licenseTestLocationAddressDetail = licenseTestLocationAddressDetail;
	}
	public String getLicenseTestLocationUse() {
		return licenseTestLocationUse;
	}
	public void setLicenseTestLocationUse(String licenseTestLocationUse) {
		this.licenseTestLocationUse = licenseTestLocationUse;
	}
	public int getLicenseTestLocationMaximumNumber() {
		return licenseTestLocationMaximumNumber;
	}
	public void setLicenseTestLocationMaximumNumber(int licenseTestLocationMaximumNumber) {
		this.licenseTestLocationMaximumNumber = licenseTestLocationMaximumNumber;
	}
	public String getLicenseTestLocationInsertDate() {
		return licenseTestLocationInsertDate;
	}
	public void setLicenseTestLocationInsertDate(String licenseTestLocationInsertDate) {
		this.licenseTestLocationInsertDate = licenseTestLocationInsertDate;
	}
	@Override
	public String toString() {
		return "LicenseTestLocation [licenseTestLocationCode=" + licenseTestLocationCode
				+ ", licenseTestLocationRegion=" + licenseTestLocationRegion + ", licenseTestLocationAddress="
				+ licenseTestLocationAddress + ", licenseTestLocationAddressDetail=" + licenseTestLocationAddressDetail
				+ ", licenseTestLocationUse=" + licenseTestLocationUse + ", licenseTestLocationMaximumNumber="
				+ licenseTestLocationMaximumNumber + ", licenseTestLocationInsertDate=" + licenseTestLocationInsertDate
				+ "]";
	}
    
}