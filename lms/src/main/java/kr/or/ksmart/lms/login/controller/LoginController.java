package kr.or.ksmart.lms.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.login.service.LonginService;
import kr.or.ksmart.lms.login.vo.LoginRequest;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Controller
public class LoginController {
	@Autowired
	LonginService longinService;

	@GetMapping("/login")
	public ModelAndView loginForm(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/login")
	public String loginAction(HttpSession session, LoginRequest loginRequest) {
		MemberOnline loginMember = longinService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			return "redirect:" + "/login";
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			return "redirect:" + "/";
		}
	}
}
