package kr.or.ksmart.lms.institution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionLectureFailMapper;
import kr.or.ksmart.lms.institution.vo.LectureFail;

@Service
public class InstitutionLectureFailService {
	
	@Autowired InstitutionLectureFailMapper institutionLectureFailMapper;
	
	// 세부 강의공고 출력
	public LectureFail institutionGetLectureFailByLectureFailCode(String lectureFailCode) {
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureByNoticeLectureCode]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		LectureFail lectureFail = institutionLectureFailMapper.institutionSelectLectureFailByLectureFailCode(lectureFailCode);
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureByNoticeLectureCode] lectureFail: "+lectureFail);
		
		return lectureFail;
	}

}
