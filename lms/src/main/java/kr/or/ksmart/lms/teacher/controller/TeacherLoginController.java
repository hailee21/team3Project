package kr.or.ksmart.lms.teacher.controller;

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
public class TeacherLoginController {
	@Autowired
	AssociationLoginService associationLoginService;
	
	//강사 로그인 폼 controller
	@GetMapping("/teacherLogin")
	public ModelAndView teacherLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("teacher/teacherLogin");
		return mav;
	}

	//강사 로그인 액션 controller
	@PostMapping("/teacherLogin")
	public String loginAction(HttpSession session, LoginRequest loginRequest) {
		System.out.println(loginRequest);
		MemberOnline loginMember = associationLoginService.getMemberOnline(loginRequest);
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
	
	//강사 index 출력 controller
	@GetMapping("/teacherIndex")
	public ModelAndView teacherIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("teacher/teacherIndex");
		return mav;
	}
}
