package kr.or.ksmart.lms.teacher.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.teacher.vo.LoginRequest;
import kr.or.ksmart.lms.teacher.vo.MemberOnline;

@Mapper
public interface TeacherLoginMapper {
	//협회 로그인 select mapper
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);
}
