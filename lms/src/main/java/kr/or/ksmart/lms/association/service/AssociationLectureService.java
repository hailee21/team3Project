package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationLectureMapper;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@Service
public class AssociationLectureService {
	@Autowired private AssociationLectureMapper associationLectureMapper;
	
	// infoLecture 등록
	public void associationAddInfoLecture(InfoLecture infoLecture) {
		System.out.println("[AssociationLectureService associationGetDetailInfoLecture]");
		
		// 1. infoLecture 테이블에 추가할 PK 구하는 코드 
		// 1-1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println("nowDate2: "+nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		// 1-2. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String ILPK = "IL"+nowDate+randomNo;
		infoLecture.setInfoLectureCode(ILPK);
		System.out.println("[AssociationLectureService associationAddInfoSubject] 최종 ILPK: "+ILPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		associationLectureMapper.associationInsertInfoLecture(infoLecture);
	}
	
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
	
	// infoSubject에 등록하기위한 준비
	public void associationAddInfoSubject(InfoSubject infoSubject) {
		System.out.println("[AssociationLectureService associationGetDetailInfoLecture]");
		
		// 1. infoSubject 테이블에 추가할 PK 구하는 코드 
		// 1-1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println("nowDate2: "+nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		// 1-2. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String ISPK = "IS"+nowDate+randomNo;
		infoSubject.setInfoSubjectCode(ISPK);
		System.out.println("[AssociationLectureService associationAddInfoSubject] 최종 ISPK: "+ISPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		associationLectureMapper.associationInsertInfoSubject(infoSubject);
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
