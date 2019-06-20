package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@RestController
public class RestInfoLectureController {
	@Autowired private InfoLectureService infoLectureService;
	// institution layout 강의표준명 리스트 출력 controller	
	@PostMapping("/getInfoLectureNameList")
	public List<InfoLecture> getInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestInfoLectureController getInfoLectureNameList] lectureSort: "+ lectureSort);
		return  infoLectureService.getInfoLectureNameList(lectureSort);
		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("/getSubjectList")
	public List<InfoSubject> getSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestInfoLectureController getInfoLectureNameList] lectureCode: "+ lectureCode);
		return  infoLectureService.getSubjectListByLectureCode(lectureCode);
		
	}

}
