package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationInfoEvalMapper;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InfoEvalByInstitution;
import kr.or.ksmart.lms.association.vo.InfoEvalInstitutionByStudent;
import kr.or.ksmart.lms.association.vo.InfoEvalLectureByStudent;

@Service
public class AssociationInfoEvalService {
	@Autowired private AssociationInfoEvalMapper associationInfoEvalMapper;
	
	//	교육원평가 항목(문항)리스트 출력
	public List<InfoEvalByAssociation> getInfoEvalByAssociationList() {
		List<InfoEvalByAssociation> evalByAssociationSort = associationInfoEvalMapper.selectInfoEvalByAssociationList();
		return evalByAssociationSort;
	}
	//	교육원 평가항목 추가
	public void insertInfoEvalByAssociation(InfoEvalByAssociation eval) {
		//	info_eval_by_association 테이블에 insert 준비-> code 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String infoEvalByAssociationCode="IEIA"+nowDate+randomNo;
		eval.setInfoEvalByAssociationCode(infoEvalByAssociationCode);	//생성된 코드를 infoEvalByAssociation VO 내setting한다.
		//	info_eval_by_association 테이블에 insert
		associationInfoEvalMapper.insertInfoEvalByAssociation(eval);
	}
	
	//	교육원-강사 평가항목(문항)리스트 출력
	public List<InfoEvalByInstitution> getInfoEvalByInstitutionList() {
		List<InfoEvalByInstitution> evalByInstitutionSort = associationInfoEvalMapper.selectInfoEvalByInstitutionList();
		return evalByInstitutionSort;
	}
	//	교육원-강사 평가항목 추가
	public void insertInfoEvalByInstitution (InfoEvalByInstitution eval) {
		//	info_eval_by_institution 테이블에 insert 준비-> code 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String infoEvalByInstitutionCode="IEI"+nowDate+randomNo;
		eval.setInfoEvalByInstitutionCode(infoEvalByInstitutionCode);
		//	info_eval_by_institution 테이블에 insert
		associationInfoEvalMapper.insertInfoEvalByInstitution(eval);
	}
	
	//	수강생-교육원 평가항목(문항)리스트 출력
	public List<InfoEvalInstitutionByStudent> getInfoEvalInstitutionByStudent() {
		List<InfoEvalInstitutionByStudent> evalInstitutionByStudentSort = associationInfoEvalMapper.selectInfoEvalInstitutionByStudentList();
		return evalInstitutionByStudentSort;
	}
	//	수강생-교육원 평가항목 추가
	public void insertInfoEvalInstitutionByStudent(InfoEvalInstitutionByStudent eval) {
		//	info_eval_institution_by_student 테이블에 insert 준비 -> code생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String infoEvalInstitutionByStudentCode="IEIS"+nowDate+randomNo;
		eval.setInfoEvalInstitutionByStudentCode(infoEvalInstitutionByStudentCode);
		//	info_eval_institution_by_student 테이블에 insert
		associationInfoEvalMapper.insertInfoEvalInstitutionByStudent(eval);
	}
	
	//	수강생-강의/강사 평가항목(문항)리스트 출력
	public List<InfoEvalLectureByStudent> getInfoEvalLectureByStudent() {
		List<InfoEvalLectureByStudent> evalLectureByStudentSort = associationInfoEvalMapper.selectInfoEvalLectureByStudentList();
		return evalLectureByStudentSort;
	}
	public void insertInfoEvalLectureByStudent(InfoEvalLectureByStudent eval) {
		//	info_eval_lecture_by_student 테이블에 insert 준비 -> code 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String infoEvalLectureByStudentCode="IEIS"+nowDate+randomNo;
		eval.setInfoEvalLectureByStudentCode(infoEvalLectureByStudentCode);
		//	info_eval_lecture_by_student 테이블에 insert
		associationInfoEvalMapper.insertInfoEvalLectureByStudent(eval);
	}
}
