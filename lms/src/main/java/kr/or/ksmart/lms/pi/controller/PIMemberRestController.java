package kr.or.ksmart.lms.pi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.service.PIMemberService;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@RestController
public class PIMemberRestController {
	@Autowired PIMemberService memberService;
	
	@PostMapping("/memberInsert")
	public void memberInsert(Member member, MemberOnline memberOnline
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		System.out.println("[MemberController memberInsert] member:" + member);
		memberService.insertMember(member, memberOnline, institutionCode);
//		mav.setViewName("redirect:/login?institutionCode=" + institutionCode);	//	로그인 바로가기
//		mav.setViewName("redirect:/joinSuccess?institutionCode=" + institutionCode);
		
	}
	//	id 중복검사
	@PostMapping("/idCheck")
	public boolean idCheck(@RequestParam(value="memberOnlineId", required=false) String memberOnlineId) {
        System.out.println("/idCheck 요청");
        return memberService.idCheck(memberOnlineId);
	}
}
