package kr.or.ksmart.lms.association.vo;

import java.util.List;

public class AddEvalByAssociation {
	private List<String> institutionCode;
	private List<String> infoEvalByAssociationCode;
	private int evalByAssociationScore;
	private String evalByAssociationStartDate;
	private String evalByAssociationEndDate;
	private String evalByAssociationResultDate;

	public List<String> getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(List<String> institutionCode) {
		this.institutionCode = institutionCode;
	}

	public List<String> getInfoEvalByAssociationCode() {
		return infoEvalByAssociationCode;
	}

	public void setInfoEvalByAssociationCode(List<String> infoEvalByAssociationCode) {
		this.infoEvalByAssociationCode = infoEvalByAssociationCode;
	}

	public int getEvalByAssociationScore() {
		return evalByAssociationScore;
	}

	public void setEvalByAssociationScore(int evalByAssociationScore) {
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

	public String getEvalByAssociationResultDate() {
		return evalByAssociationResultDate;
	}

	public void setEvalByAssociationResultDate(String evalByAssociationResultDate) {
		this.evalByAssociationResultDate = evalByAssociationResultDate;
	}

	@Override
	public String toString() {
		return "AddEvalByAssociation [evalByAssociationEndDate=" + evalByAssociationEndDate
				+ ", evalByAssociationResultDate=" + evalByAssociationResultDate + ", evalByAssociationScore="
				+ evalByAssociationScore + ", evalByAssociationStartDate=" + evalByAssociationStartDate
				+ ", infoEvalByAssociationCode=" + infoEvalByAssociationCode + ", institutionCode=" + institutionCode
				+ "]";
	}

	
	
}
