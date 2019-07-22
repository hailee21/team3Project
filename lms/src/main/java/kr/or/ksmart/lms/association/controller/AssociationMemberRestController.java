package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationMemberService;
import kr.or.ksmart.lms.association.vo.AssociationMember;

@RestController
public class AssociationMemberRestController {
	@Autowired private AssociationMemberService associationMemberService;
	
	@PostMapping("/instApprovalCheck")
	public boolean instApprovalCheck(@RequestParam(value="institutionApprovalCode", required=false) String institutionApprovalCode) {
		return associationMemberService.instApprovalCheck(institutionApprovalCode);
	}
	@GetMapping("/getAssociationMembers")
	public List<AssociationMember> selectMembers() {
		System.out.println("[AssociationMemberRestController selectMembers] 호출");
		List<AssociationMember> list = associationMemberService.associationMemberList();
		System.out.println("[AssociationMemberRestController selectMembers] " + list);
		return list;
	}
	@GetMapping("/getAssociationMembersRank")
	public List<AssociationMember> selectMemberRank(@RequestParam(value="memberRank", required=false) String memberRank, @RequestParam(value="institutionCode", required=false) String institutionCode) {
		System.out.println("[AssociationMemberRestController selectMemberRank] 호출");
		List<AssociationMember> rank = associationMemberService.selectMemberRank(memberRank, institutionCode);
		return rank;
	}
	@GetMapping("/getAssociationMembersInstitution")
	public List<AssociationMember> selectMemberInstitution(@RequestParam(value="institutionCode", required=false) String institutionCode) {
		System.out.println("[AssociationMemberRestController selectMemberInstitution] 호출");
		List<AssociationMember> code = associationMemberService.selectMemberInstitution(institutionCode);
		return code;
	}
}
