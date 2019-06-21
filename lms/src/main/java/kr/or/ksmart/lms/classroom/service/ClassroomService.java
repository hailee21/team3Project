package kr.or.ksmart.lms.classroom.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
	// 교육원 리스트 검색, 출력 
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
	
	// 교육원명, 위치 select -> addClassroom.html에 입력 
	public Map<String, Object> getInstitutionByInstCode(String instCode){
		System.out.println("[ClassroomService getInstitutionByInstCode]");
		System.out.println("[ClassroomService getInstitutionByInstCode] instCode : "+instCode);
		
		// mapper에서 가져온 교육원명, 위치
		Institution institution = new Institution();
		institution = classroomMapper.selectInstitutionByInstitutionCode(instCode);
		String instName = institution.getInstitutionName();
		String instLocation = institution.getInstitutionLocation();
		System.out.println("[ClassroomService getInstitutionByInstCode] instName : "+instName);
		System.out.println("[ClassroomService getInstitutionByInstCode] instLocation : "+instLocation);
		// mapper에서 가져온 강의실용도 리스트
		List<Classroom> list = classroomMapper.selectClassroomUse();
		System.out.println("[ClassroomService getInstitutionByInstCode] list : "+list);
		
		// mapper에서 가져온 값 map에 담아서 이동
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("instName", instName);
		map.put("instLocation", instLocation);
		map.put("useList", list);
		return map;
	}
	// 강의실 추가 
	public void addClassroom(Classroom classroom, String instCode) {
		System.out.println("[ClassroomService addClassroom]");
		// 1. 강의실 테이블에 추가할 PK 구하는 코드 
		// 1-1. 가져온 pk를 string 데이터타입의 변수에 담는다
		String classroomPk = classroomMapper.selectClassroomPK();
		System.out.println("[ClassroomService addClassroom] 가져온 classroomPk: "+classroomPk);
		// 1-2. 이를 substring을 사용해 문자열을 자르고 숫자만 추출한 뒤, integer를 사용하여 int로 바꾸고, 얻은 숫자값에 1을 더한다
		int lastNo = Integer.parseInt(classroomPk.substring(2));
		System.out.println("[ClassroomService addClassroom] 추출한 lastNo: "+lastNo);
		lastNo++;
		System.out.println("[ClassroomService addClassroom] 1을더한 lastNo: "+lastNo);
		// 1-3. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String crPK = "CR"+lastNo;
		classroom.setClassroomCode(crPK);
		System.out.println("[ClassroomService addClassroom] 최종 crPK: "+crPK);
		
		// 2. classroom 테이블에 강의실 등록하기
		// 교육원검색화면에서 받아 등록화면에서 넘어온 institutionCode로 교육원명, 위치 정보 가져오고 이를 vo에 담아서 mapper호출하기
		Map<String, Object> map = classroomMapper.selectInstitutionInfo(instCode);
		String instName = (String)map.get("institutionName");
		String instLocation = (String)map.get("institutionLocation");
		System.out.println("[ClassroomService addClassroom] vo에 넣을 instName: "+instName);
		System.out.println("[ClassroomService addClassroom] vo에 넣을 instLocation: "+instLocation);
		classroom.setInstitutionName(instName);
		classroom.setClassroomLocation(instLocation);
		
		classroomMapper.insertClassroom(classroom);
	}
		
}
