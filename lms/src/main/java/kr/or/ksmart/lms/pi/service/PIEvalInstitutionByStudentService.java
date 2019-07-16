package kr.or.ksmart.lms.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.mapper.PIInfoEvalInstitutionByStudentMapper;
import kr.or.ksmart.lms.pi.vo.InfoEvalInstitutionByStudent;

@Service
public class PIEvalInstitutionByStudentService {

	@Autowired
	PIInfoEvalInstitutionByStudentMapper infoEvalInstitutionByStudentMapper;

	
	public IndexInstitution PIIndex(String institutionCode) {
		return infoEvalInstitutionByStudentMapper.selectInstitution(institutionCode);
	}
	
	
	//기준년도에의한 교육원 평가 문제항목 select mapper 호출
	public List<InfoEvalInstitutionByStudent> getInfoEvalInstitutionBystudent(){
		List<InfoEvalInstitutionByStudent> list = infoEvalInstitutionByStudentMapper.selectInfoEvalInstitutionBystudent();
		System.out.println(list);
		return list;
	}
	
}
