package kr.or.ksmart.lms.pa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pa.service.PALoginService;
import kr.or.ksmart.lms.pa.vo.IndexInstitution;
import kr.or.ksmart.lms.pa.vo.LoginRequest;
import kr.or.ksmart.lms.pa.vo.MemberOnline;

@Controller
public class PALoginController {
	@Autowired
	PALoginService paLoginService;

	//PA 로그인 폼 controller
	@GetMapping("/PALogin")
	public ModelAndView associationLogin(HttpSession session, ModelAndView mav) {
		IndexInstitution institution = paLoginService.PIIndex();
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PA/PALogin");
		return mav;
	}

	//PA 로그인 액션 controller
	@PostMapping("/PALogin")
	public ModelAndView associationLoginAction(HttpSession session, ModelAndView mav, LoginRequest loginRequest) {
		MemberOnline loginMember = paLoginService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			mav.setViewName("redirect:/PALogin");
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			mav.setViewName("redirect:/PAIndex");
		}
		return mav;
	}
	
	//PA index 출력 controller
	@GetMapping("/PAIndex")
	public ModelAndView associationIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("PA/PAIndex");
		IndexInstitution institution = paLoginService.PIIndex();
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}

	//PA 로그아웃 controller
	@GetMapping("/PALogout")
	public ModelAndView PALogout(HttpSession session, ModelAndView mav) {
		session.invalidate();
		mav.setViewName("redirect:/PALogin");
		return mav;
	}
}
