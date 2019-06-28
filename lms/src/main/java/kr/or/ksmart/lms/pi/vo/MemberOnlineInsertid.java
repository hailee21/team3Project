package kr.or.ksmart.lms.pi.vo;

public class MemberOnlineInsertid {
	private String memberOnlineId;
	private String memberOnlineIdInsertDate;
	
	public String getMemberOnlineId() {
		return memberOnlineId;
	}
	public void setMemberOnlineId(String memberOnlineId) {
		this.memberOnlineId = memberOnlineId;
	}
	public String getMemberOnlineIdInsertDate() {
		return memberOnlineIdInsertDate;
	}
	public void setMemberOnlineIdInsertDate(String memberOnlineIdInsertDate) {
		this.memberOnlineIdInsertDate = memberOnlineIdInsertDate;
	}
	
	@Override
	public String toString() {
		return "MemberOnlineInsertid [memberOnlineId=" + memberOnlineId + ", memberOnlineIdInsertDate="
				+ memberOnlineIdInsertDate + "]";
	}
	
}
