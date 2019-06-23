package kr.or.ksmart.lms.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.service.MemberService;
import kr.or.ksmart.lms.member.vo.Member;
import kr.or.ksmart.lms.member.vo.MemberOnline;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	
	//	회원등록 join.html(회원)
	@GetMapping("/join")
	public ModelAndView memberJoin(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("LE/Join");
		System.out.println("[MemberController memberJoin] institutionCode" + institutionCode);
		IndexInstitution institution = memberService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	//	회원등록 처리
	@PostMapping("memberInsert")
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
		mav.setViewName("LE/joinSuccess");
		System.out.println("[MemberController memberJoin] institutionCode" + institutionCode);
		IndexInstitution institution = memberService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	//	회원정보 조회
	@GetMapping("/myInfo")
	public ModelAndView myPage(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("LE/myPage/myInfo");
		IndexInstitution institution = memberService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	//	회원정보 수정
	@GetMapping("/memberModify")
	public ModelAndView memberInfoModify(HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("LE/myPage/memberInfoModify");
		IndexInstitution institution = memberService.LEIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}
	@PostMapping("/memberModify")
	public ModelAndView memberModify(Member member, MemberOnline memberOnline
			, @RequestParam(value="institutionCode", required = true) String institutionCode, ModelAndView mav) {
		return mav;
	}
	//	회원리스트 조회 (미완성)
	@GetMapping("memberList")
	public ModelAndView memberList(ModelAndView mav) {
		mav.setViewName("member/memberList");
		return mav;
	}
	
}
