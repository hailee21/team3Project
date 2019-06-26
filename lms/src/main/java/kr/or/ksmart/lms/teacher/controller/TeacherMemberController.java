package kr.or.ksmart.lms.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;
import kr.or.ksmart.lms.teacher.service.TeacherMemberService;

@Controller
public class TeacherMemberController {
	@Autowired private TeacherMemberService teacherMemberService;
	
	@GetMapping("/insertTeacher")
	public ModelAndView insertTeacher(ModelAndView mav) {
		mav.setViewName("teacher/member/insertTeacher");
		return mav;
	}
	//	강사코드 확인
	//	회원등록 처리
	/*@PostMapping("/insertTeacher")
	public ModelAndView insertTeacher(Member member, MemberOnline memberOnline, ModelAndView mav) {
		System.out.println("[MemberController memberInsert] member:" + member);
		teacherMemberService.insertTeacher(member, memberOnline);
		//mav.setViewName("redirect:/login?institutionCode=" + institutionCode);	로그인 바로가기
		mav.setViewName("redirect:/teacher/teacherLogin");
		return mav;
	}*/
}
