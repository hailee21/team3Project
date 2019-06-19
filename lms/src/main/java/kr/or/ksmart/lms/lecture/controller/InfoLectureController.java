package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@Controller
public class InfoLectureController {

	@Autowired InfoLectureService infoLectureService;

	// institution layout 강의항목 리스트 출력 controller
	@GetMapping("/institution/infoLecture/infoLecture")
	public ModelAndView getInfoLectureSortList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InfoLectureController getInfoLectureSortList] 강의조회시작");
			mav.setViewName("/institution/infoLecture/infoLecture");
			
			List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
			System.out.println("[InfoLectureController getInfoLectureSortList] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
}