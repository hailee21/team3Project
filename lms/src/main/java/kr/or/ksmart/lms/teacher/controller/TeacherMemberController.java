package kr.or.ksmart.lms.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.teacher.service.TeacherMemberService;

@Controller
public class TeacherMemberController {
	@Autowired private TeacherMemberService teacherMemberService;
	@GetMapping("/insertTeacher")
	public ModelAndView insertTeacher(ModelAndView mav) {
		mav.setViewName("teacher/member/insertTeacher");
		return mav;
	}
	
}
