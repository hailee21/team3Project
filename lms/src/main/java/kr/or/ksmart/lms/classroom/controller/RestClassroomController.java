package kr.or.ksmart.lms.classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.classroom.service.ClassroomService;
import kr.or.ksmart.lms.institution.vo.Institution;

@RestController
public class RestClassroomController {
	@Autowired ClassroomService classroomService;
	
	// 2. 키워드 검색으로 교육원 리스트 출력	
	@PostMapping("/getInstitutionList")
	public List<Institution> getInstitutionList(@RequestParam() String instName){
		System.out.println("[RestClassroomController getInstitutionList] instName: "+ instName);
		
		return classroomService.getInstitutionList(instName);
	}

	
	

}
