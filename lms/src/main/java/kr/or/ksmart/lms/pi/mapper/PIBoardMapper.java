package kr.or.ksmart.lms.pi.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;

@Mapper
public interface PIBoardMapper {
	public IndexInstitution selectInstitution(String institutionCode);
}
