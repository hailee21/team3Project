package kr.or.ksmart.lms.association.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationMemberService;

@RestController
public class AssociationMemberRestController {
	@Autowired private AssociationMemberService associationMemberService;
	
	@PostMapping("/instApprovalCheck")
	public boolean instApprovalCheck(@RequestParam(value="teacherApprovalCode", required=false) String institutionApprovalCode) {
		return associationMemberService.instApprovalCheck(institutionApprovalCode);
	}
}
