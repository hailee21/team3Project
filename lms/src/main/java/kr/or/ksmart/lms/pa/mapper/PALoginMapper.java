package kr.or.ksmart.lms.pa.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pa.vo.MemberOnline;
import kr.or.ksmart.lms.pa.vo.IndexInstitution;
import kr.or.ksmart.lms.pa.vo.LoginRequest;

@Mapper
public interface PALoginMapper {
	
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);

	public IndexInstitution selectInstitution(String institutionCode);

}
