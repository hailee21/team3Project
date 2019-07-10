package kr.or.ksmart.lms.pi.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.*;
import kr.or.ksmart.lms.pi.vo.*;

@Mapper
public interface PIInfoEvalInstitutionByStudentMapper {
			
	//기준년도에의한 교육원 평가 문제항목
	public List<InfoEvalInstitutionByStudent> selectInfoEvalInstitutionBystudent();
	
	
}
