package kr.or.ksmart.lms.pi.vo;

public class Member {
	private String memberCode;
	private String memberName;
	private String memberRegistrationNumberFront;
	private String memberRegistrationNumberBack;
	private String memberPhoneNumber;
	private String memberPostcode;
	private String memberAddress;
	private String memberAddressDesc;
	private String memberRank;
	private String memberDate;
	
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
	public String getMemberRegistrationNumberFront() {
		return memberRegistrationNumberFront;
	}
	public void setMemberRegistrationNumberFront(String memberRegistrationNumberFront) {
		this.memberRegistrationNumberFront = memberRegistrationNumberFront;
	}
	public String getMemberRegistrationNumberBack() {
		return memberRegistrationNumberBack;
	}
	public void setMemberRegistrationNumberBack(String memberRegistrationNumberBack) {
		this.memberRegistrationNumberBack = memberRegistrationNumberBack;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getMemberPostcode() {
		return memberPostcode;
	}
	public void setMemberPostcode(String memberPostcode) {
		this.memberPostcode = memberPostcode;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberAddressDesc() {
		return memberAddressDesc;
	}
	public void setMemberAddressDesc(String memberAddressDesc) {
		this.memberAddressDesc = memberAddressDesc;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	public String getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}
	
	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberName=" + memberName + ", memberRegistrationNumberFront="
				+ memberRegistrationNumberFront + ", memberRegistrationNumberBack=" + memberRegistrationNumberBack
				+ ", memberPhoneNumber=" + memberPhoneNumber + ", memberPostcode=" + memberPostcode + ", memberAddress="
				+ memberAddress + ", memberAddressDesc=" + memberAddressDesc + ", memberRank=" + memberRank
				+ ", memberDate=" + memberDate + "]";
	}
	
}
