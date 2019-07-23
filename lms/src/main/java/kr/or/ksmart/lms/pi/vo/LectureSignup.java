package kr.or.ksmart.lms.pi.vo;

public class LectureSignup {
	private String lectureSignupCode;
	private String noticeLectureCode;
	private String noticeLectureTitle;
	private String noticeLectureStartDate;
	private String noticeLectureEndDate;
	private String institutionCode;
	private String institutionName;
	private String memberCode;
	private String memberName;
	private String memberRegistrationNumberFront;
	private String lectureSignupDate;
	
	public String getLectureSignupCode() {
		return lectureSignupCode;
	}
	public void setLectureSignupCode(String lectureSignupCode) {
		this.lectureSignupCode = lectureSignupCode;
	}
	public String getNoticeLectureCode() {
		return noticeLectureCode;
	}
	public void setNoticeLectureCode(String noticeLectureCode) {
		this.noticeLectureCode = noticeLectureCode;
	}
	public String getNoticeLectureTitle() {
		return noticeLectureTitle;
	}
	public void setNoticeLectureTitle(String noticeLectureTitle) {
		this.noticeLectureTitle = noticeLectureTitle;
	}
	public String getNoticeLectureStartDate() {
		return noticeLectureStartDate;
	}
	public void setNoticeLectureStartDate(String noticeLectureStartDate) {
		this.noticeLectureStartDate = noticeLectureStartDate;
	}
	public String getNoticeLectureEndDate() {
		return noticeLectureEndDate;
	}
	public void setNoticeLectureEndDate(String noticeLectureEndDate) {
		this.noticeLectureEndDate = noticeLectureEndDate;
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
	public String getLectureSignupDate() {
		return lectureSignupDate;
	}
	public void setLectureSignupDate(String lectureSignupDate) {
		this.lectureSignupDate = lectureSignupDate;
	}
	
	@Override
	public String toString() {
		return "LectureSignup [lectureSignupCode=" + lectureSignupCode + ", noticeLectureCode=" + noticeLectureCode
				+ ", noticeLectureTitle=" + noticeLectureTitle + ", noticeLectureStartDate=" + noticeLectureStartDate
				+ ", noticeLectureEndDate=" + noticeLectureEndDate + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", memberCode=" + memberCode + ", memberName=" + memberName
				+ ", memberRegistrationNumberFront=" + memberRegistrationNumberFront + ", lectureSignupDate="
				+ lectureSignupDate + "]";
	}	
}
