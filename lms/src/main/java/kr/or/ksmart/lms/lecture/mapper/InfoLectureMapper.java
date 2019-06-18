package kr.or.ksmart.lms.lecture.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@Mapper
public interface InfoLectureMapper {
	
	// infoLecture 리스트 출력하는 메서드
	public List<InfoLecture> selectInfoLectureSortList();

}
