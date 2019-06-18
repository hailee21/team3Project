package kr.or.ksmart.lms.index.vo;

public class IndexInstitution {
	private String institutionCode;
	private String institutionName;
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
	@Override
	public String toString() {
		return "IndexInstitution [institutionCode=" + institutionCode + ", institutionName=" + institutionName + "]";
	}
}
