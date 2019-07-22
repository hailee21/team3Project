package kr.or.ksmart.lms.pi.vo;

public class PaymentLecture {
	private String paymentLectureCode;
	private String noticeLectureCode;
	private String memberCode;
	private String memberOnlineId;
	private String memberRegistrationNumberFront;
	private String memberName;
	private int paymentLecturePrice;
	private String paymentLectureDate;
	
	public String getPaymentLectureCode() {
		return paymentLectureCode;
	}
	public void setPaymentLectureCode(String paymentLectureCode) {
		this.paymentLectureCode = paymentLectureCode;
	}
	public String getNoticeLectureCode() {
		return noticeLectureCode;
	}
	public void setNoticeLectureCode(String noticeLectureCode) {
		this.noticeLectureCode = noticeLectureCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberOnlineId() {
		return memberOnlineId;
	}
	public void setMemberOnlineId(String memberOnlineId) {
		this.memberOnlineId = memberOnlineId;
	}
	public String getMemberRegistrationNumberFront() {
		return memberRegistrationNumberFront;
	}
	public void setMemberRegistrationNumberFront(String memberRegistrationNumberFront) {
		this.memberRegistrationNumberFront = memberRegistrationNumberFront;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getPaymentLecturePrice() {
		return paymentLecturePrice;
	}
	public void setPaymentLecturePrice(int paymentLecturePrice) {
		this.paymentLecturePrice = paymentLecturePrice;
	}
	public String getPaymentLectureDate() {
		return paymentLectureDate;
	}
	public void setPaymentLectureDate(String paymentLectureDate) {
		this.paymentLectureDate = paymentLectureDate;
	}
	
	@Override
	public String toString() {
		return "PaymentLecture [paymentLectureCode=" + paymentLectureCode + ", noticeLectureCode=" + noticeLectureCode
				+ ", memberCode=" + memberCode + ", memberOnlineId=" + memberOnlineId
				+ ", memberRegistrationNumberFront=" + memberRegistrationNumberFront + ", memberName=" + memberName
				+ ", paymentLecturePrice=" + paymentLecturePrice + ", paymentLectureDate=" + paymentLectureDate + "]";
	}
}
