package kr.or.ksmart.lms.pa.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pa.vo.IndexInstitution;

@Mapper
public interface PAMemberMapper {
	//	institutionCode 받아오기
	public IndexInstitution selectInstitution(String institutionCode);
	
}
