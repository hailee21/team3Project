package kr.or.ksmart.lms.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Mapper
public interface LoginMapper {
	
	public MemberOnline selectMemberOnline(kr.or.ksmart.lms.association.vo.LoginRequest loginRequest);
	public IndexInstitution selectInstitution(String institutionCode);
}
