package kr.or.ksmart.lms.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.member.mapper.MemberMapper;
import kr.or.ksmart.lms.member.vo.Member;
import kr.or.ksmart.lms.member.vo.MemberOnline;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	public IndexInstitution PIIndex(String institutionCode) {
		return memberMapper.selectInstitution(institutionCode);
	}
	public void insertMember(Member member, MemberOnline memberOnline, String institutionCode) {
		//	member 테이블에 insert
		String memberCodePK=memberMapper.selectMemberCodePk(); //memberCode 조회
		int memberCodeNo = Integer.parseInt(memberCodePK.substring(1));
		memberCodeNo++;
		String memberCode = "M"+memberCodeNo;	//memberCode 생성
		member.setMemberCode(memberCode);	//Member VO 내 memberCode set
		
		memberMapper.insertMember(member);	//	mapper 실행
		
		//	member_online_insertid 테이블에 member_online_id insert
		memberMapper.insertMemberOnlineId(memberOnline);
		
		//	member_online 테이블에 insert
		String memberOnlineCodePK=memberMapper.selectMemberOnlineCodePk();	//	memberOnlineCode 조회
		int memberOnlineCodeNo = Integer.parseInt(memberOnlineCodePK.substring(2));
		memberOnlineCodeNo++;
		String memberOnlineCode = "MO"+memberOnlineCodeNo;	//	memberOnlineCode 생성
		System.out.println("[MemberService insertMemberOnline] memberOnlineCode : " + memberOnlineCode);
		memberOnline.setMemberOnlineCode(memberOnlineCode);	//	memberOnline VO 내 memberOnlineCode set
		memberOnline.setMemberCode(memberCode);
		String institutionName = memberMapper.selectInstitutionName(institutionCode);
		memberOnline.setInstitutionName(institutionName);
		
		memberMapper.insertMemberOnline(memberOnline);	//mapper 실행		
	}

}
