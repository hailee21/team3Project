package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionClassroomMapper;
import kr.or.ksmart.lms.institution.vo.Classroom;

@Service
public class InstitutionClassroomService {
	@Autowired InstitutionClassroomMapper institutionClassroomMapper;
	
	// 강의실 등록을 위한 메서드
	
	// 강의실 리스트 조회를 위한 메서드 
	public List<Classroom> institutionGetClassroomListByInstitutionCode(String institutionCode){
		System.out.println("[InstitutionClassroomService institutionGetClassroomListByInstitutionCode] institutionCode: "+institutionCode);
		
		// 유효성 검사를 위해 mapper에서 리턴받은 강의실리스트의 값을 list객체참조변수 내에 담아 controller로 리턴한다. 
		List<Classroom> list = institutionClassroomMapper.institutionSelectClassroomListByInstitutionCode(institutionCode);
		System.out.println("[InstitutionClassroomService institutionGetClassroomListByInstitutionCode] list: "+list);
		return list;
	}
	
	// 강의실 상세보기 메서드
	public Classroom institutionGetDetailClassroomByClassroomCode(String classroomCode) {
System.out.println("[InstitutionClassroomService institutionGetClassroomListByInstitutionCode] classroomCode: "+classroomCode);
		
		// 유효성 검사를 위해 mapper에서 리턴받은 강의실 값을 classroom객체참조변수 내에 담아 controller로 리턴한다. 
		Classroom classroom = institutionClassroomMapper.institutionSelectDetailClassroomByClassroomCode(classroomCode);
		System.out.println("[InstitutionClassroomService institutionGetClassroomListByInstitutionCode] classroom: "+classroom);
		return classroom;
	}
	
}
