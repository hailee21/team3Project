package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.lecture.service.LectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@RestController
public class RestLectureController {
	@Autowired private LectureService lectureService;
	// institution layout 강의표준명 리스트 출력 controller	
	@PostMapping("/getInfoLectureNameList")
	public List<InfoLecture> getInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestLectureController getInfoLectureNameList] lectureSort: "+ lectureSort);
		return  lectureService.getInfoLectureNameList(lectureSort);
		
	}
	
	// institution layout 과목리스트 출력 controller
	@PostMapping("/getSubjectList")
	public List<InfoSubject> getSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestLectureController getInfoLectureNameList] lectureCode: "+ lectureCode);
		return  lectureService.getSubjectListByLectureCode(lectureCode);
		
	}

}
