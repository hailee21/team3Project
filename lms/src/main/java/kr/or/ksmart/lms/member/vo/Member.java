package kr.or.ksmart.lms.member.vo;

public class Member {
	private String member_code;
	private String member_name;
	private String member_registration_number_front;
	private String member_registration_number_back;
	private String member_phone_number;
	private String member_address;
	private String member_rank;
	@Override
	public String toString() {
		return "Member [member_code=" + member_code + ", member_name=" + member_name
				+ ", member_registration_number_front=" + member_registration_number_front
				+ ", member_registration_number_back=" + member_registration_number_back + ", member_phone_number="
				+ member_phone_number + ", member_address=" + member_address + ", member_rank=" + member_rank + "]";
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_registration_number_front() {
		return member_registration_number_front;
	}
	public void setMember_registration_number_front(String member_registration_number_front) {
		this.member_registration_number_front = member_registration_number_front;
	}
	public String getMember_registration_number_back() {
		return member_registration_number_back;
	}
	public void setMember_registration_number_back(String member_registration_number_back) {
		this.member_registration_number_back = member_registration_number_back;
	}
	public String getMember_phone_number() {
		return member_phone_number;
	}
	public void setMember_phone_number(String member_phone_number) {
		this.member_phone_number = member_phone_number;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_rank() {
		return member_rank;
	}
	public void setMember_rank(String member_rank) {
		this.member_rank = member_rank;
	}
}
