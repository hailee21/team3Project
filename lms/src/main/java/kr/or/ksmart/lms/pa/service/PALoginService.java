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
	
	//회원 온라인 액션 service
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return paLoginMapper.selectMemberOnline(loginRequest);
	}

	//인덱스 교육원 출력 service
	public IndexInstitution PIIndex() {
		String institutionCode = "I20120101000000";
		return paLoginMapper.selectInstitution(institutionCode);
	}
}
