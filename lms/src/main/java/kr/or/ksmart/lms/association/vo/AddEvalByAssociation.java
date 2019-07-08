package kr.or.ksmart.lms.association.vo;

import java.util.List;

public class AddEvalByAssociation {
	private String institutionCode;
	private String evalTotalCode;
	private List<String> infoEvalByAssociationCode;
	private int year;
	private List<Integer> evalByAssociationScore;
	private String evalByAssociationStartDate;
	private String evalByAssociationEndDate;
	private String evalByAssociationMonth;
	private String evalByAssociationResultDate;

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getEvalTotalCode() {
		return evalTotalCode;
	}

	public void setEvalTotalCode(String evalTotalCode) {
		this.evalTotalCode = evalTotalCode;
	}

	public List<String> getInfoEvalByAssociationCode() {
		return infoEvalByAssociationCode;
	}

	public void setInfoEvalByAssociationCode(List<String> infoEvalByAssociationCode) {
		this.infoEvalByAssociationCode = infoEvalByAssociationCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Integer> getEvalByAssociationScore() {
		return evalByAssociationScore;
	}

	public void setEvalByAssociationScore(List<Integer> evalByAssociationScore) {
		this.evalByAssociationScore = evalByAssociationScore;
	}

	public String getEvalByAssociationStartDate() {
		return evalByAssociationStartDate;
	}

	public void setEvalByAssociationStartDate(String evalByAssociationStartDate) {
		this.evalByAssociationStartDate = evalByAssociationStartDate;
	}

	public String getEvalByAssociationEndDate() {
		return evalByAssociationEndDate;
	}

	public void setEvalByAssociationEndDate(String evalByAssociationEndDate) {
		this.evalByAssociationEndDate = evalByAssociationEndDate;
	}

	public String getEvalByAssociationMonth() {
		return evalByAssociationMonth;
	}

	public void setEvalByAssociationMonth(String evalByAssociationMonth) {
		this.evalByAssociationMonth = evalByAssociationMonth;
	}

	public String getEvalByAssociationResultDate() {
		return evalByAssociationResultDate;
	}

	public void setEvalByAssociationResultDate(String evalByAssociationResultDate) {
		this.evalByAssociationResultDate = evalByAssociationResultDate;
	}

	@Override
	public String toString() {
		return "AddEvalByAssociation [evalByAssociationEndDate=" + evalByAssociationEndDate
				+ ", evalByAssociationMonth=" + evalByAssociationMonth + ", evalByAssociationResultDate="
				+ evalByAssociationResultDate + ", evalByAssociationScore=" + evalByAssociationScore
				+ ", evalByAssociationStartDate=" + evalByAssociationStartDate + ", evalTotalCode=" + evalTotalCode
				+ ", infoEvalByAssociationCode=" + infoEvalByAssociationCode + ", institutionCode=" + institutionCode
				+ ", year=" + year + "]";
	}
	
}
