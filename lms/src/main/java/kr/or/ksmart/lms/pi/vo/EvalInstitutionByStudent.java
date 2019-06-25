package kr.or.ksmart.lms.pi.vo;

public class EvalInstitutionByStudent {
	
	private String eval_institution_by_student_code;
	private String member_code;
	private String member_name;
	private String institution_code;
	private String institution_name;
	private String eval_institution_by_student_date;
	
	public String getEval_institution_by_student_code() {
		return eval_institution_by_student_code;
	}
	public void setEval_institution_by_student_code(String eval_institution_by_student_code) {
		this.eval_institution_by_student_code = eval_institution_by_student_code;
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
	public String getInstitution_code() {
		return institution_code;
	}
	public void setInstitution_code(String institution_code) {
		this.institution_code = institution_code;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public String getEval_institution_by_student_date() {
		return eval_institution_by_student_date;
	}
	public void setEval_institution_by_student_date(String eval_institution_by_student_date) {
		this.eval_institution_by_student_date = eval_institution_by_student_date;
	}
	@Override
	public String toString() {
		return "EvalInstitutionByStudent [eval_institution_by_student_code=" + eval_institution_by_student_code
				+ ", member_code=" + member_code + ", member_name=" + member_name + ", institution_code="
				+ institution_code + ", institution_name=" + institution_name + ", eval_institution_by_student_date="
				+ eval_institution_by_student_date + "]";
	}

	


}
