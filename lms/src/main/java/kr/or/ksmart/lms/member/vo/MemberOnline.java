package kr.or.ksmart.lms.member.vo;

public class MemberOnline {
	private String memberOnlineCode;
	private String memberCode;
	private String memberName;
	private String memberOnlineId;
	private String memberOnlinePw;
	private String memberRank;
	private String InstitutionCode;
	private String InstitutionName;
	
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
	public String getMemberOnlinePw() {
		return memberOnlinePw;
	}
	public void setMemberOnlinePw(String memberOnlinePw) {
		this.memberOnlinePw = memberOnlinePw;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	public String getInstitutionCode() {
		return InstitutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		InstitutionCode = institutionCode;
	}
	public String getInstitutionName() {
		return InstitutionName;
	}
	public void setInstitutionName(String institutionName) {
		InstitutionName = institutionName;
	}
	
	@Override
	public String toString() {
		return "MemberOnline [memberOnlineCode=" + memberOnlineCode + ", memberCode=" + memberCode + ", memberName="
				+ memberName + ", memberOnlineId=" + memberOnlineId + ", memberOnlinePw=" + memberOnlinePw
				+ ", memberRank=" + memberRank + ", InstitutionCode=" + InstitutionCode + ", InstitutionName="
				+ InstitutionName + "]";
	}
		
}
