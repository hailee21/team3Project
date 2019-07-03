package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		 //테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo >= 10000) {
			randomNo = randomNo/10;
		}
		String noticeAnnualLicenseTestCode = "NALT"+nowDate+randomNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		noticeAnnualLicenseTest.setNoticeAnnualLicenseTestCode(noticeAnnualLicenseTestCode); //선언된 PK를 VO에 입력한다.
		associtationNoticeAnnualLicenseTestMapper.insertNoticeAnnualLicenseTest(noticeAnnualLicenseTest);
	}
	
	//연간 자격 시험 일정 List
	public List<NoticeAnnualLicenseTest> selectNoticeAnnualLicenseTest() {
		List<NoticeAnnualLicenseTest> list = associtationNoticeAnnualLicenseTestMapper.selectNoticeAnnualLicenseTest();
		return list;
	}
			
}
