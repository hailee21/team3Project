package kr.or.ksmart.lms.association.vo;

public class InsertEvalTotal {
	private String evalTotalCode;
	private String institutionCode;
	private String evalTotalType;
	private int evalTotalYear;

	public String getEvalTotalCode() {
		return evalTotalCode;
	}

	public void setEvalTotalCode(String evalTotalCode) {
		this.evalTotalCode = evalTotalCode;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getEvalTotalType() {
		return evalTotalType;
	}

	public void setEvalTotalType(String evalTotalType) {
		this.evalTotalType = evalTotalType;
	}

	public int getEvalTotalYear() {
		return evalTotalYear;
	}

	public void setEvalTotalYear(int evalTotalYear) {
		this.evalTotalYear = evalTotalYear;
	}

	@Override
	public String toString() {
		return "InsertEvalTotal [evalTotalCode=" + evalTotalCode + ", evalTotalType=" + evalTotalType
				+ ", evalTotalYear=" + evalTotalYear + ", institutionCode=" + institutionCode + "]";
	}
	
}
