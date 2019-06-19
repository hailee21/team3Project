package kr.or.ksmart.lms.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.mapper.MemberMapper;
import kr.or.ksmart.lms.member.vo.Member;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	public IndexInstitution LEIndex(String institutionCode) {
		return memberMapper.selectInstitution(institutionCode);
	}
	public int insertMember(Member member) {
		return memberMapper.insertMember(member);
	}
}
