package kr.or.ksmart.lms.pi.vo;

public class NoticeLecture {
	private String noticeLectureCode;
	private String infoLectureCode;
	private String memberTeacherCode;
	private String memberTeacherName;
	private String classroomCode;
	private String noticeLectureTitle;
	private String institutionCode;
	private String institutionName;
	private int classroomMaximumNo;
	private int noticeLectureMinimumNo;
	private int noticeLectureCurrentApplicantNo;
	private String noticeLectureRecruitmentStartDate;
	private String noticeLectureRecruitmentEndDate;
	private String noticeLectureResultDate;
	private int noticeLectureFee;
	private String noticeLectureStartDate;
	private String noticeLectureEndDate;
	private String noticeLectureStatus;
	private String noticeLectureDate;
	
	public String getNoticeLectureStatus() {
		return noticeLectureStatus;
	}
	public void setNoticeLectureStatus(String noticeLectureStatus) {
		this.noticeLectureStatus = noticeLectureStatus;
	}	
	public String getNoticeLectureDate() {
		return noticeLectureDate;
	}
	public void setNoticeLectureDate(String noticeLectureDate) {
		this.noticeLectureDate = noticeLectureDate;
	}
	public String getNoticeLectureCode() {
		return noticeLectureCode;
	}
	public void setNoticeLectureCode(String noticeLectureCode) {
		this.noticeLectureCode = noticeLectureCode;
	}
	public String getInfoLectureCode() {
		return infoLectureCode;
	}
	public void setInfoLectureCode(String infoLectureCode) {
		this.infoLectureCode = infoLectureCode;
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
	public String getClassroomCode() {
		return classroomCode;
	}
	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
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
	public int getClassroomMaximumNo() {
		return classroomMaximumNo;
	}
	public void setClassroomMaximumNo(int classroomMaximumNo) {
		this.classroomMaximumNo = classroomMaximumNo;
	}
	public int getNoticeLectureMinimumNo() {
		return noticeLectureMinimumNo;
	}
	public void setNoticeLectureMinimumNo(int noticeLectureMinimumNo) {
		this.noticeLectureMinimumNo = noticeLectureMinimumNo;
	}
	public int getNoticeLectureCurrentApplicantNo() {
		return noticeLectureCurrentApplicantNo;
	}
	public void setNoticeLectureCurrentApplicantNo(int noticeLectureCurrentApplicantNo) {
		this.noticeLectureCurrentApplicantNo = noticeLectureCurrentApplicantNo;
	}
	public String getNoticeLectureRecruitmentStartDate() {
		return noticeLectureRecruitmentStartDate;
	}
	public void setNoticeLectureRecruitmentStartDate(String noticeLectureRecruitmentStartDate) {
		this.noticeLectureRecruitmentStartDate = noticeLectureRecruitmentStartDate;
	}
	public String getNoticeLectureRecruitmentEndDate() {
		return noticeLectureRecruitmentEndDate;
	}
	public void setNoticeLectureRecruitmentEndDate(String noticeLectureRecruitmentEndDate) {
		this.noticeLectureRecruitmentEndDate = noticeLectureRecruitmentEndDate;
	}
	public String getNoticeLectureResultDate() {
		return noticeLectureResultDate;
	}
	public void setNoticeLectureResultDate(String noticeLectureResultDate) {
		this.noticeLectureResultDate = noticeLectureResultDate;
	}
	public int getNoticeLectureFee() {
		return noticeLectureFee;
	}
	public void setNoticeLectureFee(int noticeLectureFee) {
		this.noticeLectureFee = noticeLectureFee;
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
	
	@Override
	public String toString() {
		return "NoticeLecture [noticeLectureCode=" + noticeLectureCode + ", infoLectureCode=" + infoLectureCode
				+ ", memberTeacherCode=" + memberTeacherCode + ", memberTeacherName=" + memberTeacherName
				+ ", classroomCode=" + classroomCode + ", noticeLectureTitle=" + noticeLectureTitle
				+ ", institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", classroomMaximumNo=" + classroomMaximumNo + ", noticeLectureMinimumNo=" + noticeLectureMinimumNo
				+ ", noticeLectureCurrentApplicantNo=" + noticeLectureCurrentApplicantNo
				+ ", noticeLectureRecruitmentStartDate=" + noticeLectureRecruitmentStartDate
				+ ", noticeLectureRecruitmentEndDate=" + noticeLectureRecruitmentEndDate + ", noticeLectureResultDate="
				+ noticeLectureResultDate + ", noticeLectureFee=" + noticeLectureFee + ", noticeLectureStartDate="
				+ noticeLectureStartDate + ", noticeLectureEndDate=" + noticeLectureEndDate
				+ ", noticeLectureStatus=" + noticeLectureStatus + ", noticeLectureDate=" + noticeLectureDate
				+ "]";
	}	
}
