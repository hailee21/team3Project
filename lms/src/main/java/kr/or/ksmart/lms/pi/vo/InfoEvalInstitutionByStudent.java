package kr.or.ksmart.lms.pi.vo;

public class InfoEvalInstitutionByStudent {

	private String info_eval_institution_by_student_code;
	private String info_eval_institution_by_student_contents;
	private String info_eval_institution_by_student_year;
	
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
	public String getInfo_eval_institution_by_student_year() {
		return info_eval_institution_by_student_year;
	}
	public void setInfo_eval_institution_by_student_year(String info_eval_institution_by_student_year) {
		this.info_eval_institution_by_student_year = info_eval_institution_by_student_year;
	}
	
	@Override
	public String toString() {
		return "EvalInstitutionByStudent [info_eval_institution_by_student_code="
				+ info_eval_institution_by_student_code + ", info_eval_institution_by_student_contents="
				+ info_eval_institution_by_student_contents + ", info_eval_institution_by_student_year="
				+ info_eval_institution_by_student_year + "]";
	}
	
	
	
	
	
}
