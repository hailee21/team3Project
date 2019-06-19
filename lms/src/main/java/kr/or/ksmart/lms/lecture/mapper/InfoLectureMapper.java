package kr.or.ksmart.lms.lecture.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Mapper
public interface InfoLectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> selectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > selectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> selectSubjectListByLectureCode(String lectureCode);
}
