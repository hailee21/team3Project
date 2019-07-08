package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Mapper
public interface InstitutionLectureFailMapper {
	
	// 폐강 세부조회
	public LectureFail institutionSelectLectureFailByLectureFailCode(String lectureFailCode);
	
	// 폐강 대기 목록 출력
	public List<NoticeLecture> institutionSelectFailWaitingList();
	// 폐강추가를위한 해당 대기 강의공고 출력
	public NoticeLecture institutionSelectNoticeLectureInfoToAddFailLectureByNoticeLectureCode(String noticeLectureCode);
	// 폐강추가
	public void institutionInsertLectureFail(LectureFail lectureFail);
	// 삭제
	public int institutionDeleteNoticeLectureAfterInsertLectureFailByNoticeLectureCode(String noticeLectureCode);
}
