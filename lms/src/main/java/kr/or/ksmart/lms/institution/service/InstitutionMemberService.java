package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionMemberMapper;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Service
public class InstitutionMemberService {
	@Autowired InstitutionMemberMapper institutionMemberMapper;
	
	public List<InstitutionMember> institutionMemberList (String institutionCode) {
		List<InstitutionMember> memberList = institutionMemberMapper.selectInstitutionMemberList(institutionCode);
		return memberList;
	}
}
