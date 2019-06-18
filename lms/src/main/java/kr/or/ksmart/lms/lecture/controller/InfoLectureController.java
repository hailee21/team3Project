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
	
	@GetMapping("/institution/infoLecture")
	public ModelAndView getInfoLectureSortList(ModelAndView mav) {
		System.out.println("[InfoLectureController getInfoLectureSortList]");
		mav.setViewName("/institution/infoLecture/infoLecture");
		List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
		System.out.println("[InfoLectureController getInfoLectureSortList] sortList : "+ sortList);
		
		mav.addObject("sortList", sortList);
		return mav;
	}
}
