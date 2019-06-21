package kr.or.ksmart.lms.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.vo.Member;
import kr.or.ksmart.lms.member.vo.MemberOnline;
@Mapper
public interface MemberMapper {
	//	협회/교육원코드
	public IndexInstitution selectInstitution(String institutionCode);
	
	//	신규회원등록
	public int insertMember(Member member);
	//	회원 아이디 저장
	public int insertMemberOnlineId(MemberOnline memberOnline);
	//	신규회원등록(memberOnline)
	public int insertMemberOnline(MemberOnline memberOnline);
	//	교육원 코드로 교육원이름 조회
	public String selectInstitutionName(String institutionCode);
	//	회원코드 PK 출력mapper
	public String selectMemberCodePk();
	//	회원온라인 코드 PK출력 mapper
	public String selectMemberOnlineCodePk();
}
