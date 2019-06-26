package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssocitationNoticeAnnualLicenseTestMapper;
import kr.or.ksmart.lms.association.vo.NoticeAnnualLicenseTest;

@Service
@Transactional
public class AssocitationNoticeAnnualLicenseTestService {
	@Autowired
	AssocitationNoticeAnnualLicenseTestMapper associtationNoticeAnnualLicenseTestMapper;
	//연간 자격 시험 일정 등록
	public void insertNoticeAnnualLicenseTest(NoticeAnnualLicenseTest noticeAnnualLicenseTest) {
		
	}
	
	//연간 자격 시험 일정 List
	public List<NoticeAnnualLicenseTest> selectNoticeAnnualLicenseTest() {
		List<NoticeAnnualLicenseTest> list = associtationNoticeAnnualLicenseTestMapper.selectNoticeAnnualLicenseTest();
		return list;
	}
			
}
