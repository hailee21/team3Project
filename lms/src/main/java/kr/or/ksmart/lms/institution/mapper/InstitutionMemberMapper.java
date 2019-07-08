package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Mapper
public interface InstitutionMemberMapper {
	public List<InstitutionMember> selectInstitutionMemberList(String memberCode);
	//	회원가입폼에서 교육원 리스트 보여주기
	public List<Institution> selectInstList();
}
