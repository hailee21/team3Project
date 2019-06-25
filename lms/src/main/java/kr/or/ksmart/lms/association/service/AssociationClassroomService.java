package kr.or.ksmart.lms.association.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationClassroomMapper;
import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.Institution;
import kr.or.ksmart.lms.association.mapper.AssociationLectureMapper;

@Service
public class AssociationClassroomService {
	@Autowired private AssociationClassroomMapper associationClassroomMapper;
	@Autowired private AssociationLectureMapper associationLectureMapper;
		
	// 비동기로 교육원 리스트 검색, 출력 
	public List<Institution> associationGetInstitutionList(String instName){
		System.out.println("[ClassroomService associationGetInstitutionList]");
		System.out.println("[ClassroomService associationGetInstitutionList] instName :"+instName);
		
		// select문을 위해 입력받은 instName값에 %를 붙여서 mapper의 메서드를 호출한다.
		String institutionName = "%"+instName+"%";
		System.out.println("[ClassroomService associationGetInstitutionList] % 조합한 institutionName :"+institutionName);
		// 입력받은 교육원 키워드로 교육원 검색 
		List<Institution> instListByName = associationLectureMapper.associationSelectInstitutionListByKeyword(institutionName);
		System.out.println("[ClassroomService associationGetInstitutionList] instListByName : "+instListByName);
		
		return instListByName;
	}
	
	// 교육원명, 위치 select -> addClassroom.html에 입력 
	public Map<String, Object> associationGetInstitutionByInstCode(String institutionCode){
		System.out.println("[ClassroomService associationGetInstitutionByInstCode]");
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] institutionCode : "+institutionCode);
		
		// mapper에서 가져온 교육원명, 위치
		Institution institution = new Institution();
		institution = associationClassroomMapper.associationSelectInstitutionByInstitutionCode(institutionCode);
		// 새로운 객체참조변수인 institution에서 해당 값들을 가져와서 string 변수에 담는다 
		String institutionCode2 = institution.getInstitutionCode();
		String institutionName = institution.getInstitutionName();
		String institutionLocation = institution.getInstitutionLocation();
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] institutionCode2 : "+institutionCode2);
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] instName : "+institutionName);
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] instLocation : "+institutionLocation);
		// mapper에서 가져온 강의실용도 리스트
		List<Classroom> list = associationClassroomMapper.associationSelectClassroomUse();
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] list : "+list);
		
		// string 변수로 지정한 값들을 map에 담아서 controller로 이동
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("institutionCode", institutionCode2);
		map.put("institutionName", institutionName);
		map.put("institutionLocation", institutionLocation);
		map.put("useList", list);
		return map;
	}
	// 강의실 추가 
	public void associationAddClassroom(Classroom classroom) {
		System.out.println("[ClassroomService associationAddClassroom]");
		
		// 1. 강의실 테이블에 추가할 PK 구하는 코드 
		// 1-1. 가져온 pk를 string 데이터타입의 변수에 담는다
		String classroomPk = associationClassroomMapper.associationSelectClassroomPK();
		System.out.println("[ClassroomService associationAddClassroom] 가져온 classroomPk: "+classroomPk);
		// 1-2. 이를 substring을 사용해 문자열을 자르고 숫자만 추출한 뒤, integer를 사용하여 int로 바꾸고, 얻은 숫자값에 1을 더한다
		int lastNo = Integer.parseInt(classroomPk.substring(2));
		System.out.println("[ClassroomService associationAddClassroom] 추출한 lastNo: "+lastNo);
		lastNo++;
		System.out.println("[ClassroomService associationAddClassroom] 1을더한 lastNo: "+lastNo);
		// 1-3. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String crPK = "CR"+lastNo;
		classroom.setClassroomCode(crPK);
		System.out.println("[ClassroomService associationAddClassroom] 최종 crPK: "+crPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		associationClassroomMapper.associationInsertClassroom(classroom);
	}
	
	// 강의실 리스트 출력
	public List<Classroom> associationGetClassroomList(){
		System.out.println("[ClassroomService associationAddClassroom]");
		
		// mapper에서 가져온 classroom리스트를 list내부에 담아서 controller로 리턴보내기
		List<Classroom> list = associationClassroomMapper.associationSelectClassroomList();
		System.out.println("[ClassroomService associationGetInstitutionByInstCode] list : "+list);
		return list;
	}
	
	// 비동기로 classroomList.html에 강의실 리스트 검색, 출력(수정, 삭제)
	public List<Classroom> associationGetClassroomListByInstName(String classroomLocation){
		System.out.println("[ClassroomService associationgetClassroomListByInstName]");
		System.out.println("[ClassroomService associationgetClassroomListByInstName] classroomLocation :"+classroomLocation);
		
		// select문을 위해 입력받은 instName값에 %를 붙여서 mapper의 메서드를 호출한다.
		String CL = "%"+classroomLocation+"%";
		System.out.println("[ClassroomService associationGetInstitutionList] % 조합한 CL :"+CL);
		// 입력받은 교육원 키워드로 교육원 검색 
		List<Classroom> CListByCL = associationClassroomMapper.associationSelectClassroomListByKeyword(CL);
		System.out.println("[ClassroomService associationGetInstitutionList] CListByCL : "+CListByCL);
		
		return CListByCL;
	}
	// classroom 수정 
	public Classroom associationGetClassroomByClassroomCode(String classroomCode) {
		System.out.println("[ClassroomService associationGetClassroomByClassroomCode]");
		System.out.println("[ClassroomService associationGetClassroomByClassroomCode] classroomCode :"+classroomCode);
		
		// select문을 위해 입력받은 classroomCode으로 mapper의 메서드를 호출한다.
		return associationClassroomMapper.selectClassroomByClassroomCode(classroomCode);
	}
}
