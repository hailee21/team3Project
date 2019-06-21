package kr.or.ksmart.lms.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.classroom.mapper.ClassroomMapper;
import kr.or.ksmart.lms.classroom.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.lecture.mapper.LectureMapper;

@Service
public class ClassroomService {
	@Autowired ClassroomMapper classroomMapper;
	@Autowired LectureMapper lectureMapper;
	
	// 강의실 추가 메서드
	public int addClassroom(Classroom classroom) {
		System.out.println("[ClassroomService addClassroom]");
		return classroomMapper.insertClassroom(classroom);
	}
	
	// 교육원 리스트 검색, 출력 메서드
	public List<Institution> getInstitutionList(String instName){
		System.out.println("[ClassroomService getInstitutionList]");
		System.out.println("[ClassroomService getInstitutionList] instName :"+instName);
		
		// select문을 위해 입력받은 instName값에 %를 붙여서 mapper의 메서드를 호출한다.
		String institutionName = "%"+instName+"%";
		System.out.println("[ClassroomService getInstitutionList] % 조합한 institutionName :"+institutionName);
		// 입력받은 교육원 키워드로 교육원 검색 
		List<Institution> instListByName = lectureMapper.selectInstitutionListByKeyword(institutionName);
		System.out.println("[ClassroomService getInstitutionList] instListByName : "+instListByName);
		
		return instListByName;
	}
}
