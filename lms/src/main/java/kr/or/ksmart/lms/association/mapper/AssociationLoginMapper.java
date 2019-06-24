package kr.or.ksmart.lms.association.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.LoginRequest;
import kr.or.ksmart.lms.association.vo.MemberOnline;

@Mapper
public interface AssociationLoginMapper {
	//협회 로그인 select mapper
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);
}
