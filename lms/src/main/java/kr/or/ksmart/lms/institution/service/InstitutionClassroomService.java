package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionClassroomMapper;
import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.Institution;

@Service
public class InstitutionClassroomService {
	@Autowired InstitutionClassroomMapper institutionClassroomMapper;
	
	// 강의실 등록을 위한 메서드
	// 1. 강의실용도 조회하기 + 교육원 코드로 교육원코드, 교육원명 조회하기
	public Map<String, Object> institutionGetInstitutionByInstitutionCode(String institutionCode) {
		System.out.println("[InstitutionClassroomService institutionGetInstitutionByInstitutionCode] institutionCode: "+institutionCode);
		
		// 강의실 용도 리스트 출력해서 view에서 이용할 수 있도록 하기
		List<Classroom> useList = institutionClassroomMapper.institutionSelectClassroomUse();
		
		// 유효성 검사를 위해 mapper에서 리턴받은 교육원 값을 institution객체참조변수 내에 담아 controller로 리턴한다. 
		Institution institution = institutionClassroomMapper.institutionSelectInstitutionByInstitutionCode(institutionCode);
		System.out.println("[InstitutionClassroomService institutionGetInstitutionByInstitutionCode] institution: "+institution);
		
		// 리턴할 것들이 2개이므로 map내부에 담아서 리턴하여 controller에서 사용하자. 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("useList", useList);
		map.put("institution", institution);
		return map;
	}
	
	// 2. 강의실 등록하기
	public void institutionAddClassroom(Classroom classroom) {
		System.out.println("[InstitutionClassroomService institutionGetInstitutionByInstitutionCode] classroom: "+classroom);
		
		// 1. 강의실 테이블에 추가할 PK 구하는 코드 
		// 1-1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println("nowDate2: "+nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		// 1-2. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String crPK = "CR"+nowDate+randomNo;
		classroom.setClassroomCode(crPK);
		System.out.println("[InstitutionClassroomService institutionAddClassroom] 최종 crPK: "+crPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		institutionClassroomMapper.institutionInsertClassroom(classroom);
	}
	
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
