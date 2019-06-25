package kr.or.ksmart.lms.pi.vo;

public class Institution {
	private String institutionCode;
	private String institutionName;
	private String institutionPhone;
	private String institutionPostcode;
	private String institutionAddress;
	private String institutionAddressDesc;
	private String institutionLocation;
	private String institutionRegistrationDate;

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

	public String getInstitutionPhone() {
		return institutionPhone;
	}

	public void setInstitutionPhone(String institutionPhone) {
		this.institutionPhone = institutionPhone;
	}

	public String getInstitutionPostcode() {
		return institutionPostcode;
	}

	public void setInstitutionPostcode(String institutionPostcode) {
		this.institutionPostcode = institutionPostcode;
	}

	public String getInstitutionAddress() {
		return institutionAddress;
	}

	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	public String getInstitutionAddressDesc() {
		return institutionAddressDesc;
	}

	public void setInstitutionAddressDesc(String institutionAddressDesc) {
		this.institutionAddressDesc = institutionAddressDesc;
	}

	public String getInstitutionLocation() {
		return institutionLocation;
	}

	public void setInstitutionLocation(String institutionLocation) {
		this.institutionLocation = institutionLocation;
	}

	public String getInstitutionRegistrationDate() {
		return institutionRegistrationDate;
	}

	public void setInstitutionRegistrationDate(String institutionRegistrationDate) {
		this.institutionRegistrationDate = institutionRegistrationDate;
	}

	@Override
	public String toString() {
		return "Institution [institutionAddress=" + institutionAddress + ", institutionAddressDesc="
				+ institutionAddressDesc + ", institutionCode=" + institutionCode + ", institutionLocation="
				+ institutionLocation + ", institutionName=" + institutionName + ", institutionPhone="
				+ institutionPhone + ", institutionPostcode=" + institutionPostcode + ", institutionRegistrationDate="
				+ institutionRegistrationDate + "]";
	}


}

