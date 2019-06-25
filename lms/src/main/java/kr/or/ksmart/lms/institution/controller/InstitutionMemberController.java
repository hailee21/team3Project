package kr.or.ksmart.lms.institution.controller;

import java.util.List;
import java.util.Map;

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
		System.out.println("[InstitutionMemberController instMemberList 호출]");
		String memberRank = (String)session.getAttribute("memberRank");
		String memberCode = (String)session.getAttribute("memberCode");
		if (memberRank == null) {
			System.out.println("[InstitutionMemberController instMemberList] 로그아웃상태");
			mav.setViewName("institution/institutionLogin");
		} else if (memberRank.equals("교육원직원")) {
			mav.setViewName("institution/member/list");
			List<InstitutionMember> memberList = institutionMemberService.institutionMemberList(memberCode);
			mav.addObject("memberList", memberList);
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		
		return mav;
	}
}
