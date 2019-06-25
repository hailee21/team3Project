package kr.or.ksmart.lms.pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pi.mapper.PILoginMapper;
import kr.or.ksmart.lms.pi.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.vo.LoginRequest;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Service
public class PILoginService {
	@Autowired
	PILoginMapper piLoginMapper;
	
	//회원 온라인 액션 service
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return piLoginMapper.selectMemberOnline(loginRequest);
	}

	//인덱스 교육원 출력 service
	public IndexInstitution PIIndex(String institutionCode) {
		return piLoginMapper.selectInstitution(institutionCode);
	}
}
