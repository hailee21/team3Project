package kr.or.ksmart.lms.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.vo.MemberTeacher;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;
import kr.or.ksmart.lms.teacher.service.TeacherMemberService;

@RestController
public class TeacherMemberRestController {
	@Autowired private TeacherMemberService teacherMemberService;
	
	@PostMapping("/insertTeacher")
	public void insertTeacher(Member member, MemberOnline memberOnline, MemberTeacher memberTeacher
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		System.out.println("[TeacherMemberRestController insertTeacher] member:" + member);
		teacherMemberService.insertTeacher(member, memberOnline, memberTeacher, institutionCode);
		
	}
}
