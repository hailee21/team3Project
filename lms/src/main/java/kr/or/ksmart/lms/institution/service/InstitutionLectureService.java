package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionLectureMapper;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;

@Service
public class InstitutionLectureService {
	@Autowired private InstitutionLectureMapper institutionLectureMapper;
	
	// infoLecture 리스트 출력
	// 1. select sort 
	public List<InfoLecture> institutionGetInfoLectureSortList() {
		System.out.println("[LectureService institutionGetInfoLectureSortList]");
		return institutionLectureMapper.institutionSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> institutionGetInfoLectureNameList(String lectureSort) {
		System.out.println("[LectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = institutionLectureMapper.institutionSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService institutionGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> institutionGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[LectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = institutionLectureMapper.institutionSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService institutionGetInfoLectureNameList] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
}
