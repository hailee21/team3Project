package kr.or.ksmart.lms.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.mapper.MemberMapper;
import kr.or.ksmart.lms.member.vo.Member;
import kr.or.ksmart.lms.member.vo.MemberOnline;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	public IndexInstitution LEIndex(String institutionCode) {
		return memberMapper.selectInstitution(institutionCode);
	}
	public void insertMember(Member member) {
		String memberCodePK=memberMapper.selectMemberCodePk();
		int memberCodeNo = Integer.parseInt(memberCodePK.substring(1));
		memberCodeNo++;
		String memberCode = "M"+memberCodeNo;
		member.setMemberCode(memberCode);
		
		memberMapper.insertMember(member);
	}
	public void insertMemberOnline(MemberOnline memberOnline, Member member) {
		String memberCode = memberMapper.selectMemberCodePk();
		String memberOnlineCodePK=memberMapper.selectMemberOnlineCodePk();
		int memberOnlineCodeNo = Integer.parseInt(memberOnlineCodePK.substring(2));
		memberOnlineCodeNo++;
		String memberOnlineCode = "MO"+memberOnlineCodeNo;
		memberOnline.setMemberOnlineCode(memberOnlineCode);
		
		memberMapper.insertMemberOnline(memberOnline);
	}
	
}
