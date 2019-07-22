package kr.or.ksmart.lms.pi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.Institution;
import kr.or.ksmart.lms.pi.vo.LectureSignup;
import kr.or.ksmart.lms.pi.vo.LectureSignupResult;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.NoticeLecture;
import kr.or.ksmart.lms.pi.vo.PaymentLecture;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@Mapper
public interface PILectureMapper {
	
	// 화면에 교육원명을 출력하기 위한 메서드
	public Institution piSelectInstitution(String institutionCode); 
	// 회원정보 조회를 위한 메서드
	public Member piSelectMemberInfo(String memberCode);
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> piSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > piSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> piSelectSubjectListByLectureCode(String lectureCode);
	
	// 강의공고 목록 출력
	public List<NoticeLecture> piSelectNoticeLectureList(String institutionCode);
	// 세부 강의공고 조회
	public NoticeLecture piSelectNoticeLectureByNoticeLectureCode(String NoticeLectureCode);
	// 수강신청 중복검사 메서드
	public LectureSignup piLectureSignupCheck(Map<String, Object> map);
	// 수강신청 메서드
	public void piInsertLectureSignup(LectureSignup lectureSignup);
	// 수강신청과 동시에 notice_lecture테이블의 notice_lecture_current_applicant_no컬럼 수 업데이트를 위한 준비
	// Select
	public Integer piSelectNoticeLectureCurrentApplicantNoByNoticeLectureCode(String NoticeLectureCode);
	// Update
	public void piUpdateNoticeLectureCurrentApplicationNoWithNoticeLectureCode(Map<String, Object> map);
	
	// 수강생 - 수강신청 내역 조회, 결제
	// 1. 수강신청 조회
		// 1-1. 수강신청 내역 조회
		public List<LectureSignup> piSelectLectureSignupListByMemberCode(String memberCode);
		// 1-2. 수강신청 내역 상세조회
		public LectureSignupResult piSelectLectureSignupResultBylectureSignupCode(String lectureSignupCode);
		// 1-3. 결제내역 중복조회
		public PaymentLecture piPaymentLectureCheck(Map<String, Object> map);
	// 2. 수강신청 결제
		// 2-1. 결제등록창을 위한 준비 (회원정보 가져오기)
		public PaymentLecture piSelectMemberInfoByMemberCode(String memberCode);
		// 2-2. 결제등록창을 위한 준비 (강의공고정보 가져오기)
		public PaymentLecture piSelectNoticeLectureInfoByNoticeLectureCode(String noticeLectureCode);
		
}
