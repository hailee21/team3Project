package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationNoticeLectureMapper;
import kr.or.ksmart.lms.association.vo.Classroom;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.Institution;
import kr.or.ksmart.lms.association.vo.MemberTeacher;
import kr.or.ksmart.lms.association.vo.NoticeLecture;

@Service
public class AssociationNoticeLectureService {
	
	@Autowired private AssociationNoticeLectureMapper associationNoticeLectureMapper;
	// 강의등록 
		// 1. 강의등록을 위한 리스트들 출력하기 
		public Map<String, Object> associationReadyForAddNoticeLecture(){
			System.out.println("[AssociationNoticeLectureService associationReadyForAddNoticeLecture]");
			
			// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
			List<InfoLecture> infoLectureSort = associationNoticeLectureMapper.associationSelectInfoLectureSortForNL();
			List<MemberTeacher> memberTeacher = associationNoticeLectureMapper.associationSelectMemberTeacherForNL();
			List<Institution> institution = associationNoticeLectureMapper.associationSelectInstitutionForNL();
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]infoLecture: "+ infoLectureSort);
			System.out.println("[AssociationNoticeLectureService] infoLectureSort 사이즈: "+ (infoLectureSort.size()));
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]memberTeacher: "+ memberTeacher);
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]institution: "+ institution);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("infoLectureSort", infoLectureSort);
			map.put("memberTeacher", memberTeacher);
			map.put("institution", institution);
			
			return map;
		}
		// 비동기 - 강의표준명 리스트들 출력하기
		public List<InfoLecture> associationReadyForRestAddNoticeLecture1(String infoLectureSort){
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture1]");
			
			// mapper에서 호출해온 각 리스트들을 리스트에 담아서 RestController에서 비동기방식 ajax를 사용하여 뷰에서 활용하자
			List<InfoLecture> infoLectureName = associationNoticeLectureMapper.associationSelectInfoLectureNameForNL(infoLectureSort);
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture] 비동기 infoLecture2: "+ infoLectureName);
					
			return infoLectureName;
		}
		// 비동기 - 강의실 리스트들 출력하기
			public List<Classroom> associationReadyForRestAddNoticeLecture2(String institutionCode){
				System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture2]");
				
				// mapper에서 호출해온 각 리스트들을 리스트에 담아서 RestController에서 비동기방식 ajax를 사용하여 뷰에서 활용하자
				List<Classroom> classroom = associationNoticeLectureMapper.associationSelectClassroomForNL(institutionCode);
				System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]비동기 classroom: "+ classroom);
				
				return classroom;
			}
	
	// 2. AddNoticeLecture PK지정하기, 시분초 조합하기
	public void associationAddNoticeLecture(NoticeLecture noticeLecture) {
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]");
		
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
		String NLPK = "NL"+nowDate+randomNo;
		noticeLecture.setNoticeLectureCode(NLPK);
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture] 최종 NLPK: "+NLPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		associationNoticeLectureMapper.associationInsertNoticeLecture(noticeLecture);
	}
	
	
	// 강의공고 리스트 출력
	public List<NoticeLecture> associationGetNoticeLectureList(){
		System.out.println("[AssociationNoticeLectureService associationGetNoticeLectureList]");
		
		// 단위테스트를 위해 list객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		List<NoticeLecture> list = associationNoticeLectureMapper.associationSelectNoticeLectureList();
		System.out.println("[AssociationNoticeLectureService associationGetNoticeLectureList] list: "+list);
		
		return list;
	}
	// 세부 강의공고 출력
	public NoticeLecture associationGetNoticeLectureByNoticeLectureCode(String noticeLectureCode) {
		System.out.println("[AssociationNoticeLectureService associationGetNoticeLectureByNoticeLectureCode]");
		
		// 단위테스트를 위해 noticeLecture 객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		NoticeLecture noticeLecture = associationNoticeLectureMapper.associationSelectNoticeLectureByNoticeLectureCode(noticeLectureCode);
		System.out.println("[AssociationNoticeLectureService associationGetNoticeLectureByNoticeLectureCode] noticeLecture: "+noticeLecture);
		
		return noticeLecture;
	}

}
