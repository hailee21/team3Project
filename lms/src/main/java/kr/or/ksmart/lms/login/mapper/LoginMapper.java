package kr.or.ksmart.lms.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.login.vo.MemberOnline;
import kr.or.ksmart.lms.login.vo.LoginRequest;

@Mapper
public interface LoginMapper {
	
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);
	public IndexInstitution selectInstitution(String institutionCode);
}
