package kr.or.ksmart.lms.association.vo;

public class MemberInstitution {
	private String memberInstitutionCode;
	private String institutionApprovalCode;
	private String memberCode;
	private String memberName;
	private String memberInstitutionServiceCheck;
	private String memberInstitutionDate;
	
	public String getMemberInstitutionCode() {
		return memberInstitutionCode;
	}
	public void setMemberInstitutionCode(String memberInstitutionCode) {
		this.memberInstitutionCode = memberInstitutionCode;
	}
	public String getInstitutionApprovalCode() {
		return institutionApprovalCode;
	}
	public void setInstitutionApprovalCode(String institutionApprovalCode) {
		this.institutionApprovalCode = institutionApprovalCode;
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
	public String getMemberInstitutionServiceCheck() {
		return memberInstitutionServiceCheck;
	}
	public void setMemberInstitutionServiceCheck(String memberInstitutionServiceCheck) {
		this.memberInstitutionServiceCheck = memberInstitutionServiceCheck;
	}
	public String getMemberInstitutionDate() {
		return memberInstitutionDate;
	}
	public void setMemberInstitutionDate(String memberInstitutionDate) {
		this.memberInstitutionDate = memberInstitutionDate;
	}
	
	@Override
	public String toString() {
		return "MemberInstitution [memberInstitutionCode=" + memberInstitutionCode + ", institutionApprovalCode="
				+ institutionApprovalCode + ", memberCode=" + memberCode + ", memberName=" + memberName
				+ ", memberInstitutionServiceCheck=" + memberInstitutionServiceCheck + ", memberInstitutionDate="
				+ memberInstitutionDate + "]";
	}
	
}
