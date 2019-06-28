package kr.or.ksmart.lms.pi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.mapper.PIMemberMapper;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;


@Service
public class PIMemberService {
	@Autowired
	PIMemberMapper memberMapper;
	public IndexInstitution PIIndex(String institutionCode) {
		return memberMapper.selectInstitution(institutionCode);
	}
	public List<Institution> memberJoin() {
		System.out.println("[PIMemberService memberJoin]");
		List<Institution> instList = memberMapper.selectInstList();
		System.out.println("[PIMemberService memberJoin] Join : " + instList);
		return instList;
	}
	public void insertMember(Member member, MemberOnline memberOnline, String institutionCode) {
		//	member 테이블에 insert 준비. membercode 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 11);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String memberCode="M"+nowDate+randomNo;
		member.setMemberCode(memberCode);	//Member VO 내 memberCode set
		//	member 테이블에 insert
		memberMapper.insertMember(member);	//	mapper 실행
		
		//	member_online_insertid 테이블에 member_online_id insert
		memberMapper.insertMemberOnlineId(memberOnline);
		
		//	member_online 테이블에 insert
		
		String memberOnlineCode = "MO"+nowDate+randomNo;	//	memberOnlineCode 생성
		System.out.println("[MemberService insertMemberOnline] memberOnlineCode : " + memberOnlineCode);
		memberOnline.setMemberOnlineCode(memberOnlineCode);	//	memberOnline VO 내 memberOnlineCode set
		memberOnline.setMemberCode(memberCode);
		String institutionName = memberMapper.selectInstitutionName(institutionCode);
		memberOnline.setInstitutionName(institutionName);
		
		memberMapper.insertMemberOnline(memberOnline);	//mapper 실행		
	}

}
