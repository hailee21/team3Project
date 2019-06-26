package kr.or.ksmart.lms.association.vo;

public class Board {
	private String boardNo;
	private String boardContents;
	private String boardType;
	private String memberOnlineCode;
	private String memberOnlineId;
	private String memberName;
	private String institutionCode;
	private String institutionName;
	private String BoardDate;
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getMemberOnlineCode() {
		return memberOnlineCode;
	}
	public void setMemberOnlineCode(String memberOnlineCode) {
		this.memberOnlineCode = memberOnlineCode;
	}
	public String getMemberOnlineId() {
		return memberOnlineId;
	}
	public void setMemberOnlineId(String memberOnlineId) {
		this.memberOnlineId = memberOnlineId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public String getBoardDate() {
		return BoardDate;
	}
	public void setBoardDate(String boardDate) {
		BoardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardContents=" + boardContents + ", boardType=" + boardType
				+ ", memberOnlineCode=" + memberOnlineCode + ", memberOnlineId=" + memberOnlineId + ", memberName="
				+ memberName + ", institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", BoardDate=" + BoardDate + "]";
	}
	
}
