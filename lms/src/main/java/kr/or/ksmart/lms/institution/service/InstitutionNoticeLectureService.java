package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionNoticeLectureMapper;
import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.MemberTeacher;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Service
public class InstitutionNoticeLectureService {
	
	@Autowired private InstitutionNoticeLectureMapper institutionNoticeLectureMapper;
	// 강의등록 
		// 1. 강의등록을 위한 리스트들 출력하기 
		public Map<String, Object> institutionReadyForAddNoticeLecture(){
			System.out.println("[InstitutionNoticeLectureService institutionReadyForAddNoticeLecture]");
			
			// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
			List<InfoLecture> infoLectureSort = institutionNoticeLectureMapper.institutionSelectInfoLectureSortForNL();
			List<MemberTeacher> memberTeacher = institutionNoticeLectureMapper.institutionSelectMemberTeacherForNL();
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture]infoLecture: "+ infoLectureSort);
			System.out.println("[institutionNoticeLectureService] infoLectureSort 사이즈: "+ (infoLectureSort.size()));
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture]memberTeacher: "+ memberTeacher);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("infoLectureSort", infoLectureSort);
			map.put("memberTeacher", memberTeacher);
			
			return map;
		}
		// 비동기 - 강의표준명 리스트들 출력하기
		public List<InfoLecture> institutionReadyForRestAddNoticeLecture1(String infoLectureSort){
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture1]");
			
			// mapper에서 호출해온 각 리스트들을 리스트에 담아서 RestController에서 비동기방식 ajax를 사용하여 뷰에서 활용하자
			List<InfoLecture> infoLectureName = institutionNoticeLectureMapper.institutionSelectInfoLectureNameForNL(infoLectureSort);
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture] 비동기 infoLecture2: "+ infoLectureName);
					
			return infoLectureName;
		}
		// 동기 - 강의실 리스트들 출력하기
		public List<Classroom> institutionGetClassroomListByInstitutionCode(String institutionCode){
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture2]");
			
			// mapper에서 호출해온 해당 교육원의 강의실리스트들을 리스트에 담아서 Controller에 보내 뷰에서 활용하자
			List<Classroom> classroom = institutionNoticeLectureMapper.institutionSelectClassroomByInstitutionCode(institutionCode);
			System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture] 동기 classroom: "+ classroom);
			
			return classroom;
		}
	
	// 2. AddNoticeLecture PK지정하기, 시분초 조합하기
	public void institutionAddNoticeLecture(NoticeLecture noticeLecture) {
		System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture]");
		
		// 1. noticeLecture 테이블에 추가할 PK 구하는 코드 
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
		String NLPK = "NL"+nowDate+randomNo;
		noticeLecture.setNoticeLectureCode(NLPK);
		System.out.println("[institutionNoticeLectureService institutionAddNoticeLecture] 최종 NLPK: "+NLPK);
		
		// 2. noticeLecture 테이블에 강의공고 등록하기		
		institutionNoticeLectureMapper.institutionInsertNoticeLecture(noticeLecture);
	}
	
	
	// 강의공고 리스트 출력
	public Map<String, Object> institutionGetNoticeLectureList(){
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureList]");
		
		// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
		List<NoticeLecture> noticeLecturelist = institutionNoticeLectureMapper.institutionSelectNoticeLectureList();
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureList] noticeLecturelist: "+noticeLecturelist);
		
		List<NoticeLecture> failWaitingList = institutionNoticeLectureMapper.institutionSelectNoticeLectureFailWaitingList();
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureList] failWaitingList: "+failWaitingList);
		
		List<LectureFail> failLectureList = institutionNoticeLectureMapper.institutionSelectLectureFailList();
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureList] failLectureList: "+failLectureList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeLecturelist", noticeLecturelist);
		map.put("failWaitingList", failWaitingList);
		map.put("failLectureList", failLectureList);
		return map;
	}
	
	// 세부 강의공고 출력
	public NoticeLecture institutionGetNoticeLectureByNoticeLectureCode(String noticeLectureCode) {
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureByNoticeLectureCode]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = institutionNoticeLectureMapper.institutionSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[institutionNoticeLectureService institutionGetNoticeLectureByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		return noticeLecture;
	}

}
