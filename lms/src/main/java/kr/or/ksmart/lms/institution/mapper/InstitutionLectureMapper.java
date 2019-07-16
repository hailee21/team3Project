package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Lecture;
import kr.or.ksmart.lms.institution.vo.LectureSignup;
import kr.or.ksmart.lms.institution.vo.LectureSignupResultDomain;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;

@Mapper
public interface InstitutionLectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> institutionSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > institutionSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> institutionSelectSubjectListByLectureCode(String lectureCode);
	
	// detailSubject 조회 메서드
	public InfoSubject institutionSelectDetailSubjectByInfoSubjectCode(String infoSubjectCode);
	
	// 강의등록 준비
	// 1. notice_lecture에서 모집완료 상태인 강의공고 조회하는 메서드
	public List<NoticeLecture> institutionSelectNoticeLectureListForInsertLecture();
	// 2. lecture테이블 내 중복 조회
	public Lecture institutionLectureCheck(String noticeLectureCode);
	// 3. 강의등록 메서드
	public void institutionInsertLecture(Lecture lecture);
	// 4. 강의등록 후 notice_lecture테이블의 notice_lecture_status 업데이트
	public void institutionUpdateLastNoticeLectureStatusByNoticeLectureCode(String noticeLectureCode);
	
	// 강의 목록 조회
	// lecture 리스트 조회하는 메서드 
	public List<Lecture> institutionSelectLectureListByInstitutionCode(String institutionCode);
	// detailLecture 조회하는 메서드
	public Lecture institutionSelectDetailLectureByLectureCode(String lectureCode);
	
	// 면접결과 등록 준비
	// 1. 해당 강의공고 선택을 위한 list 출력
	public List<NoticeLecture> institutionSelectNoticeLectureListByInstitutionCode(String institutionCode);
	// 해당 강의공고 내용 출력
	public NoticeLecture institutionSelectNoticeLectureByNoticeLectureCode(String noticeLectureCode);
	// 2. 해당 강의공고를 수강신청한 학생들 목록 출력
	public List<LectureSignup> institutionSelectLectureSignupListByNoticeLectureCode(String noticeLectureCode);
	// 3. 면접결과 등록 후 insert처리
	public void institutionInsertLectureSignupResult(LectureSignupResultDomain lectureSignupResultDomain);
	// 4. 강의공고 모집상태 선택
	public NoticeLecture institutionSelectNoticeLectureStatusByNoticeLectureCode(String noticeLectureCode);
	// 5. 강의공고 모집ㅈ상태 수정
	public void institutionUpdateNoticeLectureStatusByNoticeLectureCode(String noticeLectureCode);
	
}
