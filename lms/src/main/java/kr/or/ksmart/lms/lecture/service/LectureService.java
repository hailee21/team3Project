package kr.or.ksmart.lms.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.lecture.mapper.LectureMapper;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Service
public class LectureService {
	@Autowired LectureMapper lectureMapper;
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public List<InfoLecture> getInfoLectureSortList() {
		System.out.println("[LectureService getInfoLectureSortList]");
		return lectureMapper.selectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> getInfoLectureNameList(String lectureSort) {
		System.out.println("[LectureService getInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = lectureMapper.selectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService getInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> getSubjectListByLectureCode(String lectureCode){
		System.out.println("[LectureService getInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = lectureMapper.selectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService getInfoLectureNameList] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
}
