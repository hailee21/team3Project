package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.LicenseTestResultManagement;

@Mapper
public interface AssociationLicenseTestResultManagementMapper {
	// 자격증 시험 결과 관리 등록
	public void insertLicenseTestResultManagement(LicenseTestResultManagement licenseTestResultManagement);
	// 자격증시험결과관리 리스트
	public List<LicenseTestResultManagement> selectLicenseTestResultManagement();
}
