package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionMemberMapper;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Service
public class InstitutionMemberService {
	@Autowired InstitutionMemberMapper institutionMemberMapper;
	
	//	교육원 직원 가입화면에서 select박스에 institutionList 출력
	public List<Institution> insertAdmin() {
		System.out.println("[InstitutionMemberService insertAdmin] 호출");
		List<Institution> instList = institutionMemberMapper.selectInstList();
		return instList;
	}
	//	회원 목록 출력
	public List<InstitutionMember> institutionMemberList (String institutionCode) {
		List<InstitutionMember> memberList = institutionMemberMapper.selectInstitutionMemberList(institutionCode);
		return memberList;
	}
}
