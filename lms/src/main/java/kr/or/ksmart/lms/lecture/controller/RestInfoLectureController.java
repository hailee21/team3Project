package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@RestController
public class RestInfoLectureController {
	@Autowired private InfoLectureService infoLectureService;
	
	@PostMapping("/getInfoLectureNameList")
	public List<InfoLecture> getInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestInfoLectureController getInfoLectureNameList] lectureSort: "+ lectureSort);
		return  infoLectureService.getInfoLectureNameList(lectureSort);
		
	}

}
