package kr.or.ksmart.lms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.login.mapper.LoginMapper;
import kr.or.ksmart.lms.login.vo.LoginRequest;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return loginMapper.selectMemberOnline(loginRequest);
	}
}
