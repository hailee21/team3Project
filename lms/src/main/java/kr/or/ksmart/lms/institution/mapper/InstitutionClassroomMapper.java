package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.Institution;

@Mapper
public interface InstitutionClassroomMapper {
	
	// 교육원명, 위치 조회 메서드
	public Institution institutionSelectInstitutionByInstitutionCode(String instCode);

	// 강의실용도 리스트 출력 메서드
	public List<Classroom> institutionSelectClassroomUse();
	// 강의실 테이블 pk가져오는 메서드
	public String institutionSelectClassroomPK();
	// 강의실 등록을 위해 교육원테이블에서 교육원명, 교육원위치를 가져오는 메서드
	public Institution institutionSelectInstitutionInfo(String instCode);
	// 강의실 등록 메서드
	public int institutionInsertClassroom(Classroom classroom); 
}
