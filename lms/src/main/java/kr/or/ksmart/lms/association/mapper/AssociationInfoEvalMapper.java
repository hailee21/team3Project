package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InfoEvalByInstitution;
import kr.or.ksmart.lms.association.vo.InfoEvalInstitutionByStudent;
import kr.or.ksmart.lms.association.vo.InfoEvalLectureByStudent;

@Mapper
public interface AssociationInfoEvalMapper {
	//	협회가 교육원을 평가하는 평가문항 리스트
	public List<InfoEvalByAssociation> selectInfoEvalByAssociationList();
	//	협회가 교육원을 평가하는 평가문항 추가
	public void insertInfoEvalByAssociation(InfoEvalByAssociation infoEvalByAssociation);
	//	교육원이 강사를 평가하는 평가문항 리스트
	public List<InfoEvalByInstitution> selectInfoEvalByInstitutionList();
	//	교육원이 강사를 평가하는 평가문항 추가
	public void insertInfoEvalByInstitution(InfoEvalByInstitution infoEvalByInstitution);
	//	학생이 교육원을 평가하는 평가문항 리스트
	public List<InfoEvalInstitutionByStudent> selectInfoEvalInstitutionByStudentList();
	//	학생이 교육원을 평가하는 평가문항 추가
	public void insertInfoEvalInstitutionByStudent(InfoEvalInstitutionByStudent infoEvalInstitutionByStudent);
	//	학생이 강사/강의 평가하는 평가문항 리스트
	public List<InfoEvalLectureByStudent> selectInfoEvalLectureByStudentList();
	//	학새이 강사/강의 평가하는 평가문항 추가
	public void insertInfoEvalLectureByStudent(InfoEvalLectureByStudent infoEvalLectureByStudent);
}
