package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionLectureMapper;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;
import kr.or.ksmart.lms.institution.vo.Lecture;
import kr.or.ksmart.lms.institution.vo.LectureSignup;
import kr.or.ksmart.lms.institution.vo.LectureSignupResult;
import kr.or.ksmart.lms.institution.vo.LectureSignupResultDomain;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Service
public class InstitutionLectureService {
	
	@Autowired private InstitutionLectureMapper institutionLectureMapper;
	
	// infoLecture 리스트 조회 메서드
	// 1. select sort 
	public List<InfoLecture> institutionGetInfoLectureSortList() {
		System.out.println("[InstitutionLectureService institutionGetInfoLectureSortList]");
		return institutionLectureMapper.institutionSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> institutionGetInfoLectureNameList(String lectureSort) {
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = institutionLectureMapper.institutionSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> institutionGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = institutionLectureMapper.institutionSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList] subjectList: "+subjectList);
		return subjectList;
	}	
	
	// detailSubject 조회 메서드
	public InfoSubject institutionGetDetailSubjectByInfoSubjectCode(String infoSubjectCode) {
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]");
		
		// mapper에서 받은 detailSubject값을 infoSubject객체참조변수 내부에 담아서 controller에서 사용하기 
		InfoSubject infoSubject = institutionLectureMapper.institutionSelectDetailSubjectByInfoSubjectCode(infoSubjectCode);
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]infoSubject: "+infoSubject);		
		return infoSubject;
	}
	
	// lecture리스트 조회 메서드
	public List<Lecture> institutionGetLectureListByInstitutionCode(String institutionCode){
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]");
		
		// mapper에서 받은 list처리된 Lecture들을 list객체참조변수 내부에담아서 controller에서 사용하기
		List<Lecture> list = institutionLectureMapper.institutionSelectLectureListByInstitutionCode(institutionCode);
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode] list: "+list);
		return list;
	}
	// detailLecture 조회 메서드
	public Lecture institutionGetDetailLectureByLectureCode(String lectureCode) {
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode]");
		
		// mapper에서 받은 detailLecture를 lecture객체참조변수 내부에담아서 controller에서 사용하기
		Lecture lecture = institutionLectureMapper.institutionSelectDetailLectureByLectureCode(lectureCode);
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode] lecture: "+lecture);
		return lecture;
	}
	
	// 면접결과 등록을 위한 준비
	// 1. 해당 교육원의 모집중인 notice_lecture리스트 출력
	public List<NoticeLecture> institutionGetNoticeLectureListForLectureSignupResult(String institutionCode){
		System.out.println("[InstitutionLectureService institutionGetNoticeLectureListForLectureSignupResult]");
		
		// mapper에서 받은 detailLecture를 lecture객체참조변수 내부에담아서 controller에서 사용하기
		List<NoticeLecture> list = institutionLectureMapper.institutionSelectNoticeLectureListByInstitutionCode(institutionCode);
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode] list: "+list);
		return list;
	}
	// 2. 해당 강의공고 조회 -> 수강신청자 목록 출력 
	public Map<String, Object> institutionGetLectureSignupListByNoticeLectureCode(String noticeLectureCode){
		System.out.println("[InstitutionLectureService institutionGetLectureSignupListByNoticeLectureCode]");
		// mapper에서 받은 detailLecture를 lecture객체참조변수 내부에담아서 controller에서 사용하기
		NoticeLecture noticeLecture = institutionLectureMapper.institutionSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode] noticeLecture: "+noticeLecture);
		
		// mapper에서 받은 detailLecture를 lecture객체참조변수 내부에담아서 controller에서 사용하기
		List<LectureSignup> lectureSignupList = institutionLectureMapper.institutionSelectLectureSignupListByNoticeLectureCode(noticeLectureCode);
		System.out.println("[InstitutionLectureService institutionGetLectureSignupListByNoticeLectureCode] lectureSignupList: "+lectureSignupList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeLecture", noticeLecture);
		map.put("lectureSignupList", lectureSignupList);
		
		return map;
	}
	// 3. 면접결과 등록 처리 -> lecture_signup_result 0등록
	public void institutionAddLectureSignupResult(LectureSignupResult lectureSignupResult) {
		System.out.println("[InstitutionLectureService institutionAddLectureSignupResult]");
		
		// List처리된 pk 생성 및 입력을 위해 vo에서 리스트 분리하기
		List<String> lectureSignupCodeList = lectureSignupResult.getLectureSignupCode();
		List<Integer> lectureSignupResultList = lectureSignupResult.getLectureSignupResult();
		System.out.println("[InstitutionLectureService institutionAddLectureSignupResult] lectureSignupCodeList 사이즈: "+lectureSignupCodeList.size());
		System.out.println("[InstitutionLectureService institutionAddLectureSignupResult] lectureSignupResultList 사이즈: "+lectureSignupResultList.size());
		
		// lectureSignupResult 테이블에 추가할 pk구하는 코드
		// 1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
        String nowDate = dateFormat.format(now);
        System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
        nowDate = nowDate.toString().replace(" ", "");
        System.out.println("nowDate2: "+nowDate);
        
		//2. 리스트 크기만큼 반복하도록 반복문 작성		
		for(int i=0; i<lectureSignupCodeList.size(); i++) {
            // 2-1. 테이블의 PK를 위한 무작위 숫자 생성
            int randomNo1 = (int)(Math.random()*10000);
            int randomNo2 = (int)(Math.random()*1000);
            int randomNo3 = (int)(Math.random()*100);
            int randomNo = randomNo1 + randomNo2 + randomNo3;
            if(randomNo >= 10000) {
                randomNo = randomNo/10;
            }
            // 2-2. 테이블 형식에 맞게 변수를 선언하고 이를 vo에 담는다
            String lectureSignupResultCode = "LSR" + nowDate + randomNo;
            // 2-3. 테이블 형식과 일치하는 domain내부에 값을 세팅 한 뒤 이를 이용해서 mapper의 insert 메서드를 호출하자
            LectureSignupResultDomain lectureSignupResultDomain = new LectureSignupResultDomain();
            
            lectureSignupResultDomain.setLectureSignupResultCode(lectureSignupResultCode);
            lectureSignupResultDomain.setLectureSignupCode(lectureSignupCodeList.get(i));		// lectureSignupCodeList의 i번째 배열이 세팅되도록 하자
            lectureSignupResultDomain.setLectureSignupResult(lectureSignupResultList.get(i));	// lectureSignupResultList의 i번째 배열이 세팅되도록 하자
            lectureSignupResultDomain.setNoticeLectureCode(lectureSignupResult.getNoticeLectureCode());
            lectureSignupResultDomain.setInstitutionCode(lectureSignupResult.getInstitutionCode());
            lectureSignupResultDomain.setInstitutionName(lectureSignupResult.getInstitutionName());
            
            // 3. lectureSignupResult테이블에 결과 등록하기
            institutionLectureMapper.institutionInsertLectureSignupResult(lectureSignupResultDomain);
		}
		// 4. notice_lecture 테이블 상태 수정
        String noticeLectureCode = lectureSignupResult.getNoticeLectureCode();
        System.out.println("[InstitutionLectureService institutionAddLectureSignupResult] noticeLectureCode: "+noticeLectureCode);
        
        institutionLectureMapper.institutionSelectNoticeLectureStatusByNoticeLectureCode(noticeLectureCode);
        institutionLectureMapper.institutionUpdateNoticeLectureStatusByNoticeLectureCode(noticeLectureCode);        
	}
	// 4. notice_lecture_status 모집완료 로 업데이트
		
}
