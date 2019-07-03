package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.Institution;
import kr.or.ksmart.lms.pi.vo.LectureSignup;
import kr.or.ksmart.lms.pi.vo.NoticeLecture;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@Mapper
public interface PILectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> piSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > piSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> piSelectSubjectListByLectureCode(String lectureCode);

	// 화면에 교육원명을 출력하기 위한 메서드
	public Institution piSelectInstitution(String institutionCode); 
	
	// 강의공고 목록 출력
	public List<NoticeLecture> piSelectNoticeLectureList(String institutionCode);
	// 세부 강의공고 조회
	public NoticeLecture piSelectNoticeLectureByNoticeLectureCode(String NoticeLectureCode);
	// 수강신청 메서드
	public void piInsertLectureSignup(LectureSignup lectureSignup);
}
