package kr.or.ksmart.lms.institution.vo;

public class MemberTeacher {
	private String memberTeacherCode;
	private String teacherApprovalCode;
	private String memberCode;
	private String memberTeacherName;
	private String memberTeacherCareer;
	private String memberTeacherServiceCheck;

	public String getMemberTeacherCode() {
		return memberTeacherCode;
	}

	public void setMemberTeacherCode(String memberTeacherCode) {
		this.memberTeacherCode = memberTeacherCode;
	}

	public String getTeacherApprovalCode() {
		return teacherApprovalCode;
	}

	public void setTeacherApprovalCode(String teacherApprovalCode) {
		this.teacherApprovalCode = teacherApprovalCode;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberTeacherName() {
		return memberTeacherName;
	}

	public void setMemberTeacherName(String memberTeacherName) {
		this.memberTeacherName = memberTeacherName;
	}

	public String getMemberTeacherCareer() {
		return memberTeacherCareer;
	}

	public void setMemberTeacherCareer(String memberTeacherCareer) {
		this.memberTeacherCareer = memberTeacherCareer;
	}

	public String getMemberTeacherServiceCheck() {
		return memberTeacherServiceCheck;
	}

	public void setMemberTeacherServiceCheck(String memberTeacherServiceCheck) {
		this.memberTeacherServiceCheck = memberTeacherServiceCheck;
	}

	@Override
	public String toString() {
		return "MemberTeacher [memberCode=" + memberCode + ", memberTeacherCareer=" + memberTeacherCareer
				+ ", memberTeacherCode=" + memberTeacherCode + ", memberTeacherName=" + memberTeacherName
				+ ", memberTeacherServiceCheck=" + memberTeacherServiceCheck + ", teacherApprovalCode="
				+ teacherApprovalCode + "]";
	}
	

}
