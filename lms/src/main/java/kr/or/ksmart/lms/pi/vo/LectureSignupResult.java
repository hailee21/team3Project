package kr.or.ksmart.lms.pi.vo;

public class LectureSignupResult {
	private String lectureSignupResultCode;
	private String lectureSignupCode;
	private int lectureSignupResult;
	private String noticeLectureCode;
	private String noticeLectureResultDate;
	private String institutionCode;
	private String institutionName;
	private String noticeLectureStartDate;
	private String lectureSignupResultDate;
	
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
	public int getLectureSignupResult() {
		return lectureSignupResult;
	}
	public void setLectureSignupResult(int lectureSignupResult) {
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
	public String getNoticeLectureStartDate() {
		return noticeLectureStartDate;
	}
	public void setNoticeLectureStartDate(String noticeLectureStartDate) {
		this.noticeLectureStartDate = noticeLectureStartDate;
	}
	public String getLectureSignupResultDate() {
		return lectureSignupResultDate;
	}
	public void setLectureSignupResultDate(String lectureSignupResultDate) {
		this.lectureSignupResultDate = lectureSignupResultDate;
	}
	
	@Override
	public String toString() {
		return "LectureSignupResult [lectureSignupResultCode=" + lectureSignupResultCode + ", lectureSignupCode="
				+ lectureSignupCode + ", lectureSignupResult=" + lectureSignupResult + ", noticeLectureCode="
				+ noticeLectureCode + ", noticeLectureResultDate=" + noticeLectureResultDate + ", institutionCode="
				+ institutionCode + ", institutionName=" + institutionName + ", noticeLectureStartDate="
				+ noticeLectureStartDate + ", lectureSignupResultDate=" + lectureSignupResultDate + "]";
	}	
}
