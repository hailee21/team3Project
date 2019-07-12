package kr.or.ksmart.lms.pa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.pa.mapper.PALicenseTestApplicationMapper;
import kr.or.ksmart.lms.pa.vo.LicenseTestApplication;

@Service
@Transactional
public class PALicenseTestApplicationService {
	
	@Autowired
	PALicenseTestApplicationMapper pALicenseTestApplicationMapper;
	
	//자격 시험 신청 리스트
	 public List<LicenseTestApplication> selectLicenseTestApplication() {
		 List<LicenseTestApplication> list = pALicenseTestApplicationMapper.selectLicenseTestApplication();
		return list;
		 
	 }
}
