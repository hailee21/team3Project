package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Mapper
public interface InstitutionMemberMapper {
	//	Institution 관리자 회원 조회
	public List<InstitutionMember> selectInstitutionMemberList(String institutionCode);
	//	회원가입폼에서 교육원 리스트 보여주기
	public List<Institution> selectInstList();
	//	Institution 관리자 회원 조회시 권한별 선택
	public List<InstitutionMember> selectInstitutionMemberRank();
	//	Institution 관리자 회원 조회시 권한별 조회(결과)
	public List<InstitutionMember> selectMemberRank(String memberRank);
}
