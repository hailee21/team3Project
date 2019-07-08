package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionLectureFailMapper;
import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Service
public class InstitutionLectureFailService {
	
	@Autowired InstitutionLectureFailMapper institutionLectureFailMapper;
	
	// 세부 폐강강의공고 출력
	public LectureFail institutionGetLectureFailByLectureFailCode(String lectureFailCode) {
		System.out.println("[InstitutionLectureFailService institutionGetLectureFailByLectureFailCode]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		LectureFail lectureFail = institutionLectureFailMapper.institutionSelectLectureFailByLectureFailCode(lectureFailCode);
		System.out.println("[InstitutionLectureFailService institutionGetLectureFailByLectureFailCode] lectureFail: "+lectureFail);
		
		return lectureFail;
	}
	
	// 폐강예정 리스트 출력
	public List<NoticeLecture> institutionGetFailWaitingLectureList(){
		System.out.println("[InstitutionLectureFailService institutionGetFailWaitingLectureList]");
		
		// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
		List<NoticeLecture> failWaitingList = institutionLectureFailMapper.institutionSelectFailWaitingList();
		System.out.println("[InstitutionLectureFailService institutionGetFailWaitingLectureList] failWaitingList: "+failWaitingList);
		
		return failWaitingList;
	}

	// 폐강등록화면 출력
	public NoticeLecture institutionGetFailLectureInfo(String noticeLectureCode){
		System.out.println("[InstitutionLectureFailService institutionGetFailLectureInfo]");
		System.out.println("[InstitutionLectureFailService institutionGetFailLectureInfo] noticeLectureCode: "+noticeLectureCode);
		
		// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
		NoticeLecture noticeLecture = institutionLectureFailMapper.institutionSelectNoticeLectureInfoToAddFailLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[InstitutionLectureFailService institutionGetFailLectureInfo] noticeLecture: "+noticeLecture);
		
		return noticeLecture;
		}
	
	// 폐강등록을 위한 PK생성 및 등록 + noticeLecture테이블에서 삭제
	public void institutionAddFailLectureAndDeleteNoticeLecture(LectureFail lectureFail, String noticeLectureCode) {
		System.out.println("[InstitutionLectureFailService institutionAddFailLectureAndDeleteNoticeLecture]");
		
		// 1. lectureFail 테이블에 추가할 PK 구하는 코드 
		// 1-1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println("nowDate2: "+nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		// 1-2. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String LFPK = "LF"+nowDate+randomNo;
		lectureFail.setLectureFailCode(LFPK);
		System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture] 최종 LFPK: "+LFPK);
		
		// 2. lectureFail 테이블에 폐강 등록하기		
		institutionLectureFailMapper.institutionInsertLectureFail(lectureFail);
		 
		// 3. 폐강 등록 후 notice_lecture에서 해당 강의공고 삭제하기
		institutionLectureFailMapper.institutionDeleteNoticeLectureAfterInsertLectureFailByNoticeLectureCode(noticeLectureCode);
		
	}
}
