package kr.or.ksmart.lms.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.license.mapper.InfoQualificationMapper;
import kr.or.ksmart.lms.license.vo.InfoQualification;

@Service
public class InfoQualificationService {
	@Autowired
	InfoQualificationMapper infoQualificationMapper;
	public List<InfoQualification> getInfoQualification(){
		List<InfoQualification> list = infoQualificationMapper.selectInfoQualification();
		return list;
	}
}
