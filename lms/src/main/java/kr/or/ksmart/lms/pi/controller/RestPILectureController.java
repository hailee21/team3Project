package kr.or.ksmart.lms.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.pi.service.PILectureService;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@RestController
public class RestPILectureController {
	@Autowired private PILectureService piLectureService;
	
	// institution layout 강의표준명 리스트 출력 controller	
	@PostMapping("pi/getInfoLectureNameList")
	public List<InfoLecture> piGetInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestLectureController piGetInfoLectureNameList] lectureSort: "+ lectureSort);
		return  piLectureService.piGetInfoLectureNameList(lectureSort);
		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("pi/getSubjectList")
	public List<InfoSubject> piGetSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestLectureController piGetInfoLectureNameList] lectureCode: "+ lectureCode);
		return  piLectureService.piGetSubjectListByLectureCode(lectureCode);
		
	}

}
