package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionMemberService;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Controller
public class InstitutionMemberController {
	@Autowired private InstitutionMemberService institutionMemberService;
	
	//	교육원 직원 등록 화면 get요청
	@GetMapping("/insertInstAdmin")
	public ModelAndView insertInstAdmin (ModelAndView mav) {
		//	교육원명 출력하기 위한 institutionList 호출
		List<Institution> instList = institutionMemberService.insertAdmin();
		mav.addObject("instList", instList);
		mav.setViewName("institution/member/insertInstAdmin");
		return mav;
	}
	//	강사 승인코드 발송 화면
	@GetMapping("/sendApprovalCode")	//	sendTeacher get요청시
	public ModelAndView sendEmailToTeacher (ModelAndView mav, HttpSession session) {
		System.out.println("[institutionMemberController sendEmailToInstitution] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if(memberRank.equals("교육원직원")) {	//	요청한 회원등급이 교육원직원이면 institution내 sendEmailToTeacher.. 
			mav.setViewName("institution/member/sendApprovalCode");
		} else if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/member/sendApprovalCode");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 협회/교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	//	교육원 관리자 승인코드 발송
	/*@GetMapping("/sendAdmin")
	public ModelAndView sendEmailToAdmin (ModelAndView mav, HttpSession session) {
		System.out.println("[institutionMemberController sendEmailToInstitution] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		} if(memberRank.equals("교육원직원")) {	//	요청한 회원등급이 교육원직원이면 institution내 sendEmailToAdmin..
			mav.setViewName("institution/member/sendEmailToAdmin");
		} else if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association내 sendEmailToAdmin
			mav.setViewName("association/member/sendEmailToAdmin");
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 협회/교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}*/
	//	교육원 관리자 내정보 보기
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
	//	교육원관리자 교육원 회원 리스트
	@GetMapping("/institution/memberList")
	public ModelAndView instMemberList(ModelAndView mav, HttpSession session) {
		System.out.println("[InstitutionMemberController instMemberList 호출]");
		String memberRank = (String)session.getAttribute("memberRank");
//		String institutionCode = (String)session.getAttribute("institutionCode");
		if (memberRank == null) {
			System.out.println("[InstitutionMemberController instMemberList] 로그아웃상태");
			mav.setViewName("institution/institutionLogin");
		} else if (memberRank.equals("교육원직원")) {
			mav.setViewName("institution/member/list");
			List<InstitutionMember> rank = institutionMemberService.selectMemberRankList();
//			List<InstitutionMember> memberList = institutionMemberService.institutionMemberList(institutionCode);
//			mav.addObject("memberList", memberList);
			mav.addObject("memberRank", rank);
		} else {
			System.out.println("[InstitutionMemberController instMemberList] 교육원 직원이 아님");
			mav.setViewName("institution/institutionLogin");
		}
		
		return mav;
	}
}
