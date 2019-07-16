package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.institution.service.InstitutionLectureService;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;

@RestController("kr.or.ksmart.lms.institution.controller")
public class RestInstitutionLectureController {
	@Autowired private InstitutionLectureService institutionLectureService;
	
	// institution layout 강의표준명 리스트 출력 controller	
	@PostMapping("/institution/getInfoLectureNameList")
	public List<InfoLecture> institutionGetInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestLectureController institutionGetInfoLectureNameList] lectureSort: "+ lectureSort);
		return institutionLectureService.institutionGetInfoLectureNameList(lectureSort);		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("/institution/getSubjectList")
	public List<InfoSubject> institutionGetSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestLectureController institutionGetSubjectListByLectureCode] lectureCode: "+ lectureCode);
		return institutionLectureService.institutionGetSubjectListByLectureCode(lectureCode);		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("/institution/lectureCheck")
	public boolean institutionLectureCheck(@RequestParam() String noticeLectureCode){
		System.out.println("[RestLectureController institutionLectureCheck] noticeLectureCode: "+ noticeLectureCode);
		boolean lectureCheck = institutionLectureService.institutionCheckLectureByNoticeLectureCode(noticeLectureCode);
		
		// service에서 boolean 리턴데이터타입으로 검사한 값 확인하기
		if(lectureCheck) {
			System.out.println("RestController ■■xx수강신청 등록 불가xx■■");
		}else {
			System.out.println("RestController ■■oo수강신청 등록 가능oo■■");
		}		
		return lectureCheck;
	}
}
