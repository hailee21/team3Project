package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssociationInfoEvalController {
	
	@GetMapping("/lookup")
	public ModelAndView lookupMap (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/evaluation/lookupMap");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 협회 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	@GetMapping("/itemManagement")
	public ModelAndView itemManagementMap (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/evaluation/itemManagementMap");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 협회 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
