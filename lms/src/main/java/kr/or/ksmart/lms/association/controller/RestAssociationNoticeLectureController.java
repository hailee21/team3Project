package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationNoticeLectureService;
import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.InfoLecture;

@RestController
public class RestAssociationNoticeLectureController {
	@Autowired private AssociationNoticeLectureService associationNoticeLectureService;
	
	// infoLecture-name select리스트 출력(비동기)
	@PostMapping("/getInfoLectureNameList")
	public List<InfoLecture> associationGetInfoLectureNameList(@RequestParam() String infoLectureSort){
		System.out.println("[RestAssociationNoticeLectureController associationGetInfoLectureNameList] infoLectureSort: "+ infoLectureSort);
		return  associationNoticeLectureService.associationReadyForRestAddNoticeLecture1(infoLectureSort);
		
	}
	// classroom select리스트 출력(비동기 - institutionCode로)
	@PostMapping("/getClassroomList")
	public List<Classroom> associationGetClassroomList(@RequestParam() String institutionCode){
		System.out.println("[RestAssociationNoticeLectureController associationGetClassroomList] institutionCode: "+ institutionCode);
		return  associationNoticeLectureService.associationReadyForRestAddNoticeLecture2(institutionCode);
		
	}

}
