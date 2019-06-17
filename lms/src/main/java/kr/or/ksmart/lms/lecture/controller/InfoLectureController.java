package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@Controller
public class InfoLectureController {

	@Autowired InfoLectureService infoLectureService;
	
	@GetMapping("/infoLecture")
	public ModelAndView getInfoLectureList(ModelAndView mav) {
		System.out.println("[InfoLectureController getInfoLectureList]");
		mav.setViewName("infoLectureList");
		List<InfoLecture> list = infoLectureService.selectInfoLectureList();
		mav.addObject("list", list);
		return mav;
	}
}
