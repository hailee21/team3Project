package kr.or.ksmart.lms.institution.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionService;

@Controller
public class InstitutionController {
	@Autowired
	InstitutionService institutionService;

	//institutionLayout 교육원 사용권한 controller
	@GetMapping("/institutionAvailableInstitution")
	public ModelAndView getAvailableInstitution(HttpSession session, ModelAndView mav) {
		System.out.println("[InstitutionController getAvailableInstitution] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/annualFee/annualFee");
		} else {
			System.out.println("[InstitutionController getAvailableInstitution] 교육원직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}

	//institutionLayout 교육원 연회비 결제 controller
	@GetMapping("/paymentAnnualFee")
	public ModelAndView paymentAnnualFee(HttpSession session, ModelAndView mav) {
		System.out.println("[InstitutionController paymentAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/annualFee/paymentAnnualFee");
		} else {
			System.out.println("[InstitutionController paymentAnnualFee] 교육원직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
