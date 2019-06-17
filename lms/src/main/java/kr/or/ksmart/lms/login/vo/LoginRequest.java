package kr.or.ksmart.lms.login.vo;

public class LoginRequest {
	private String memberOnlineId;
	private String memberOnlinePw;
	private String memberRank;
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
	@Override
	public String toString() {
		return "LoginRequest [memberOnlineId=" + memberOnlineId + ", memberOnlinePw=" + memberOnlinePw + ", memberRank="
				+ memberRank + "]";
	}
	
}
