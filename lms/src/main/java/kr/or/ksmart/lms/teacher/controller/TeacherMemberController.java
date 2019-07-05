package kr.or.ksmart.lms.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.vo.MemberTeacher;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;
import kr.or.ksmart.lms.teacher.service.TeacherMemberService;

@Controller
public class TeacherMemberController {
	@Autowired private TeacherMemberService teacherMemberService;
	
	@GetMapping("/insertTeacher")
	public ModelAndView insertTeacher(ModelAndView mav) {
		//	교육원명 출력하기 위한 institutionList map
		List<Institution> instList = teacherMemberService.insertTeacher();
		mav.addObject("instList", instList);
		mav.setViewName("teacher/member/insertTeacher");
		return mav;
	}
	@PostMapping("/insertTeacher")
	public ModelAndView insertTeacher(ModelAndView mav, Member member, MemberOnline memberOnline, MemberTeacher memberTeacher
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		System.out.println("[TeacherMemberRestController insertTeacher] member:" + member);
		teacherMemberService.insertTeacher(member, memberOnline, memberTeacher, institutionCode);
		mav.setViewName("redirect:/teacherLogin");	//로그인 바로가기
		return mav;
	}
	//	강사코드 확인
	
}
