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
	
	//	교육원 직원 등록 화면
	@GetMapping("/insertInstAdmin")
	public ModelAndView insertInstAdmin (ModelAndView mav) {
		mav.setViewName("institution/member/insertInstAdmin");
		return mav;
	}
	//	강사 승인코드 발송 화면
	@GetMapping("/sendTeacher")
	public ModelAndView sendEmailToTeacher (ModelAndView mav, HttpSession session) {
		System.out.println("[institutionMemberController sendEmailToInstitution] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		} if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/member/sendEmailToTeacher");
		} else if (memberRank.equals("협회직원")) {
			mav.setViewName("association/member/sendEmailToTeacher");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	@GetMapping("/sendAdmin")
	public ModelAndView sendEmailToAdmin (ModelAndView mav, HttpSession session) {
		System.out.println("[institutionMemberController sendEmailToInstitution] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		} if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/member/sendEmailToAdmin");
		} else if (memberRank.equals("협회직원")) {
			mav.setViewName("association/member/sendEmailToAdmin");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	@GetMapping("/instMyInfo")
	public ModelAndView instMyPage(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		} if(memberRank.equals("교육원직원")) {
			mav.setViewName("institution/myPage/mypage");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	@GetMapping("/institution/memberList")
	public ModelAndView instMemberList(ModelAndView mav, HttpSession session) {
		System.out.println("[InstitutionMemberController instMemberList 호출]");
		String memberRank = (String)session.getAttribute("memberRank");
		String institutionCode = (String)session.getAttribute("institutionCode");
		if (memberRank == null) {
			System.out.println("[InstitutionMemberController instMemberList] 로그아웃상태");
			mav.setViewName("institution/institutionLogin");
		} else if (memberRank.equals("교육원직원")) {
			mav.setViewName("institution/member/list");
			List<InstitutionMember> memberList = institutionMemberService.institutionMemberList(institutionCode);
			mav.addObject("memberList", memberList);
			
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		
		return mav;
	}
}
