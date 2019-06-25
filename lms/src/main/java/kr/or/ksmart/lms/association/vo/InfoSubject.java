package kr.or.ksmart.lms.association.vo;

public class InfoSubject {
	String infoSubjectCode;
	String infoLectureCode;
	String infoSubjectName;
	int infoSubjectDifficulty;
	String infoSubjectModificationHistory;
	
	public String getInfoSubjectCode() {
		return infoSubjectCode;
	}
	public void setInfoSubjectCode(String infoSubjectCode) {
		this.infoSubjectCode = infoSubjectCode;
	}
	public String getInfoLectureCode() {
		return infoLectureCode;
	}
	public void setInfoLectureCode(String infoLectureCode) {
		this.infoLectureCode = infoLectureCode;
	}
	public String getInfoSubjectName() {
		return infoSubjectName;
	}
	public void setInfoSubjectName(String infoSubjectName) {
		this.infoSubjectName = infoSubjectName;
	}
	public int getInfoSubjectDifficulty() {
		return infoSubjectDifficulty;
	}
	public void setInfoSubjectDifficulty(int infoSubjectDifficulty) {
		this.infoSubjectDifficulty = infoSubjectDifficulty;
	}
	public String getInfoSubjectModificationHistory() {
		return infoSubjectModificationHistory;
	}
	public void setInfoSubjectModificationHistory(String infoSubjectModificationHistory) {
		this.infoSubjectModificationHistory = infoSubjectModificationHistory;
	}
	
	@Override
	public String toString() {
		return "InfoSubject [infoSubjectCode=" + infoSubjectCode + ", infoLectureCode=" + infoLectureCode
				+ ", infoSubjectName=" + infoSubjectName + ", infoSubjectDifficulty=" + infoSubjectDifficulty
				+ ", infoSubjectModificationHistory=" + infoSubjectModificationHistory + "]";
	}
	
}
