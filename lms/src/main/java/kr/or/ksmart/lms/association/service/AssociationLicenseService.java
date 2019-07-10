package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationLicenseMapper;
import kr.or.ksmart.lms.association.vo.License;

@Service
@Transactional
public class AssociationLicenseService {
	@Autowired
	AssociationLicenseMapper associationLicenseMapper;
	
	//자격증 발급 등록
	public void	insertLicense() {
		associationLicenseMapper.insertLicense();
	}
	
	//자격증 발급 리스트
	public List<License> selectLicense() {
		List<License> list = associationLicenseMapper.selectLicense();
		return list;
	}
}
