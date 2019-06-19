package kr.or.ksmart.lms.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.member.service.MemberService;
import kr.or.ksmart.lms.member.vo.Member;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	//	회원가입 페이지 join.html
	@GetMapping("memberInsert")
	public ModelAndView memberJoin(ModelAndView mav) {
		mav.setViewName("layout/memberInsertForm");
		return mav;
	}
	@PostMapping("memberInsert")
	public String memberInsert(Member member) {
		memberService.insertMember(member);
		return "redirect:/memberList";
	}
}
