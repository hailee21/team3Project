package kr.or.ksmart.lms.institution.vo;

public class InstitutionMember {
	private String memberCode;
	private String memberName;
	private String memberOnlineId;
	private String memberPhoneNumber;
	private String institutionCode;
	private String institutionName;
	private String memberRank;
	
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
	public String getMemberOnlineId() {
		return memberOnlineId;
	}
	public void setMemberOnlineId(String memberOnlineId) {
		this.memberOnlineId = memberOnlineId;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
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
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	
	@Override
	public String toString() {
		return "InstitutionMember [memberCode=" + memberCode + ", memberName=" + memberName + ", memberOnlineId="
				+ memberOnlineId + ", memberPhoneNumber=" + memberPhoneNumber + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", memberRank=" + memberRank + "]";
	}
	
}
