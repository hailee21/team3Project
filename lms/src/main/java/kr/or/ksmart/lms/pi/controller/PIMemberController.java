package kr.or.ksmart.lms.pi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.service.PIMemberService;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Controller
public class PIMemberController {
	@Autowired PIMemberService memberService;
	
	//	회원등록 join.html(회원)
	@GetMapping("/join")
	public ModelAndView memberJoin(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		//	교육원 코드 받아오기
		System.out.println("[MemberController memberJoin] institutionCode : " + institutionCode);
		IndexInstitution institution = memberService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		//	교육원명 출력하기 위한 institutionList map
		List<Institution> instList = memberService.memberJoin();
		mav.addObject("instList", instList);
		System.out.println("[PIMemberController memberJoin] map:" + instList);
		mav.setViewName("PI/Join");
		return mav;
	}
	//	회원등록 처리
	@PostMapping("/memberInsert")
	public ModelAndView memberInsert(Member member, MemberOnline memberOnline
			, @RequestParam(value="institutionCode", required = true) String institutionCode, ModelAndView mav) {
		System.out.println("[MemberController memberInsert] member:" + member);
		memberService.insertMember(member, memberOnline, institutionCode);
		//mav.setViewName("redirect:/login?institutionCode=" + institutionCode);	로그인 바로가기
		mav.setViewName("redirect:/joinSuccess?institutionCode=" + institutionCode);
		return mav;
	}
	//	회원등록 완료 후 로그인창
	@GetMapping("/joinSuccess")
	public ModelAndView joinSuccess(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("PI/joinSuccess");
		System.out.println("[MemberController memberJoin] institutionCode" + institutionCode);
		IndexInstitution institution = memberService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	//	회원정보 조회
	@GetMapping("/myInfo")
	public ModelAndView myPage(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = memberService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberName != null) {
			mav.setViewName("PI/myPage/myInfo");
		}
		return mav;
	}
	//	회원정보 수정
	@GetMapping("/memberModify")
	public ModelAndView memberInfoModify(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		
		IndexInstitution institution = memberService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberName != null) {
			mav.setViewName("PI/myPage/memberInfoModify");
		}
		return mav;
	}
	@PostMapping("/memberModify")
	public ModelAndView memberModify(Member member, MemberOnline memberOnline
			, @RequestParam(value="institutionCode", required = true) String institutionCode, ModelAndView mav) {
		return mav;
	}
	
}
