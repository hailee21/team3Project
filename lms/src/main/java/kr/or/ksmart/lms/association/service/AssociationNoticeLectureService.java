package kr.or.ksmart.lms.association.service;

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
	// 강의등록을 위한 리스트들 출력하기 
	public Map<String, Object> associationReadyForAddNoticeLecture(){
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]");
		
		// mapper에서 호출해온 각 리스트들을 map에 담아서 controller에서 ModelAndView에 담아 뷰에서 활용하자
		List<InfoLecture> infoLectureSort = associationNoticeLectureMapper.associationSelectInfoLectureSortForNL();
		List<MemberTeacher> memberTeacher = associationNoticeLectureMapper.associationSelectMemberTeacherForNL();
		List<Institution> institution = associationNoticeLectureMapper.associationSelectInstitutionForNL();
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]infoLecture: "+ infoLectureSort);
		System.out.println((infoLectureSort.size()));
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
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]");
		
		// mapper에서 호출해온 각 리스트들을 리스트에 담아서 RestController에서 비동기방식 ajax를 사용하여 뷰에서 활용하자
		List<InfoLecture> infoLectureName = associationNoticeLectureMapper.associationSelectInfoLectureNameForNL(infoLectureSort);
		System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture] 비동기 infoLecture2: "+ infoLectureName);
				
		return infoLectureName;
	}
	// 비동기 - 강의실 리스트들 출력하기
		public List<Classroom> associationReadyForRestAddNoticeLecture2(String institutionCode){
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]");
			
			// mapper에서 호출해온 각 리스트들을 리스트에 담아서 RestController에서 비동기방식 ajax를 사용하여 뷰에서 활용하자
			List<Classroom> classroom = associationNoticeLectureMapper.associationSelectClassroomForNL(institutionCode);
			System.out.println("[AssociationNoticeLectureService associationAddNoticeLecture]비동기 classroom: "+ classroom);
			
			return classroom;
		}
	
	// AddNoticeLecture PK지정하기, 시분초 조합하기
	
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
