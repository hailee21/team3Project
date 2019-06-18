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
	public List<InfoLecture> selectInfoLectureList() {
		System.out.println("[InfoLectureService selectInfoLectureList]");
		
		return infoLectureMapper.selectInfoLectureSortList();		
	}
}
