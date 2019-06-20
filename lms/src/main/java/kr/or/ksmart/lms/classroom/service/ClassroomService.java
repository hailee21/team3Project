package kr.or.ksmart.lms.classroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.classroom.mapper.ClassroomMapper;
import kr.or.ksmart.lms.classroom.vo.Classroom;

@Service
public class ClassroomService {
	@Autowired ClassroomMapper classroomMapper;
	
	// 강의실 추가 메서드
	public int addClassroom(Classroom classroom) {
		System.out.println("[ClassroomService addClassroom]");
		return classroomMapper.insertClassroom(classroom);
	}

}
