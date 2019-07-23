package kr.or.ksmart.lms.pi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;
import kr.or.ksmart.lms.pi.vo.Institution;
import kr.or.ksmart.lms.pi.vo.LectureSignup;
import kr.or.ksmart.lms.pi.vo.LectureSignupResult;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.NoticeLecture;
import kr.or.ksmart.lms.pi.vo.PaymentLecture;

@Service
public class PILectureService {
	@Autowired private PILectureMapper piLectureMapper;
	
	// 화면출력을 위한 교육원명 고르기
	public Institution piGetInstitutionName(String institutionCode) {
		// 교육원코드 활용해서 화면에 출력할 교육원명, 코드 가져오기
		Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
		return institution;
	}
	
	// 회원정보 조회를 위한 메서드 
	public Member piGetMemberInfo(String memberCode) {
		// memberCode사용해서 회원정보 가져오기
		Member member = piLectureMapper.piSelectMemberInfo(memberCode);
		return member;
	}
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public Map<String, Object> piGetInfoLectureSortList(String institutionCode) {
		System.out.println("[PILectureService piGetInfoLectureSortList]");
		
		// Controller로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		// mapper에서 호출한 리스트 값을 list객체참조변수에 담는다
		List<InfoLecture> list = piLectureMapper.piSelectInfoLectureSortList();		
		
		// service내부의 institution의 정보를 호출하는 메서드를 호출하자.
		Institution institution = piGetInstitutionName(institutionCode);
		
		// 값이 담긴 list, instituiton 객체참조변수를 map 내부에 담아 controller에서 사용하자. 
		map.put("list", list);
		map.put("institution", institution);
		return map;
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
	// 1-1. 강의공고리스트에서 수강신청
	public Map<String, Object> piGetNoticeLectureList(String institutionCode){
		System.out.println("[PILectureService piGetNoticeLectureList]");
		
		// Controller로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		// service내부의 institution의 정보를 호출하는 메서드를 호출하자.
		Institution institution = piGetInstitutionName(institutionCode);
		
		// 단위테스트를 위해 list객체참조변수 내부에 mapper에서 호출한 메서드를 담기
		List<NoticeLecture> list = piLectureMapper.piSelectNoticeLectureList(institutionCode);
		System.out.println("[PILectureService piGetNoticeLectureList] list: "+list);
		
		// 값이 담긴 list, instituiton 객체참조변수를 map 내부에 담아 controller에서 사용하자. 
		map.put("list", list);
		map.put("institution", institution);		
		return map;
	}
	// 1-2. 강의공고세부조회에서 수강신청
	public Map<String, Object> piSelectNoticeLectureDetailByNoticeLectureCode(String institutionCode, String noticeLectureCode) {
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode]");
		
		// Controller로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		// service내부의 institution의 정보를 호출하는 메서드를 호출하자.
		Institution institution = piGetInstitutionName(institutionCode);
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = piLectureMapper.piSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		// 값이 담긴 noticeLecture, instituiton 객체참조변수를 map 내부에 담아 controller에서 사용하자. 
		map.put("noticeLecture", noticeLecture);
		map.put("institution", institution);		
		return map;
	}
	// 2. lectureSignup 화면을 위한 준비
	public Map<String, Object> piGetNoticeLectureInfoForLectureSignup(String institutionCode, String noticeLectureCode, String memberCode){
		System.out.println("[PILectureService piGetNoticeLectureInfoForLectureSignup]");
		
		// Controller로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		// service내부의 institution의 정보를 호출하는 메서드를 호출하자.
		Institution institution = piGetInstitutionName(institutionCode);
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = piLectureMapper.piSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[PILectureService piSelectNoticeLectureDetailByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		// 화면에 회원정보를 뿌려주기 위해 service내부의 메서드 호출
		Member member = piGetMemberInfo(memberCode);
		
		// 값이 담긴 noticeLecture, instituiton 객체참조변수를 map 내부에 담아 controller에서 사용하자. 
		map.put("noticeLecture", noticeLecture);
		map.put("institution", institution);		
		map.put("member", member);		
		return map;
	}
	// 3. 수강신청 중복조회를 위한 메서드
	public boolean piLectureSignupCheck(String noticeLectureCode, String memberRegistrationNumberFront) {
		System.out.println("[PILectureService piLectureSignupCheck]");
		System.out.println("[PILectureService piLectureSignupCheck] noticeLectureCode: "+noticeLectureCode);
		System.out.println("[PILectureService piLectureSignupCheck] memberRegistrationNumberFront: "+memberRegistrationNumberFront);
		
		boolean lectureSignupCheck = false;
		
		// mapper로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeLectureCode", noticeLectureCode);
		map.put("memberRegistrationNumberFront", memberRegistrationNumberFront);
		LectureSignup lectureSignup = piLectureMapper.piLectureSignupCheck(map);
		
		if(lectureSignup == null) {
			System.out.println("Service ■■oo수강신청 등록 가능oo■■");
		} else {
			lectureSignupCheck = true;
			System.out.println("Service ■■xx수강신청 등록 불가xx■■");
		}
		return lectureSignupCheck;
	}
	
	// 4. 수강신청 등록  메서드
	public Map<String, Object> piAddLectureSignup(String institutionCode, String noticeLectureCode, LectureSignup lectureSignup) {
		System.out.println("[PILectureService piAddLectureSignup]");
		
		// 1. lectureSignup 테이블에 추가할 PK 구하는 코드 
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
		System.out.println("[InstitutionClassroomService institutionAddClassroom] lectureSignup: "+lectureSignup);
		// 2. lectureSignup 테이블에 수강신청내역 등록하기		
		piLectureMapper.piInsertLectureSignup(lectureSignup);
		
		// 3. 수강신청 이후 notice_lecture의 컬럼을 업데이트
		// 3-1. select
		int noticeLectureCurrentApplicantNo = piLectureMapper.piSelectNoticeLectureCurrentApplicantNoByNoticeLectureCode(noticeLectureCode);
		System.out.println("noticeLectureCurrentApplicantNo : "+noticeLectureCurrentApplicantNo);
			//골라 온 notice_lecture_current_applicant_no값에 1을 추가하여 map내부에 담은 뒤 update쿼리를 실행하자
			int updateApplicantNo = noticeLectureCurrentApplicantNo+1;
			System.out.println("증가된 noticeLectureCurrentApplicantNo : "+updateApplicantNo);
		// 3-2. update
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("updateApplicantNo", updateApplicantNo);
		map.put("noticeLectureCode", noticeLectureCode);
		piLectureMapper.piUpdateNoticeLectureCurrentApplicationNoWithNoticeLectureCode(map);
		
		// 3. redirect 이후 화면에 교육원 정보 출력해주기 위한 메서드 호출
		// Controller로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// service내부의 institution의 정보를 호출하는 메서드를 호출하자.
		Institution institution = piGetInstitutionName(institutionCode);
		returnMap.put("institution", institution);		
		return returnMap;
	}
	
	// 수강신청 내역 목록 조회
	public List<LectureSignup> piGetLectureSignupListByMemberCode(String memberCode){
		System.out.println("[PILectureService piGetLectureSignupListByMemberCode] memberCode: "+memberCode);
		
		// mapper에서 불러온 수강신청내역 리스트를 list객체참조변수내에 담아서 controller로 리턴보내기
		List<LectureSignup> list = piLectureMapper.piSelectLectureSignupListByMemberCode(memberCode);
		System.out.println("[PILectureService piGetLectureSignupListByMemberCode] list: "+list);
		return list;
	}	
	// 해당 수강신청 내역 상세 조회
	public LectureSignupResult piGetLectureSignupResultByLectureSignupCode(String lectureSignupCode){
		System.out.println("[PILectureService piGetLectureSignupResultByLectureSignupCode] lectureSignupCode: "+lectureSignupCode);
		
		// mapper에서 불러온 해당 내역을 lectureSignup 객체참조변수내에 담아서 controller로 리턴보내기
		LectureSignupResult result = piLectureMapper.piSelectLectureSignupResultBylectureSignupCode(lectureSignupCode);
		System.out.println("[PILectureService piGetLectureSignupResultByLectureSignupCode] result: "+result);
		return result;
	}
	
	// 3. 중복결제 검사를 위한 메서드
	public boolean piPaymentLectureCheck(String noticeLectureCode, String memberCode) {
		System.out.println("[PILectureService piLectureSignupCheck]");
		System.out.println("[PILectureService piLectureSignupCheck] noticeLectureCode: "+noticeLectureCode);
		System.out.println("[PILectureService piLectureSignupCheck] memberCode: "+memberCode);
		
		boolean paymentLectureCheck = false;
		
		// mapper로 리턴보내기 위한 map 객체잠조변수 선언
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeLectureCode", noticeLectureCode);
		map.put("memberCode", memberCode);
		PaymentLecture paymentLecture = piLectureMapper.piPaymentLectureCheck(map);
		
		if(paymentLecture == null) {
			System.out.println("Service ■■oo강의결제 등록 가능oo■■");
		} else {
			paymentLectureCheck = true;
			System.out.println("Service ■■xx강의결제 등록 불가xx■■");
		}
		return paymentLectureCheck;
	}
		
	// 해당 수강신청 내역 상세 조회
	public Map<String, Object> piAddPaymentLecture(String memberCode, String noticeLectureCode){
		System.out.println("[PILectureService piAddPaymentLecture] memberCode: "+memberCode);
		System.out.println("[PILectureService piAddPaymentLecture] noticeLectureCode: "+noticeLectureCode);
		
		// 입력받은 값들로 mapper의 메서드 호출하기 
		PaymentLecture member = piLectureMapper.piSelectMemberInfoByMemberCode(memberCode);
		PaymentLecture noticeLecture = piLectureMapper.piSelectNoticeLectureInfoByNoticeLectureCode(noticeLectureCode);
		System.out.println("[PILectureService piAddPaymentLecture] member: "+member);
		System.out.println("[PILectureService piAddPaymentLecture] noticeLecture: "+noticeLecture);
		
		// mapper에서 불러온 해당 내역을 Map 내부에 담아 Controller로 리턴한 뒤 사용하자.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", member);
		map.put("noticeLecture", noticeLecture);
		return map;
	}
	
	
}
