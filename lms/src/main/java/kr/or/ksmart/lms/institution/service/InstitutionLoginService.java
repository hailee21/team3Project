package kr.or.ksmart.lms.institution.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		boolean Check = false;
		int remainingDate = 0;
		if(memberOnline == null) {
			Check = false;
			remainingDate = 0;
		} else {
			//오늘 날짜 계산한다.
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS"); //DB에 저장되는 형식과 동일한 형태
			Date now = new Date(); 
			Timestamp startDate = Timestamp.valueOf(dateFormat.format(now));
			long longStartDate = startDate.getTime();

			//교육원 사용권한 조회를 위한 mapper 호출 및 업데이트
			AvailableInstitution availableInstitution = institutionLoginMapper.selectAvailableInstitution(memberOnline.getInstitutionCode());
			
			if(availableInstitution != null) {
				System.out.println(availableInstitution);
				Timestamp endDate = Timestamp.valueOf(availableInstitution.getPaymentAnnualFeeServiceEndDate());
				long longEndDate = endDate.getTime();
				long oneDay = (1000*60*60*24);
				remainingDate = (int)((longEndDate - longStartDate) / oneDay); //종료일 - 시작일의 결과를 하루로 나누워서 계산한다.
				String availability = "사용가능";
				if(remainingDate <= 0 ){
					availability = "사용불가능";
					remainingDate = 0;
				} else {
					Check = true;
				}
				availableInstitution.setAvailableInstitutionAvailability(availability);
				availableInstitution.setAvailableInstitutionRemainingDate(remainingDate);
				System.out.println(availableInstitution);
				//available_institution 테이블 update mapper 호출
				institutionLoginMapper.updateAvailableInstitution(availableInstitution);
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
