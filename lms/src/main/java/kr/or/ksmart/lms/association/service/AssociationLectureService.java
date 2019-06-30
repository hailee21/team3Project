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
	public List<InfoLecture> associationGetInfoLectureList(){
		System.out.println("[AssociationLectureService getInfoLectureList]");

		// 단위테스트 준비
		List<InfoLecture> infoLectureList = associationLectureMapper.associatonSelectInfoLectureList();
		System.out.println("[AssociationLectureService associationGetInfoLectureList] infoLectureList : "+infoLectureList);
		return infoLectureList;
	}
	
	// detailInfoLecture 출력
	public InfoLecture associationGetDetailInfoLecture(String infoLectureCode) {
		System.out.println("[AssociationLectureService associationGetDetailInfoLecture]");
		System.out.println("[AssociationLectureService associationGetDetailInfoLecture] infoLectureCode :"+infoLectureCode);
		
		// 단위테스트 준비
		InfoLecture infoLecture = associationLectureMapper.associatonSelectDetailInfoLecture(infoLectureCode);
		return infoLecture;
	}
	
	// subject조회를 위한 준비
	// 1. select sort 
	public List<InfoLecture> associationGetInfoLectureSortList() {
		System.out.println("[associationLectureService associationGetInfoLectureSortList]");
		return associationLectureMapper.associationSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> associationGetInfoLectureNameList(String lectureSort) {
		System.out.println("[associationLectureService associationGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = associationLectureMapper.associationSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[associationLectureService associationGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> associationGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[associationLectureService associationGetSubjectListByLectureCode]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = associationLectureMapper.associationSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[associationLectureService associationGetSubjectListByLectureCode] infoSubjectCode: "+subjectList);
		return subjectList;
	}	
	
	// detailSubject를 위한 준비
	public InfoSubject associationGetDetailSubjectBySubjectCode(String infoSubjectCode) {
		System.out.println("[associationLectureService associationGetDetailSubjectBySubjectCode]");
		
		// mapper에서 가져온 값을 infoSubject의 객체참조변수에 담아서 controller로 리턴보낸다
		InfoSubject infoSubject = associationLectureMapper.associationSelectInfoSubjectBySubjectCode(infoSubjectCode);
		System.out.println("[associationLectureService associationGetDetailSubjectBySubjectCode]infoSubject :"+infoSubject);
		return infoSubject;
	}
	
}
