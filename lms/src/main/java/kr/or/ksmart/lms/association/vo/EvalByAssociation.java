package kr.or.ksmart.lms.association.vo;

public class EvalByAssociation {
	private String evalByAssociationCode;
	private String evalTotalCode;
	private String institutionCode;
	private String institutionName;
	private String infoEvalByAssociationCode;
	private String infoEvalByAssociationType;
	private String infoEvalByAssociationSort;
	private int evalByAssociationScore;
	private String evalByAssociationStartDate;
	private String evalByAssociationEndDate;
	private String evalByAssociationResultDate;

	public String getEvalByAssociationCode() {
		return evalByAssociationCode;
	}

	public void setEvalByAssociationCode(String evalByAssociationCode) {
		this.evalByAssociationCode = evalByAssociationCode;
	}

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

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInfoEvalByAssociationCode() {
		return infoEvalByAssociationCode;
	}

	public void setInfoEvalByAssociationCode(String infoEvalByAssociationCode) {
		this.infoEvalByAssociationCode = infoEvalByAssociationCode;
	}

	public String getInfoEvalByAssociationType() {
		return infoEvalByAssociationType;
	}

	public void setInfoEvalByAssociationType(String infoEvalByAssociationType) {
		this.infoEvalByAssociationType = infoEvalByAssociationType;
	}

	public String getInfoEvalByAssociationSort() {
		return infoEvalByAssociationSort;
	}

	public void setInfoEvalByAssociationSort(String infoEvalByAssociationSort) {
		this.infoEvalByAssociationSort = infoEvalByAssociationSort;
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
		return "EvalByAssociation [evalByAssociationCode=" + evalByAssociationCode + ", evalByAssociationEndDate=" + evalByAssociationEndDate
				+ ", evalByAssociationResultDate=" + evalByAssociationResultDate + ", evalByAssociationScore="
				+ evalByAssociationScore + ", evalByAssociationStartDate=" + evalByAssociationStartDate
				+ ", evalTotalCode=" + evalTotalCode + ", infoEvalByAssociationCode=" + infoEvalByAssociationCode
				+ ", infoEvalByAssociationSort=" + infoEvalByAssociationSort + ", infoEvalByAssociationType="
				+ infoEvalByAssociationType + ", institutionCode=" + institutionCode + ", institutionName="
				+ institutionName + "]";
	}
	
}
