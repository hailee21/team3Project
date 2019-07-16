package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	@GetMapping("/getMembers")
	public List<InstitutionMember> selectMember(HttpSession session) {
		String institutionCode = (String)session.getAttribute("institutionCode");
		List<InstitutionMember> list = institutionMemberService.institutionMemberList(institutionCode);
		System.out.println("[InstitutionMemberRestController selectMember] memberList(institutionCode)"+list);
		return list;
	}
}
