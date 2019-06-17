package kr.or.ksmart.lms.lecture.vo;

public class InfoLecture {
	private String infoLectureCode;
	private String infoLectureSort;
	private String infoLectureName;
	private String infoLectureInsertDate;
	
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
	public String getInfoLectureInsertDate() {
		return infoLectureInsertDate;
	}
	public void setInfoLectureInsertDate(String infoLectureInsertDate) {
		this.infoLectureInsertDate = infoLectureInsertDate;
	}
	
	@Override
	public String toString() {
		return "InfoLecture [infoLectureCode=" + infoLectureCode + ", infoLectureSort=" + infoLectureSort
				+ ", infoLectureName=" + infoLectureName + ", infoLectureInsertDate=" + infoLectureInsertDate + "]";
	}
}
