package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.institution.service.InstitutionNoticeLectureService;
import kr.or.ksmart.lms.institution.vo.InfoLecture;

@RestController
public class RestInstitutionNoticeLectureController {
	@Autowired private InstitutionNoticeLectureService institutionNoticeLectureService;
	
	
}
