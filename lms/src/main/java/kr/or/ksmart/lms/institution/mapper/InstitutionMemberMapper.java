package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Mapper
public interface InstitutionMemberMapper {
	public List<InstitutionMember> selectInstitutionMemberList(String memberCode);
}
