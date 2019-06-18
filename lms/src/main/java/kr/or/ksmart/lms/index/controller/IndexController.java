package kr.or.ksmart.lms.index.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.service.IndexService;
import kr.or.ksmart.lms.index.vo.IndexInstitution;

@Controller
public class IndexController {
	@Autowired
	IndexService indexService;
	
	@RequestMapping("/")
	public ModelAndView index(HttpSession session, ModelAndView mav) {
		mav.setViewName("rootIndex");
		return mav;
	}

	@GetMapping("/LEIndex")
	public ModelAndView LEIndex(HttpSession session, ModelAndView mav,
			@RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("LE/LEIndex");
		IndexInstitution institution = indexService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	
	@GetMapping("/teacherLogin")
	public ModelAndView teacherLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("teacher/teacherLogin");
		return mav;
	}
	
	@GetMapping("/teacherIndex")
	public ModelAndView teacherIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("teacher/teacherIndex");
		return mav;
	}
	
	@GetMapping("/institutionLogin")
	public ModelAndView institutionLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("institution/institutionLogin");
		return mav;
	}
	
	@GetMapping("/institutionIndex")
	public ModelAndView institutionIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("institution/institutionIndex");
		return mav;
	}
	
	@GetMapping("/associationLogin")
	public ModelAndView associationLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("association/associationLogin");
		return mav;
	}
	
	@GetMapping("/associationIndex")
	public ModelAndView associationIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("association/associationIndex");
		return mav;
	}
	
}