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
	//	회원리스트 조회(교육원)	->	세션에서 교육원 코드 확인해서 교육원 직원, 강사, 교육원내 수강생들을 조회할 수 있음.
	@GetMapping("/institution/memberList")
	public ModelAndView instMemberList(ModelAndView mav) {
		mav.setViewName("institution/member/list");
		
		return mav;
	}
	//	회원리스트 조회(협회)	->	전체회원조회, 협회직원 조회, 등급별 조회, 교육원별 직원 조회, 교육원별 강사, 교육원별 수강생 조회
	@GetMapping("/association/memberList")
	public ModelAndView memberList(ModelAndView mav) {
		mav.setViewName("association/associationIndex");
		return mav;
	}
	//	수강생 조회(강사)	->	현재 진행중인 내 강의를 수강중인 학생에 한해서 조회
	@GetMapping("/teacher/memberList")
	public ModelAndView lectureStudentList(ModelAndView mav) {
		mav.setViewName("teacher/teacherIndex");
		return mav;
	}
}
