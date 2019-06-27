package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.Institution;
import kr.or.ksmart.lms.association.vo.MemberTeacher;
import kr.or.ksmart.lms.association.vo.NoticeLecture;

@Mapper
public interface AssociationNoticeLectureMapper {
	
	// 강의공고 등록
	// 1. 입력화면을 위한 준비
	// 1-1. infoLecture-sort select리스트 출력
	public List<InfoLecture> associationSelectInfoLectureSortForNL();	
	// 1-2. infoLecture-name select리스트 출력(비동기)
	public List<InfoLecture> associationSelectInfoLectureNameForNL(String infoLectureSort);
	// 1-3. memberTeacher select리스트 출력
	public List<MemberTeacher> associationSelectMemberTeacherForNL();
	// 1-4. institution select리스트 출력 
	public List<Institution> associationSelectInstitutionForNL();
	// 1-5. classroom select리스트 출력(비동기 - institutionCode로)
	public List<Classroom> associationSelectClassroomForNL(String institutionCode);
	
	// 2. PK생성을 위한 메서드
	public String associationSelectNoticeLecturePK();
	
	// 3. 강의공고 등록 
	public void associationInsertNoticeLecture(NoticeLecture noticeLecture);
	
	// 강의공고 목록 출력
	public List<NoticeLecture>associationSelectNoticeLectureList();
	// 세부 강의공고 조회
	public NoticeLecture associationSelectNoticeLectureByNoticeLectureCode(String NoticeLectureCode);
}
