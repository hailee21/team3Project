package kr.or.ksmart.lms.institution.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.institution.service.InstitutionClassroomService;

@RestController
public class RestInstitutionClassroomController {
	@Autowired private InstitutionClassroomService institutionClassroomService;
	
}
