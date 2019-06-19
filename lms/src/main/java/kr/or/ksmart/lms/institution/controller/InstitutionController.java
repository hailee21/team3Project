package kr.or.ksmart.lms.institution.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionService;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;

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
	public ModelAndView getPaymentAnnualFee(HttpSession session, ModelAndView mav) {
		System.out.println("[InstitutionController getPaymentAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/annualFee/getPaymentAnnualFee");
			InfoAnnualFeeByPayment infoAnnualFee = institutionService.getPaymentAnnualFee();
			mav.addObject("infoAnnualFee", infoAnnualFee); 
		} else {
			System.out.println("[InstitutionController getPaymentAnnualFee] 교육원직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
