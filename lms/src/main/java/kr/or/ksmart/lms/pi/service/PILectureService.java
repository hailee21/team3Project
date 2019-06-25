package kr.or.ksmart.lms.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@Service
public class PILectureService {
	@Autowired private PILectureMapper piLectureMapper;
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public List<InfoLecture> piGetInfoLectureSortList() {
		System.out.println("[LectureService piGetInfoLectureSortList]");
		return piLectureMapper.piSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> piGetInfoLectureNameList(String lectureSort) {
		System.out.println("[LectureService piGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = piLectureMapper.piSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService piGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> piGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[LectureService piGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = piLectureMapper.piSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService piGetInfoLectureNameList] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
}
