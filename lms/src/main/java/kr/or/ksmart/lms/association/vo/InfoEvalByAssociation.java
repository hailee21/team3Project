package kr.or.ksmart.lms.association.vo;

public class InfoEvalByAssociation {
	private String infoEvalByAssociationCode;
	private String infoEvalByAssociationSort;
	private String infoEvalByAssociationType;
	private String infoEvalByAssociationContents;
	private String infoEvalByAssociationEffectiveDate;
	private String infoEvalByAssociationInsertDate;
	
	public String getInfoEvalByAssociationCode() {
		return infoEvalByAssociationCode;
	}
	public void setInfoEvalByAssociationCode(String infoEvalByAssociationCode) {
		this.infoEvalByAssociationCode = infoEvalByAssociationCode;
	}
	public String getInfoEvalByAssociationSort() {
		return infoEvalByAssociationSort;
	}
	public void setInfoEvalByAssociationSort(String infoEvalByAssociationSort) {
		this.infoEvalByAssociationSort = infoEvalByAssociationSort;
	}
	public String getInfoEvalByAssociationType() {
		return infoEvalByAssociationType;
	}
	public void setInfoEvalByAssociationType(String infoEvalByAssociationType) {
		this.infoEvalByAssociationType = infoEvalByAssociationType;
	}
	public String getInfoEvalByAssociationContents() {
		return infoEvalByAssociationContents;
	}
	public void setInfoEvalByAssociationContents(String infoEvalByAssociationContents) {
		this.infoEvalByAssociationContents = infoEvalByAssociationContents;
	}
	public String getInfoEvalByAssociationEffectiveDate() {
		return infoEvalByAssociationEffectiveDate;
	}
	public void setInfoEvalByAssociationEffectiveDate(String infoEvalByAssociationEffectiveDate) {
		this.infoEvalByAssociationEffectiveDate = infoEvalByAssociationEffectiveDate;
	}
	public String getInfoEvalByAssociationInsertDate() {
		return infoEvalByAssociationInsertDate;
	}
	public void setInfoEvalByAssociationInsertDate(String infoEvalByAssociationInsertDate) {
		this.infoEvalByAssociationInsertDate = infoEvalByAssociationInsertDate;
	}
	
	@Override
	public String toString() {
		return "InfoEvalByAssociation [infoEvalByAssociationCode=" + infoEvalByAssociationCode
				+ ", infoEvalByAssociationSort=" + infoEvalByAssociationSort + ", infoEvalByAssociationType="
				+ infoEvalByAssociationType + ", infoEvalByAssociationContents=" + infoEvalByAssociationContents
				+ ", infoEvalByAssociationEffectiveDate=" + infoEvalByAssociationEffectiveDate
				+ ", infoEvalByAssociationInsertDate=" + infoEvalByAssociationInsertDate + "]";
	}
	
}
