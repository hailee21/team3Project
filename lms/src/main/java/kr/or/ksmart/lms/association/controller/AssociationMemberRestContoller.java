package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationMemberService;
import kr.or.ksmart.lms.association.vo.AssociationMember;

@RestController
public class AssociationMemberRestContoller {
	@Autowired private AssociationMemberService associationMemberService;
	
	@GetMapping("/getAssociationMembers")
	public List<AssociationMember> selectMembers() {
		List<AssociationMember> list = associationMemberService.associationMemberList();
		System.out.println("[AssociationMemberService selectMembers] " + list);
		return list;
	}
	@GetMapping("/getAssociationMembersRank")
	public List<AssociationMember> selectMemberRank(@RequestParam () String memberRank) {
		System.out.println("[AssociationMemberService selectMemberRank] 호출");
		List<AssociationMember> rank = associationMemberService.selectMemberRank(memberRank);
		return rank;
	}
	
}
