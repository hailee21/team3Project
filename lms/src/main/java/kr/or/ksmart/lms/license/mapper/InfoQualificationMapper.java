package kr.or.ksmart.lms.license.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.lms.license.vo.InfoQualification;

@Mapper
public interface InfoQualificationMapper {
	
	public List<InfoQualification> selectInfoQualification();
	
	
}
