package kr.or.ksmart.lms.institution.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.MemberOnline;
import kr.or.ksmart.lms.institution.vo.AvailableInstitution;
import kr.or.ksmart.lms.institution.vo.LoginRequest;

@Mapper
public interface InstitutionLoginMapper {
	//교육원 로그인 select mapper
	public MemberOnline selectMemberOnline(LoginRequest loginRequest);

	//교육원 사용권한 select mapper
	public AvailableInstitution selectAvailableInstitution(String institutionCode);

	//교육원 사용권한 update mapper
	public void updateAvailableInstitution(AvailableInstitution availableInstitution);
}
