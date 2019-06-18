package kr.or.ksmart.lms.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.lecture.mapper.InfoLectureMapper;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@Service
public class InfoLectureService {
	@Autowired InfoLectureMapper infoLectureMapper;
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public List<InfoLecture> getInfoLectureSortList() {
		System.out.println("[InfoLectureService getInfoLectureSortList]");
		return infoLectureMapper.selectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> getInfoLectureNameList(String lectureSort) {
		System.out.println("[InfoLectureService getInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = infoLectureMapper.selectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[InfoLectureService getInfoLectureNameList] infoLectureCode: "+nameList);
		
		return nameList;
	}
}
