package kr.or.ksmart.lms.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.login.vo.LoginRequest;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Mapper
public interface LoginMapper {
	
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);
}
