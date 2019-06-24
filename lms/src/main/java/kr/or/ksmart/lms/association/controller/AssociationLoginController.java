package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLoginService;
import kr.or.ksmart.lms.association.vo.MemberOnline;
import kr.or.ksmart.lms.association.vo.LoginRequest;

@Controller
public class AssociationLoginController {
	@Autowired
	AssociationLoginService associationLoginService;
	
	//협회 로그인 폼 controller
	@GetMapping("/associationLogin")
	public ModelAndView associationLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("association/associationLogin");
		return mav;
	}

	//협회 로그인 액션 controller
	@PostMapping("/associationLogin")
	public ModelAndView associationLoginAction(HttpSession session, ModelAndView mav, LoginRequest loginRequest) {
		MemberOnline loginMember = associationLoginService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			mav.setViewName("redirect:/associationLogin");
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			mav.setViewName("redirect:/associationIndex");
		}
		return mav;
	}
	
	//협회 index 출력 controller
	@GetMapping("/associationIndex")
	public ModelAndView associationIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("association/associationIndex");
		return mav;
	}
}
