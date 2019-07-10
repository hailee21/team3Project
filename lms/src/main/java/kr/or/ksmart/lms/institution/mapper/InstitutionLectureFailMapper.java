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
	public List<NoticeLecture> institutionSelectFailWaitingList(String institutionCode);
	// 폐강 목록 출력
	public List<LectureFail> institutionSelectLectureFailList(String institutionCode);
	
	// 폐강추가화면입력을 위한 해당 대기 강의공고 출력
	public NoticeLecture institutionSelectNoticeLectureInfoToAddFailLectureByNoticeLectureCode(String noticeLectureCode);
	// 폐강추가
	public void institutionInsertLectureFail(LectureFail lectureFail);
	// 폐강 이후 notice_lecture테이블의 notice_lecture_status 컬럼 업데이터
	public void institutionUpdateNoticeLectureStatusByNoticeLectureCode(String noticeLectureCode);
}
