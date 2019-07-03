package kr.or.ksmart.lms.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;
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
	public List<NoticeLecture> piGetNoticeLectureList(){
		System.out.println("[PILectureService piGetNoticeLectureList]");
		
		// 단위테스트를 위해 list객체참조변수 내부에 mapper에서 호출한 메서드를 담아서 리턴보내기
		List<NoticeLecture> list = piLectureMapper.piSelectNoticeLectureList();
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
}
