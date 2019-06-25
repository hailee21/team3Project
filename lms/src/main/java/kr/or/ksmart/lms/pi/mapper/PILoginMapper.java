package kr.or.ksmart.lms.pi.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.MemberOnline;
import kr.or.ksmart.lms.pi.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.vo.LoginRequest;

@Mapper
public interface PILoginMapper {
	//회원 온라인 select mapper 
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);

	//인덱스 교육원 select mapper
	public IndexInstitution selectInstitution(String institutionCode);

}
