package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.institution.mapper.InstitutionLectureMapper;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;
import kr.or.ksmart.lms.institution.vo.Lecture;

@Service
public class InstitutionLectureService {
	
	@Autowired private InstitutionLectureMapper institutionLectureMapper;
	
	// infoLecture 리스트 조회 메서드
	// 1. select sort 
	public List<InfoLecture> institutionGetInfoLectureSortList() {
		System.out.println("[InstitutionLectureService institutionGetInfoLectureSortList]");
		return institutionLectureMapper.institutionSelectInfoLectureSortList();		 	
	}
	// 2. 비동기 처리를 위한 select name, code
	public List<InfoLecture> institutionGetInfoLectureNameList(String lectureSort) {
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoLecture> nameList = institutionLectureMapper.institutionSelectInfoLectureNameList(lectureSort);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList] infoLectureCode: "+nameList);
		return nameList;
	}
	// 3. lectureCode를 받아 select subject
	public List<InfoSubject> institutionGetSubjectListByLectureCode(String lectureCode){
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList]");
		// 단위테스트 준비
		List<InfoSubject> subjectList = institutionLectureMapper.institutionSelectSubjectListByLectureCode(lectureCode);
		// infoLectureMapper 에서 받아온 code, name 출력
		System.out.println("[InstitutionLectureService institutionGetInfoLectureNameList] subjectList: "+subjectList);
		return subjectList;
	}	
	
	// detailSubject 조회 메서드
	public InfoSubject institutionGetDetailSubjectByInfoSubjectCode(String infoSubjectCode) {
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]");
		
		// mapper에서 받은 detailSubject값을 infoSubject객체참조변수 내부에 담아서 controller에서 사용하기 
		InfoSubject infoSubject = institutionLectureMapper.institutionSelectDetailSubjectByInfoSubjectCode(infoSubjectCode);
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]infoSubject: "+infoSubject);		
		return infoSubject;
	}
	
	// lecture리스트 조회 메서드
	public List<Lecture> institutionGetLectureListByInstitutionCode(String institutionCode){
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode]");
		
		// mapper에서 받은 list처리된 Lecture들을 list객체참조변수 내부에담아서 controller에서 사용하기
		List<Lecture> list = institutionLectureMapper.institutionSelectLectureListByInstitutionCode(institutionCode);
		System.out.println("[InstitutionLectureService institutionGetDetailSubjectByInfoSubjectCode] list: "+list);
		return list;
	}
	// detailLecture 조회 메서드
	public Lecture institutionGetDetailLectureByLectureCode(String lectureCode) {
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode]");
		
		// mapper에서 받은 detailLecture를 lecture객체참조변수 내부에담아서 controller에서 사용하기
		Lecture lecture = institutionLectureMapper.institutionSelectDetailLectureByLectureCode(lectureCode);
		System.out.println("[InstitutionLectureService institutionGetDetailLectureByLectureCode] lecture: "+lecture);
		return lecture;
	}
}
