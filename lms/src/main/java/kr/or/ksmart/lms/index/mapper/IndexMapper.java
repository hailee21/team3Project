package kr.or.ksmart.lms.index.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;

@Mapper
public interface IndexMapper {
	public IndexInstitution selectInstitution(String institutionCode); 
}
