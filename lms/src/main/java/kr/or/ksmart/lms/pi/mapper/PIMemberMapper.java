package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;
@Mapper
public interface PIMemberMapper {
	//	협회/교육원코드
	public IndexInstitution selectInstitution(String institutionCode);
	//	회원가입폼에서 교육원 리스트 보여주기
	public List<Institution> selectInstList();
	//	신규회원등록
	public int insertMember(Member member);
	//	회원 아이디 저장
	public int insertMemberOnlineId(MemberOnline memberOnline);
	//	신규회원등록(memberOnline)
	public int insertMemberOnline(MemberOnline memberOnline);
	//	교육원 코드로 교육원이름 조회
	public String selectInstitutionName(String institutionCode);
}
