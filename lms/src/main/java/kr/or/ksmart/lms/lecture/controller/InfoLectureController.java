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
		// mav의 이름 지정
		mav.setViewName("infoLecture");
		
		// infoLectureService에서 가져온 값을 list변수에 담기
		List<InfoLecture> sortList = infoLectureService.selectInfoLectureList();
		System.out.println("[InfoLectureController getInfoLectureList] sortList: "+sortList);
		
		// mav내부에 list객체 추가하기
		mav.addObject("sortList", sortList);
		return mav;
	}
}
