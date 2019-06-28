package kr.or.ksmart.lms.association.vo;

public class InfoLecture {
	private String infoLectureCode;
	private String infoLectureSort;
	private String infoLectureName;
	private String infoLectureDate;
	
	public String getInfoLectureCode() {
		return infoLectureCode;
	}
	public void setInfoLectureCode(String infoLectureCode) {
		this.infoLectureCode = infoLectureCode;
	}
	public String getInfoLectureSort() {
		return infoLectureSort;
	}
	public void setInfoLectureSort(String infoLectureSort) {
		this.infoLectureSort = infoLectureSort;
	}
	public String getInfoLectureName() {
		return infoLectureName;
	}
	public void setInfoLectureName(String infoLectureName) {
		this.infoLectureName = infoLectureName;
	}
	public String getInfoLectureDate() {
		return infoLectureDate;
	}
	public void setInfoLectureDate(String infoLectureDate) {
		this.infoLectureDate = infoLectureDate;
	}
	
	@Override
	public String toString() {
		return "InfoLecture [infoLectureCode=" + infoLectureCode + ", infoLectureSort=" + infoLectureSort
				+ ", infoLectureName=" + infoLectureName + ", infoLectureDate=" + infoLectureDate + "]";
	}
}
