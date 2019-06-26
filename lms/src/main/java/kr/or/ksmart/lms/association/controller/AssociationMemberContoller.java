package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssociationMemberContoller {
	
	@GetMapping("/insertAssociationAdmin")
	public ModelAndView insertInstAdmin (ModelAndView mav) {
		mav.setViewName("association/member/insertAssociationAdmin");
		return mav;
	}
	//test
	@GetMapping("/test")
	public ModelAndView test (ModelAndView mav) {
		mav.setViewName("association/test");
		return mav;
	}
}
