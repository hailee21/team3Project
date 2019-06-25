package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationClassroomService;
import kr.or.ksmart.lms.association.vo.Institution;

@RestController
public class RestAssociationClassroomController {
	@Autowired AssociationClassroomService associationClassroomService;
	
	// 2. 키워드 검색으로 교육원 리스트 출력	
	@PostMapping("/getInstitutionList")
	public List<Institution> associationGetInstitutionList(@RequestParam() String instName){
		System.out.println("[RestClassroomController getInstitutionList] instName: "+ instName);
		
		return associationClassroomService.getInstitutionList(instName);
	}

	
	

}
