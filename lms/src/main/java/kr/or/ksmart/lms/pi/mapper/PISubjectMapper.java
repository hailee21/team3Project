package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.InfoSubject;
@Mapper
public interface PISubjectMapper {
	public List<InfoSubject> piSubjectList ();
}