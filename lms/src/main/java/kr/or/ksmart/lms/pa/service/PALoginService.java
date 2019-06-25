package kr.or.ksmart.lms.pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pa.mapper.PALoginMapper;
import kr.or.ksmart.lms.pa.vo.IndexInstitution;
import kr.or.ksmart.lms.pa.vo.LoginRequest;
import kr.or.ksmart.lms.pa.vo.MemberOnline;

@Service
public class PALoginService {
	@Autowired
	PALoginMapper paLoginMapper;
	
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return paLoginMapper.selectMemberOnline(loginRequest);
	}

	public IndexInstitution PIIndex() {
		String institutionCode = "I0";
		return paLoginMapper.selectInstitution(institutionCode);
	}
}
