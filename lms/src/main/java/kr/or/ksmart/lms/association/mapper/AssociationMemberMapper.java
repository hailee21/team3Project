package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.Member;

@Mapper
public interface AssociationMemberMapper {
	//	회원가입폼에서 교육원 리스트 보여주기
//	public List<Institution> selectInstList();
	//	institution_approval 테이블에서 발행된코드인지 조회
	public String selectAdminApprovalCode(String institutionApprovalCode);
	//	member_institution 테이블에서 사용여부확인을 위한 조회
	public String selectMemberInstitutionApprovalCode(String teacherApprovalCode);
	//	//	신규 회원 등록(member)
	public void insertMember(Member member);
}
