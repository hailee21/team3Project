package kr.or.ksmart.lms.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.teacher.mapper.TeacherLoginMapper;
import kr.or.ksmart.lms.teacher.vo.LoginRequest;
import kr.or.ksmart.lms.teacher.vo.MemberOnline;

@Service
@Transactional
public class TeacherLoginService {
	@Autowired
	TeacherLoginMapper teacherLoginMapper;
	
	//협회 로그인 액션 service
	public MemberOnline getMemberOnline(LoginRequest loginRequest) {
		return teacherLoginMapper.selectMemberOnline(loginRequest);
	}

}
