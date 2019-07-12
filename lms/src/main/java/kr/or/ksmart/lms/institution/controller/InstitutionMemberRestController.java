package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.institution.service.InstitutionMemberService;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@RestController
public class InstitutionMemberRestController {
	@Autowired private InstitutionMemberService institutionMemberService;
	
	@GetMapping("/rankList")
	public List<InstitutionMember> selectMemberRank(@RequestParam (value="memberRank", required = true) String memberRank){
		System.out.println("[InstitutionMemberRestController selectMemberRank] 호출" + memberRank);
		List<InstitutionMember> rank = institutionMemberService.selectMemberRank(memberRank);
		return rank;
	}
}
