package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;

@Mapper
public interface InstitutionLectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> institutionSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > institutionSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> institutionSelectSubjectListByLectureCode(String lectureCode);
	
	// institution 리스트 출력하는 메서드
	public List<Institution> institutionSelectInstitutionList();
	// institution 키워드로 검색하는 메서드
	public List<Institution> institutionSelectInstitutionListByKeyword(String institutionName);
}
