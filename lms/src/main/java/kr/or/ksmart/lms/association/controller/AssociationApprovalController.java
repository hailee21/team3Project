package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationSendEmailService;

@Controller
public class AssociationApprovalController {
	@Autowired AssociationSendEmailService associationSendEmailService;
	
	//	강사 승인코드
	@GetMapping("/sendEmailToTeacher")
	public ModelAndView sendEmailToTeacher(HttpSession session, ModelAndView mav) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			mav.setViewName("sendEmailToTeacher");
		} else {
			System.out.println("협회직원아님");
			mav.setViewName("login");
		}
		return mav;
	}
	//	직원 승인코드
	@GetMapping("/sendEmailToInstitution")
	public ModelAndView sendEmailToInstitution(HttpSession session, ModelAndView mav) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("sendEmailToInstitution");
		} else {
			mav.setViewName("login");
		}
		return mav;
	}
	@PostMapping("/sendEmailToTeacher")
	public ModelAndView sendEmailToTeacherController(ModelAndView mav, String emailAddress) {
		associationSendEmailService.sendEmailToTeacherService(emailAddress);
		mav.setViewName("redirect:/sendApprovalCode");
		return mav;
	}
}
