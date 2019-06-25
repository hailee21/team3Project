package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationLectureService;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@RestController("kr.or.ksmart.lms.association.controller")
public class RestAssociationLectureController {
	@Autowired private AssociationLectureService associationLectureService;
	
	// institution layout 강의표준명 리스트 출력 controller	
	@PostMapping("association/getInfoLectureNameList")
	public List<InfoLecture> associationGetInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestLectureController getInfoLectureNameList] lectureSort: "+ lectureSort);
		return  associationLectureService.getInfoLectureNameList(lectureSort);
		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("/getSubjectList")
	public List<InfoSubject> associationGetSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestLectureController getInfoLectureNameList] lectureCode: "+ lectureCode);
		return  associationLectureService.getSubjectListByLectureCode(lectureCode);
		
	}

}
