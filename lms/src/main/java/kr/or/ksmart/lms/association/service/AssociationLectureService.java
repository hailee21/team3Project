package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationLectureMapper;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@Service
public class AssociationLectureService {
	@Autowired private AssociationLectureMapper associationLectureMapper;
	
	// infoLecture 리스트 출력
	public List<InfoLecture> getInfoLectureList(){
		System.out.println("[AssociationLectureService getInfoLectureList]");

		// 단위테스트 준비
		List<InfoLecture> infoLectureList = associationLectureMapper.associatonSelectInfoLectureList();
		System.out.println("[AssociationLectureService getInfoLectureList] infoLectureList : "+infoLectureList);
		return infoLectureList;
	}
	
	// detailInfoLecture 출력
	public InfoLecture getDetailInfoLecture(String infoLectureCode) {
		System.out.println("[AssociationLectureService getDetailInfoLecture]");
		System.out.println("[AssociationLectureService getDetailInfoLecture] infoLectureCode :"+infoLectureCode);
		
		// 단위테스트 준비
		InfoLecture infoLecture = associationLectureMapper.associatonSelectDetailInfoLecture(infoLectureCode);
		return infoLecture;
	}
	
	// subject조회를 위한 준비
	// 1. select sort 
	public List<InfoLecture> getInfoLectureSortList() {
		System.out.println("[LectureService getInfoLectureSortList]");
		return associationLectureMapper.associationSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> getInfoLectureNameList(String lectureSort) {
		System.out.println("[LectureService getInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = associationLectureMapper.associationSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService getInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> getSubjectListByLectureCode(String lectureCode){
		System.out.println("[LectureService getInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = associationLectureMapper.associationSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[LectureService getInfoLectureNameList] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
}
