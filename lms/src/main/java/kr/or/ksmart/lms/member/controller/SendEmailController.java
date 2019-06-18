package kr.or.ksmart.lms.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.member.service.SendEmailService;

@Controller
public class SendEmailController {

	@Autowired
	SendEmailService sendEmailService;
	
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
	public void sendEmailToTeacherController(String emailAddress) {
		sendEmailService.sendEmailToTeacherService(emailAddress);
	}
	
	@PostMapping("/sendEmailToInstitution")
	public void sendEmailToInstitutionController(String emailAddress) {
		sendEmailService.sendEmailToInstitutionService(emailAddress);
	}
}
