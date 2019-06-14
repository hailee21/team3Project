package kr.or.ksmart.lms.Index.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.Index.VO.InfoSubject;

@Mapper
public interface IndexMapper {

	public List<InfoSubject> selectInfoSubjectList();
}
