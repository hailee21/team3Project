package kr.or.ksmart.lms.subject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.subject.vo.InfoSubject;
@Mapper
public interface SubjectMapper {
	public List<InfoSubject> subjectList ();
}