package kr.or.ksmart.lms.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.login.service.LoginService;
import kr.or.ksmart.lms.login.vo.LoginRequest;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Controller
public class LoginController {
	@Autowired
	LoginService longinService;

	@GetMapping("/login")
	public ModelAndView LELoginForm(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("login");
		System.out.println("[LoginController LELoginForm] institutionCode:"+institutionCode);
		IndexInstitution institution = longinService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	
	@PostMapping("/LELogin")
	public String LEloginAction(HttpSession session, LoginRequest loginRequest) {
		System.out.println(loginRequest);
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
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			return "redirect:" + "/LEIndex?institutionCode=" + loginMember.getInstitutionCode();
		}
	}
	
	@PostMapping("/associationLogin")
	public String associationLoginAction(HttpSession session, LoginRequest loginRequest) {
		System.out.println(loginRequest);
		MemberOnline loginMember = longinService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			return "redirect:" + "/associationLogin";
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			return "redirect:" + "/associationIndex";
		}
	}
	
	@PostMapping("/institutionLogin")
	public String instituteLayoutLoginAction(HttpSession session, LoginRequest loginRequest) {
		System.out.println(loginRequest);
		MemberOnline loginMember = longinService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			return "redirect:" + "/institutionLogin";
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			return "redirect:" + "/institutionIndex";
		}
	}
	
	@PostMapping("/teacherLogin")
	public String loginAction(HttpSession session, LoginRequest loginRequest) {
		System.out.println(loginRequest);
		MemberOnline loginMember = longinService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			return "redirect:" + "/teacherLogin";
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			return "redirect:" + "/teacherIndex";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:" + "/";
	}
	
}
