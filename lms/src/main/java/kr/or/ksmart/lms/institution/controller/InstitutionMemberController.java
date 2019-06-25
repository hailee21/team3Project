package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionMemberService;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Controller
public class InstitutionMemberController {
	@Autowired InstitutionMemberService institutionMemberService;
	
	@GetMapping("/institution/memberList")
	public ModelAndView instMemberList(ModelAndView mav, HttpSession session) {
		String memberCode = (String)session.getAttribute("memberCode");
		List<InstitutionMember> memberList = institutionMemberService.institutionMemberList(memberCode);
		mav.setViewName("institution/member/list");
		return mav;
	}
}
