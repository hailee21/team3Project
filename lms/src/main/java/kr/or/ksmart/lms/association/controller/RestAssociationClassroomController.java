package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationClassroomService;
import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.Institution;

@RestController
public class RestAssociationClassroomController {
	@Autowired private AssociationClassroomService associationClassroomService;
	
	// 키워드 검색으로 교육원 리스트 출력	
	@PostMapping("/association/getInstitutionList")
	public List<Institution> associationGetInstitutionList(@RequestParam() String instName){
		System.out.println("[RestClassroomController associationGetInstitutionList] instName: "+ instName);
		
		return associationClassroomService.associationGetInstitutionList(instName);
	}

	// 키워드 검색으로 강의실 리스트 출력
	@PostMapping("/association/getClassroomList")
	public List<Classroom> associationGetClassroomList(@RequestParam() String classroomLocation){
		System.out.println("[RestClassroomController associationGetClassroomList] classroomLocation: "+ classroomLocation);
		
		return associationClassroomService.associationGetClassroomListByInstName(classroomLocation);
	}
	

}
