package kr.or.ksmart.lms.institution.vo;

public class Classroom {
	private String classroomCode;
	private String institutionCode;
	private String institutionName;
	private String classroomLocation;
	private String classroomName;
	private String classroomUse;
	private String classroomMaximumNo;
	
	public String getClassroomCode() {
		return classroomCode;
	}
	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
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
	public String getClassroomLocation() {
		return classroomLocation;
	}
	public void setClassroomLocation(String classroomLocation) {
		this.classroomLocation = classroomLocation;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getClassroomUse() {
		return classroomUse;
	}
	public void setClassroomUse(String classroomUse) {
		this.classroomUse = classroomUse;
	}
	public String getClassroomMaximumNo() {
		return classroomMaximumNo;
	}
	public void setClassroomMaximumNo(String classroomMaximumNo) {
		this.classroomMaximumNo = classroomMaximumNo;
	}
	
	@Override
	public String toString() {
		return "Classroom [classroomCode=" + classroomCode + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", classroomLocation=" + classroomLocation
				+ ", classroomName=" + classroomName + ", classroomUse=" + classroomUse + ", classroomMaximumNo="
				+ classroomMaximumNo + "]";
	}	
}
