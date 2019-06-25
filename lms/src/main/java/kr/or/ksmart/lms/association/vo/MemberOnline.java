package kr.or.ksmart.lms.association.vo;

public class MemberOnline {
	private String memberOnlineCode;
	private String memberCode;
	private String memberName;
	private String memberOnlineId;
	private String memberRank;
	private String institutionCode;
	private String institutionName;
	public String getMemberOnlineCode() {
		return memberOnlineCode;
	}
	public void setMemberOnlineCode(String memberOnlineCode) {
		this.memberOnlineCode = memberOnlineCode;
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
	public String getMemberOnlineId() {
		return memberOnlineId;
	}
	public void setMemberOnlineId(String memberOnlineId) {
		this.memberOnlineId = memberOnlineId;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
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
	@Override
	public String toString() {
		return "MemberOnline [memberOnlineCode=" + memberOnlineCode + ", memberCode=" + memberCode + ", memberName="
				+ memberName + ", memberOnlineId=" + memberOnlineId + ", memberRank=" + memberRank
				+ ", institutionCode=" + institutionCode + ", institutionName=" + institutionName + "]";
	}
	
}
