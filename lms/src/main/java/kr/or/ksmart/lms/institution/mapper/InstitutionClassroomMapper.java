package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.Institution;

@Mapper
public interface InstitutionClassroomMapper {

	// 강의실용도 리스트 출력 메서드
	public List<Classroom> institutionSelectClassroomUse();	
	
	// 강의실 등록 메서드
	// 1. 교육원코드, 교육원명 조회 메서드
	public Institution institutionSelectInstitutionByInstitutionCode(String institutionCode);
	// 2. 강의실 등록 메서드	
	public int institutionInsertClassroom(Classroom classroom); 
	
	// 강의실 리스트 조회 메서드
	public List<Classroom> institutionSelectClassroomListByInstitutionCode(String institutionCode);
	// 강의실 상세조회 메서드
	public Classroom institutionSelectDetailClassroomByClassroomCode(String classroomCode);
}
