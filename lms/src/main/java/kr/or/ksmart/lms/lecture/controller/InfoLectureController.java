package kr.or.ksmart.lms.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;

@Controller
public class InfoLectureController {

	@Autowired InfoLectureService infoLectureService;
	
	@GetMapping("/infoLecture")
	public ModelAndView getInfoLectureList(ModelAndView mav) {
		mav.setViewName("infoLectureList");
		return mav;
	}
}
