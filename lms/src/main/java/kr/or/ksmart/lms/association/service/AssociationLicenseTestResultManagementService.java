package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationLicenseTestResultManagementMapper;
import kr.or.ksmart.lms.association.vo.LicenseTestResultManagement;

@Service
@Transactional
public class AssociationLicenseTestResultManagementService {
	
	@Autowired
	AssociationLicenseTestResultManagementMapper associationLicenseTestResultManagementMapper;
	// 자격증 시험 결과 관리 등록
	public void insertLicenseTestResultManagement(LicenseTestResultManagement licenseTestResultManagement) {
		associationLicenseTestResultManagementMapper.insertLicenseTestResultManagement(licenseTestResultManagement);
	}
	// 자격증시험결과관리 리스트
	public List<LicenseTestResultManagement> selectLicenseTestResultManagement() {
		List<LicenseTestResultManagement> list = associationLicenseTestResultManagementMapper.selectLicenseTestResultManagement();
		return list;
		
	}
}
