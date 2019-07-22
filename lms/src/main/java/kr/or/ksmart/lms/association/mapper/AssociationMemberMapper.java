package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.AssociationMember;
import kr.or.ksmart.lms.association.vo.MemberInstitution;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Mapper
public interface AssociationMemberMapper {
	//	회원가입폼에서 교육원 리스트 보여주기
	public List<Institution> selectInstList();
	//	institution_approval 테이블에서 발행된코드인지 조회
	public String selectAdminApprovalCode(String institutionApprovalCode);
	//	member_institution 테이블에서 사용여부확인을 위한 조회
	public String selectMemberInstitutionApprovalCode(String institutionApprovalCode);
	//	신규 회원 등록(member)
	public void insertMember(Member member);
	//	회원 아이디 저장
	public void insertMemberOnlineId(String memberOnlineInsertid);
	//	교육원 코드로 교육원이름 조회
	public String selectInstitutionName(String institutionCode);
	//	신규 회원 등록(memberOnline)
	public int insertMemberOnline(MemberOnline memberOnline);
	//	신규 직원 등록
	public void insertAdmin(MemberInstitution memberInstitution);
	
	//	Association 관리자 회원 전체조회
	public List<AssociationMember> selectAssociationMemberList();
	//	Association 관리자 회원 조회시 권한별 선택하기(select박스에 권한 리스트를 출력)
	public List<Member> selectAssociationMemberRank();
	//	Association 관리자 회원 조회시 교육원별 선택하기(select박스에 교육원 리스트를 출력)
	public List<AssociationMember> selectAssociationMemberInstitution();
	//	Association 관리자 회원 조회시 권한별 조회(결과)
	public List<AssociationMember> selectMemberRank(String memberRank, String institutionCode);
	//	Association 관리자 회언 조회시 교육원별 조회
	public List<AssociationMember> selectMemberInstitution(String institutionCode);
}
