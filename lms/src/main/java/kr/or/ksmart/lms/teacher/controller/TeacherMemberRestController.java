package kr.or.ksmart.lms.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.teacher.service.TeacherMemberService;

@RestController
public class TeacherMemberRestController {
	@Autowired private TeacherMemberService teacherMemberService;
	
	@PostMapping("/approvalCheck")
	public boolean approvalCodeCheck(@RequestParam(value="teacherApprovalCode", required=false) String teacherApprovalCode) {
		System.out.println("[TeacherMemberRestController approvalCheck] 호출");
		return teacherMemberService.approvalCodeCheck(teacherApprovalCode);
	}
}
