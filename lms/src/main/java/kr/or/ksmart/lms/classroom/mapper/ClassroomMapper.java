package kr.or.ksmart.lms.classroom.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.classroom.vo.Classroom;

@Mapper
public interface ClassroomMapper {
	
	// 강의실 등록 메서드
	public int insertClassroom(Classroom classroom); 

}
