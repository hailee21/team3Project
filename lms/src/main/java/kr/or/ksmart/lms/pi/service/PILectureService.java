package kr.or.ksmart.lms.pi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;
import kr.or.ksmart.lms.pi.vo.LectureSignup;
import kr.or.ksmart.lms.pi.vo.NoticeLecture;

@Service
public class PILectureService {
	@Autowired private PILectureMapper piLectureMapper;
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public List<InfoLecture> piGetInfoLectureSortList() {
		System.out.println("[PILectureService piGetInfoLectureSortList]");
		return piLectureMapper.piSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> piGetInfoLectureNameList(String lectureSort) {
		System.out.println("[PILectureService piGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = piLectureMapper.piSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[PILectureService piGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> piGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[PILectureService piGetSubjectListByLectureCode]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = piLectureMapper.piSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[PILectureService piGetSubjectListByLectureCode] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
	
	// 수강신청을 위한 메서드
	// 1. 강의공고리스트에서 수강신청
	public List<NoticeLecture> piGetNoticeLectureList(String institutionCode){
		System.out.println("[PILectureService piGetNoticeLectureList]");
		
		// 단위테스트를 위해 list객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		List<NoticeLecture> list = piLectureMapper.piSelectNoticeLectureList(institutionCode);
		System.out.println("[PILectureService piGetNoticeLectureList] list: "+list);
		
		return list;
	}
	// 2. 강의공고세부조회에서 수강신청
	public NoticeLecture piSelectNoticeLectureDetailByNoticeLectureCode(String noticeLectureCode) {
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = piLectureMapper.piSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		return noticeLecture;
	}
	// 3. lectureSignup 화면을 위한 준비
	public NoticeLecture piGetNoticeLectureInfoForLectureSignup(String noticeLectureCode){
		System.out.println("[PILectureService piGetNoticeLectureInfoForLectureSignup]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = piLectureMapper.piSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		return noticeLecture;
	}
	// 4. 수강신청 메서드
	public void piAddLectureSignup(LectureSignup lectureSignup) {
		System.out.println("[PILectureService piAddLectureSignup]");
		
		// 1. 강의실 테이블에 추가할 PK 구하는 코드 
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
		String LSPK = "LS"+nowDate+randomNo;
		lectureSignup.setLectureSignupCode(LSPK);;
		System.out.println("[InstitutionClassroomService institutionAddClassroom] 최종 LSPK: "+LSPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		piLectureMapper.piInsertLectureSignup(lectureSignup);
	}
}
