package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationMemberMapper;
import kr.or.ksmart.lms.association.vo.AssociationMember;
import kr.or.ksmart.lms.association.vo.MemberInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Service
@Transactional
public class AssociationMemberService {
	@Autowired private AssociationMemberMapper associationMemberMapper;
	
	//	직원 회원 가입화면에서 select박스에 institutionList 출력
	public List<Institution> insertAdmin() {
		System.out.println("[AssociationMemberService insertAdmin]");
		List<Institution> instList = associationMemberMapper.selectInstList();
		return instList;
	}
	
	// 	직원 승인코드 존재유무와 사용여부 조회
	public boolean instApprovalCheck(String institutionApprovalCode) {
		String search = associationMemberMapper.selectAdminApprovalCode(institutionApprovalCode);
		String result = associationMemberMapper.selectMemberInstitutionApprovalCode(institutionApprovalCode);
		System.out.println("[AssociationMemberService 직원코드존재여부 확인] " + search);
		boolean code = false;
		if (search != null) {	//	입력받은코드가 institution_approval에 있으면(결과가 null이 아니면)
			System.out.println("[instApprovalCheck member_institution code]select 결과 :" + search);
			if (result == null) {	//	입력받은 코드가  member_institution에 없으면(결과가 null이면)
				System.out.println("[instApprovalCheck member_institution에서 code]select 결과 :" + result);
				code = true;
			}
		}
		return code;
	}
	public void insertAdmin(Member member, MemberOnline memberOnline, MemberInstitution memberInstitution, String institutionCode) {
		//	member 테이블에 insert 준비. memberCode 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
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
		associationMemberMapper.insertMember(member);	// mapper 실행
		
		//	member_online_insertid 테이블에 member_online_id insert
		String memberOnlineInsertid = memberOnline.getMemberOnlineId();
		associationMemberMapper.insertMemberOnlineId(memberOnlineInsertid);
		
		//	member_online 테이블에 insert
		String memberOnlineCode = "MO"+nowDate+randomNo;	//	memberOnlineCode 생성
		System.out.println("[TeacherMemberService insertTeacher] memberOnlineCode : " + memberOnlineCode);
		memberOnline.setMemberOnlineCode(memberOnlineCode);	//	memberOnline VO 내 memberOnlineCode set
		memberOnline.setMemberCode(memberCode);
		String institutionName = associationMemberMapper.selectInstitutionName(institutionCode);
		memberOnline.setInstitutionName(institutionName);
		
		associationMemberMapper.insertMemberOnline(memberOnline);	//	mapper 실행
		
		//	member_institution 테이블에 insert
		String memberInstitutionCode = "MI"+nowDate+randomNo;	//	memberTeacherCode 생성
		System.out.println("[TeacherMemberService insertTeacher] memberTeacherCode : " + memberInstitutionCode);
		System.out.println(memberInstitution);
		memberInstitution.setMemberInstitutionCode(memberInstitutionCode);
		memberInstitution.setMemberCode(memberCode);
		
		associationMemberMapper.insertAdmin(memberInstitution);
	}
	
	//	회원목록에서 권한별 select
	public List<Member> selectMemberRankList() {
		List<Member> memberRank = associationMemberMapper.selectAssociationMemberRank();
		return memberRank;
	}
	//	회원목록에서 교육원별 select
	public List<AssociationMember> selectMemberInstitutionList() {
		List<AssociationMember> institution = associationMemberMapper.selectAssociationMemberInstitution();
		return institution;
	}
	//	회원목록 전체조회
	public List<AssociationMember> associationMemberList() {
		System.out.println("[AssocationMemberService assocationMemberList] 호출");
		List<AssociationMember> memberList = associationMemberMapper.selectAssociationMemberList();
		return memberList;
	}
	//	회원권한별 조회
	public List<AssociationMember> selectMemberRank (String memberRank, String institutionCode) {
		List<AssociationMember> rank = associationMemberMapper.selectMemberRank(memberRank, institutionCode);
		return rank;
	}
	//	회원 조회-교육원별 조회
	public List<AssociationMember> selectMemberInstitution(String institutionCode){
		List<AssociationMember> instCode = associationMemberMapper.selectMemberInstitution(institutionCode);
		return instCode;
	}
}
