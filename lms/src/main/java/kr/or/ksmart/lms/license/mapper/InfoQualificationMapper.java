package kr.or.ksmart.lms.license.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.license.vo.InfoQualification;

@Mapper
public interface InfoQualificationMapper {
	
	public InfoQualification selectInfoQualification(InfoQualification infoQualification);
	
	
}
