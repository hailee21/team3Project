package kr.or.ksmart.lms.pi.vo;

public class Institution {
	String institutionCode;
	String institutionName;
	String InstitutionPhone;
	String InstitutionPostcode;
	String InstitutionAddress;
	String InstitutionAddressDesc;
	String InstitutionLocation;
	String InstitutionRegistrationDate;
	
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
		return InstitutionPhone;
	}
	public void setInstitutionPhone(String institutionPhone) {
		InstitutionPhone = institutionPhone;
	}
	public String getInstitutionPostcode() {
		return InstitutionPostcode;
	}
	public void setInstitutionPostcode(String institutionPostcode) {
		InstitutionPostcode = institutionPostcode;
	}
	public String getInstitutionAddress() {
		return InstitutionAddress;
	}
	public void setInstitutionAddress(String institutionAddress) {
		InstitutionAddress = institutionAddress;
	}
	public String getInstitutionAddressDesc() {
		return InstitutionAddressDesc;
	}
	public void setInstitutionAddressDesc(String institutionAddressDesc) {
		InstitutionAddressDesc = institutionAddressDesc;
	}
	public String getInstitutionLocation() {
		return InstitutionLocation;
	}
	public void setInstitutionLocation(String institutionLocation) {
		InstitutionLocation = institutionLocation;
	}
	public String getInstitutionRegistrationDate() {
		return InstitutionRegistrationDate;
	}
	public void setInstitutionRegistrationDate(String institutionRegistrationDate) {
		InstitutionRegistrationDate = institutionRegistrationDate;
	}
	
	@Override
	public String toString() {
		return "Institution [institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", InstitutionPhone=" + InstitutionPhone + ", InstitutionPostcode=" + InstitutionPostcode
				+ ", InstitutionAddress=" + InstitutionAddress + ", InstitutionAddressDesc=" + InstitutionAddressDesc
				+ ", InstitutionLocation=" + InstitutionLocation + ", InstitutionRegistrationDate="
				+ InstitutionRegistrationDate + "]";
	}

}
