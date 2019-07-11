package kr.or.ksmart.lms.institution.vo;

public class LectureSignupResult {
	private String lectureSignupResultCode;
	private String lectureSignupCode;
	private Integer lectureSignupResult;
	private String noticeLectureCode;
	private String noticeLectureResultDate;
	private String instituitionCode;
	private String institutionName;
	private String noticeLectureStartDate;
	
	public String getLectureSignupResultCode() {
		return lectureSignupResultCode;
	}
	public void setLectureSignupResultCode(String lectureSignupResultCode) {
		this.lectureSignupResultCode = lectureSignupResultCode;
	}
	public String getLectureSignupCode() {
		return lectureSignupCode;
	}
	public void setLectureSignupCode(String lectureSignupCode) {
		this.lectureSignupCode = lectureSignupCode;
	}
	public Integer getLectureSignupResult() {
		return lectureSignupResult;
	}
	public void setLectureSignupResult(Integer lectureSignupResult) {
		this.lectureSignupResult = lectureSignupResult;
	}
	public String getNoticeLectureCode() {
		return noticeLectureCode;
	}
	public void setNoticeLectureCode(String noticeLectureCode) {
		this.noticeLectureCode = noticeLectureCode;
	}
	public String getNoticeLectureResultDate() {
		return noticeLectureResultDate;
	}
	public void setNoticeLectureResultDate(String noticeLectureResultDate) {
		this.noticeLectureResultDate = noticeLectureResultDate;
	}
	public String getInstituitionCode() {
		return instituitionCode;
	}
	public void setInstituitionCode(String instituitionCode) {
		this.instituitionCode = instituitionCode;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	@Override
	public String toString() {
		return "LectureSignupResult [lectureSignupResultCode=" + lectureSignupResultCode + ", lectureSignupCode="
				+ lectureSignupCode + ", lectureSignupResult=" + lectureSignupResult + ", noticeLectureCode="
				+ noticeLectureCode + ", noticeLectureResultDate=" + noticeLectureResultDate + ", instituitionCode="
				+ instituitionCode + ", institutionName=" + institutionName + ", noticeLectureStartDate="
				+ noticeLectureStartDate + "]";
	}	
}
