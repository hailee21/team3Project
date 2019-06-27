package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.Institution;

@Mapper
public interface AssociationClassroomMapper {
	
	// 교육원명, 위치 조회 메서드
	public Institution associationSelectInstitutionByInstitutionCode(String instCode);

	// 강의실용도 리스트 출력 메서드
	public List<Classroom> associationSelectClassroomUse();
	// 강의실 테이블 pk가져오는 메서드
	public String associationSelectClassroomPK();
	// 강의실 등록을 위해 교육원테이블에서 교육원명, 교육원위치를 가져오는 메서드
	public Institution associationSelectInstitutionInfo(String instCode);
	// 강의실 등록 메서드
	public void associationInsertClassroom(Classroom classroom); 
	
	// 강의실 목록 출력
	public List<Classroom> associationSelectClassroomList();
	// 교육원위치(키워드)로 강의실 조회 메서드
	public List<Classroom> associationSelectClassroomListByKeyword(String classroomLocation);
	
	// 강의실 수정, 삭제
	// 1. 강의실코드로 강의실 상세정보 불러오기
	public Classroom selectClassroomByClassroomCode(String classroomCode);
}
