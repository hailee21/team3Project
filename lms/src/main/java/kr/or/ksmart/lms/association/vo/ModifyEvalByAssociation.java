package kr.or.ksmart.lms.association.vo;

import java.util.List;

public class ModifyEvalByAssociation {
	private List<String> evalByAssociationCode;
	private List<Integer> evalByAssociationScore;
	private String evalTotalCode;
	private String evalByAssociationMonth;

	public List<String> getEvalByAssociationCode() {
		return evalByAssociationCode;
	}

	public void setEvalByAssociationCode(List<String> evalByAssociationCode) {
		this.evalByAssociationCode = evalByAssociationCode;
	}

	public List<Integer> getEvalByAssociationScore() {
		return evalByAssociationScore;
	}

	public void setEvalByAssociationScore(List<Integer> evalByAssociationScore) {
		this.evalByAssociationScore = evalByAssociationScore;
	}

	public String getEvalTotalCode() {
		return evalTotalCode;
	}

	public void setEvalTotalCode(String evalTotalCode) {
		this.evalTotalCode = evalTotalCode;
	}

	public String getEvalByAssociationMonth() {
		return evalByAssociationMonth;
	}

	public void setEvalByAssociationMonth(String evalByAssociationMonth) {
		this.evalByAssociationMonth = evalByAssociationMonth;
	}

	@Override
	public String toString() {
		return "ModifyEvalByAssociation [evalByAssociationCode=" + evalByAssociationCode + ", evalByAssociationMonth="
				+ evalByAssociationMonth + ", evalByAssociationScore=" + evalByAssociationScore + ", evalTotalCode="
				+ evalTotalCode + "]";
	}
		
}
