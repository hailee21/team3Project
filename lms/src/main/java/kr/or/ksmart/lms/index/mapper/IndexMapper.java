package kr.or.ksmart.lms.index.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.InfoSubject;

@Mapper
public interface IndexMapper {
	public List<InfoSubject> selectInfoSubjectList(); 
}
