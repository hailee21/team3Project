package kr.or.ksmart.lms.association.vo;

public class BoardComment {
	private String boardCommentNo;
	private String boardNo;
	private String boardCommentContents;
	private String memberOnlineCode;
	private String memberOnlineId;
	private String memberName;
	private String boardCommentDate;
	
	public String getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(String boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCommentContents() {
		return boardCommentContents;
	}
	public void setBoardCommentContents(String boardCommentContents) {
		this.boardCommentContents = boardCommentContents;
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
	public String getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(String boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}
	
	@Override
	public String toString() {
		return "BoardComment [boardCommentNo=" + boardCommentNo + ", boardNo=" + boardNo + ", boardCommentContents="
				+ boardCommentContents + ", memberOnlineCode=" + memberOnlineCode + ", memberOnlineId=" + memberOnlineId
				+ ", memberName=" + memberName + ", boardCommentDate=" + boardCommentDate + "]";
	}
	
}
