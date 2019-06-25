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

	@GetMapping("/PIIndex")
	public ModelAndView PIIndex(HttpSession session, ModelAndView mav,
			@RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("PI/PIIndex");
		IndexInstitution institution = indexService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
}