package kr.or.ksmart.lms.institution.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionLoginMapper;
import kr.or.ksmart.lms.institution.vo.AvailableInstitution;
import kr.or.ksmart.lms.institution.vo.LoginRequest;
import kr.or.ksmart.lms.institution.vo.MemberOnline;

@Service
@Transactional
public class InstitutionLoginService {
	@Autowired
	InstitutionLoginMapper institutionLoginMapper;
	
	//교육원 로그인 액션 service
	public Map<String, Object> getMemberOnline(LoginRequest loginRequest) {
		//로그인을 위한 mapper 호출
		MemberOnline memberOnline = institutionLoginMapper.selectMemberOnline(loginRequest);
		
		//교육원 사용권한 조회를 위한 mapper 호출
		AvailableInstitution availableInstitution = institutionLoginMapper.selectAvailableInstitution(memberOnline.getInstitutionCode());
		
		//교육원 사용권한 조회
		boolean Check = false;
		int remainingDate = 0;
		if(availableInstitution != null) {
			if(availableInstitution.getAvailableInstitutionRemainingDate() > 0) {
				Check = true;
				remainingDate = availableInstitution.getAvailableInstitutionRemainingDate();
			}			
		}

		//컨트롤러로 리턴할 데이터 선언 및 설정
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("memberOnline", memberOnline);
		returnMap.put("Check", Check);
		returnMap.put("remainingDate", remainingDate);
		return returnMap;
	}

}
