package kr.or.ksmart.lms.pi.vo;

public class EvalInstitutionDetail {
	private String eval_institution_detail_code;
	private String eval_institution_by_student_code;
	private String member_code;
	private String member_name;
	private String info_eval_institution_by_student_code;
	private String info_eval_institution_by_student_contents;
	private int eval_institution_detail_score;
	
	public String getEval_institution_detail_code() {
		return eval_institution_detail_code;
	}
	public void setEval_institution_detail_code(String eval_institution_detail_code) {
		this.eval_institution_detail_code = eval_institution_detail_code;
	}
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
	public String getInfo_eval_institution_by_student_code() {
		return info_eval_institution_by_student_code;
	}
	public void setInfo_eval_institution_by_student_code(String info_eval_institution_by_student_code) {
		this.info_eval_institution_by_student_code = info_eval_institution_by_student_code;
	}
	public String getInfo_eval_institution_by_student_contents() {
		return info_eval_institution_by_student_contents;
	}
	public void setInfo_eval_institution_by_student_contents(String info_eval_institution_by_student_contents) {
		this.info_eval_institution_by_student_contents = info_eval_institution_by_student_contents;
	}
	public int getEval_institution_detail_score() {
		return eval_institution_detail_score;
	}
	public void setEval_institution_detail_score(int eval_institution_detail_score) {
		this.eval_institution_detail_score = eval_institution_detail_score;
	}
	@Override
	public String toString() {
		return "EvalInstitutionDetail [eval_institution_detail_code=" + eval_institution_detail_code
				+ ", eval_institution_by_student_code=" + eval_institution_by_student_code + ", member_code="
				+ member_code + ", member_name=" + member_name + ", info_eval_institution_by_student_code="
				+ info_eval_institution_by_student_code + ", info_eval_institution_by_student_contents="
				+ info_eval_institution_by_student_contents + ", eval_institution_detail_score="
				+ eval_institution_detail_score + "]";
	}


	
}
