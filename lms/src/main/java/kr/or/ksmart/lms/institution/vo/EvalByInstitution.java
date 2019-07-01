package kr.or.ksmart.lms.institution.vo;

public class EvalByInstitution {
	private String evalByInstitutionCode;
	private String institutionCode;
	private String institutionName;
	private String memberTeacherCode;
	private String memberTeacherName;
	private String evalByInstitutionStartDate;
	private String evalByInstitutionEndDate;
	private String evalByInstitutionResultDate;

	public String getEvalByInstitutionCode() {
		return evalByInstitutionCode;
	}

	public void setEvalByInstitutionCode(String evalByInstitutionCode) {
		this.evalByInstitutionCode = evalByInstitutionCode;
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

	public String getEvalByInstitutionStartDate() {
		return evalByInstitutionStartDate;
	}

	public void setEvalByInstitutionStartDate(String evalByInstitutionStartDate) {
		this.evalByInstitutionStartDate = evalByInstitutionStartDate;
	}

	public String getEvalByInstitutionEndDate() {
		return evalByInstitutionEndDate;
	}

	public void setEvalByInstitutionEndDate(String evalByInstitutionEndDate) {
		this.evalByInstitutionEndDate = evalByInstitutionEndDate;
	}

	public String getEvalByInstitutionResultDate() {
		return evalByInstitutionResultDate;
	}

	public void setEvalByInstitutionResultDate(String evalByInstitutionResultDate) {
		this.evalByInstitutionResultDate = evalByInstitutionResultDate;
	}

	@Override
	public String toString() {
		return "EvalByInstitution [evalByInstitutionCode=" + evalByInstitutionCode + ", evalByInstitutionEndDate="
				+ evalByInstitutionEndDate + ", evalByInstitutionResultDate=" + evalByInstitutionResultDate
				+ ", evalByInstitutionStartDate=" + evalByInstitutionStartDate + ", institutionCode=" + institutionCode
				+ ", institutionName=" + institutionName + ", memberTeacherCode=" + memberTeacherCode
				+ ", memberTeacherName=" + memberTeacherName + "]";
	}
	
}
