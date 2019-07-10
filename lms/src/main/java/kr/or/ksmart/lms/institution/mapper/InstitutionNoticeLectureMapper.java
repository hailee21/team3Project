package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.MemberTeacher;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Mapper
public interface InstitutionNoticeLectureMapper {
	
	// 강의공고 등록
	// 1. 입력화면을 위한 준비
	// 1-1. infoLecture-sort select리스트 출력
	public List<InfoLecture> institutionSelectInfoLectureSortForNL();	
	// 1-2. infoLecture-name select리스트 출력(비동기)
	public List<InfoLecture> institutionSelectInfoLectureNameForNL(String infoLectureSort);
	// 1-3. memberTeacher select리스트 출력
	public List<MemberTeacher> institutionSelectMemberTeacherForNL();
	// 1-4. institution select리스트 출력 
	public List<Institution> institutionSelectInstitutionForNL();
	// 1-5. classroom select리스트 출력(동기 - institutionCode로)
	public List<Classroom> institutionSelectClassroomByInstitutionCode(String institutionCode);

	
	// 2. 강의공고 등록 
	public void institutionInsertNoticeLecture(NoticeLecture noticeLecture);
	
	// 강의공고 목록 출력
		// 1. 현재 진행중인 목록 출력
		public List<NoticeLecture> institutionSelectNoticeLectureList(String institutionCode);
		// 2. 폐강목록 출력 
		public List<LectureFail> institutionSelectLectureFailList(String institutionCode);
	// 세부 강의공고 조회
	public NoticeLecture institutionSelectNoticeLectureByNoticeLectureCode(String NoticeLectureCode);
}
