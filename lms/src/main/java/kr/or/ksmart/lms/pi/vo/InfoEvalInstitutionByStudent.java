package kr.or.ksmart.lms.pi.vo;

public class InfoEvalInstitutionByStudent {

	private String infoEvalInstitutionByStudentCode;
	private String infoEvalInstitutionByStudentSort;	
	private String infoEvalInstitutionByStudentContents;
	private int infoEvalInstitutionByStudentYear;
	
	public String getInfoEvalInstitutionByStudentSort() {
		return infoEvalInstitutionByStudentSort;
	}
	public void setInfoEvalInstitutionByStudentSort(String infoEvalInstitutionByStudentSort) {
		this.infoEvalInstitutionByStudentSort = infoEvalInstitutionByStudentSort;
	}
	public String getInfoEvalInstitutionByStudentCode() {
		return infoEvalInstitutionByStudentCode;
	}
	public void setInfoEvalInstitutionByStudentCode(String infoEvalInstitutionByStudentCode) {
		this.infoEvalInstitutionByStudentCode = infoEvalInstitutionByStudentCode;
	}
	public String getInfoEvalInstitutionByStudentContents() {
		return infoEvalInstitutionByStudentContents;
	}
	public void setInfoEvalInstitutionByStudentContents(String infoEvalInstitutionByStudentContents) {
		this.infoEvalInstitutionByStudentContents = infoEvalInstitutionByStudentContents;
	}
	public int getInfoEvalInstitutionByStudentYear() {
		return infoEvalInstitutionByStudentYear;
	}
	public void setInfoEvalInstitutionByStudentYear(int infoEvalInstitutionByStudentYear) {
		this.infoEvalInstitutionByStudentYear = infoEvalInstitutionByStudentYear;
	}
	
	@Override
	public String toString() {
		return "InfoEvalInstitutionByStudent [infoEvalInstitutionByStudentCode=" + infoEvalInstitutionByStudentCode
				+ ", infoEvalInstitutionByStudentSort=" + infoEvalInstitutionByStudentSort
				+ ", infoEvalInstitutionByStudentContents=" + infoEvalInstitutionByStudentContents
				+ ", infoEvalInstitutionByStudentYear=" + infoEvalInstitutionByStudentYear + "]";
	}
	
	
	
	
	
	
	
	
}
