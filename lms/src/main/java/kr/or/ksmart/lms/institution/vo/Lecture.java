package kr.or.ksmart.lms.institution.vo;

public class Lecture {
	private String lectureCode;
	private String noticeLectureCode;
	private String noticeLectureTitle;
	private String infoLectureCode;
	private String institutionCode;
	private String institutionName;
	private String memberTeacherCode;
	private String memberTeacherName;
	private String noticeLectureStartDate;
	private String noticeLectureEndDate;
	private String lectureClassDays;
	private String lectureDate;
	
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
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
	public String getInfoLectureCode() {
		return infoLectureCode;
	}
	public void setInfoLectureCode(String infoLectureCode) {
		this.infoLectureCode = infoLectureCode;
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
	public String getMemberTeacherCode() {
		return memberTeacherCode;
	}
	public void setMemberTeacherCode(String memberTeacherCode) {
		this.memberTeacherCode = memberTeacherCode;
	}
	public String getMemberTeacherName() {
		return memberTeacherName;
	}
	public void setMemberTeacherName(String memberTeacherName) {
		this.memberTeacherName = memberTeacherName;
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
	public String getLectureClassDays() {
		return lectureClassDays;
	}
	public void setLectureClassDays(String lectureClassDays) {
		this.lectureClassDays = lectureClassDays;
	}
	public String getLectureDate() {
		return lectureDate;
	}
	public void setLectureDate(String lectureDate) {
		this.lectureDate = lectureDate;
	}
	
	@Override
	public String toString() {
		return "Lecture [lectureCode=" + lectureCode + ", noticeLectureCode=" + noticeLectureCode
				+ ", noticeLectureTitle=" + noticeLectureTitle + ", infoLectureCode=" + infoLectureCode
				+ ", institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", memberTeacherCode=" + memberTeacherCode + ", memberTeacherName=" + memberTeacherName
				+ ", noticeLectureStartDate=" + noticeLectureStartDate + ", noticeLectureEndDate=" + noticeLectureEndDate
				+ ", lectureClassDays=" + lectureClassDays + ", lectureDate=" + lectureDate + "]";
	}
}
