package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.Institution;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@Mapper
public interface PILectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> piSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > piSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> piSelectSubjectListByLectureCode(String lectureCode);
	
	// institution 리스트 출력하는 메서드
	public List<Institution> piSelectInstitutionList();
	// institution 키워드로 검색하는 메서드
	public List<Institution> piSelectInstitutionListByKeyword(String institutionName);
	
	public Institution piSelectInstitution(String institutionCode); 
}
