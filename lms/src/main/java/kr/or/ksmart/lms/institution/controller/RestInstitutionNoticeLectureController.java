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
	
	// infoLecture-name select리스트 출력(비동기)
	@PostMapping("/getInfoLectureNameList")
	public List<InfoLecture> institutionGetInfoLectureNameList(@RequestParam() String infoLectureSort){
		System.out.println("[RestInstitutionNoticeLectureController institutionGetInfoLectureNameList] infoLectureSort: "+ infoLectureSort);
		return  institutionNoticeLectureService.institutionReadyForRestAddNoticeLecture1(infoLectureSort);
	}
}
