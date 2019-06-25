package kr.or.ksmart.lms.association.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationLoginMapper;
import kr.or.ksmart.lms.association.vo.LoginRequest;
import kr.or.ksmart.lms.association.vo.MemberOnline;

@Service
@Transactional
public class AssociationLoginService {
	@Autowired
	AssociationLoginMapper associationLoginMapper;
	
	//협회 로그인 액션 service
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return associationLoginMapper.selectMemberOnline(loginRequest);
	}

}
