package kr.or.ksmart.lms.institution.vo;

public class LectureFail {
	private String lectureFailCode;
	private String noticeLectureCode;
	private String noticeLectureTitle;
	private String institutionCode;
	private String institutionName;
	private String memberTeacherCode;
	private String memberTeacherName;
	private String lectureStartDate;
	private String lectureEndDate;
	private String lectureFailReason;
	private String lectureFailDate;
	
	public String getLectureFailCode() {
		return lectureFailCode;
	}
	public void setLectureFailCode(String lectureFailCode) {
		this.lectureFailCode = lectureFailCode;
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
	public String getLectureStartDate() {
		return lectureStartDate;
	}
	public void setLectureStartDate(String lectureStartDate) {
		this.lectureStartDate = lectureStartDate;
	}
	public String getLectureEndDate() {
		return lectureEndDate;
	}
	public void setLectureEndDate(String lectureEndDate) {
		this.lectureEndDate = lectureEndDate;
	}
	public String getLectureFailReason() {
		return lectureFailReason;
	}
	public void setLectureFailReason(String lectureFailReason) {
		this.lectureFailReason = lectureFailReason;
	}
	public String getLectureFailDate() {
		return lectureFailDate;
	}
	public void setLectureFailDate(String lectureFailDate) {
		this.lectureFailDate = lectureFailDate;
	}
	
	@Override
	public String toString() {
		return "LectureFail [lectureFailCode=" + lectureFailCode + ", noticeLectureCode=" + noticeLectureCode
				+ ", noticeLectureTitle=" + noticeLectureTitle + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", memberTeacherCode=" + memberTeacherCode
				+ ", memberTeacherName=" + memberTeacherName + ", lectureStartDate=" + lectureStartDate
				+ ", lectureEndDate=" + lectureEndDate + ", lectureFailReason=" + lectureFailReason
				+ ", lectureFailDate=" + lectureFailDate + "]";
	}
}
