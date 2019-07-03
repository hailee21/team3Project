package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.LicenseTestLocation;
import kr.or.ksmart.lms.association.vo.LicenseTestLocationDetail;

@Mapper
public interface AssociationLicenseTestLocationMapper {
	
	//자격시험 장소 상세 등록
	public void insertLicenseTestLocationDetail(LicenseTestLocationDetail licenseTestLocationDetail);
	//자격시험 장소 상세보기
	public List<LicenseTestLocationDetail> selectLicenseTestLocationDetail(String licenseTestLocationCode);
	//자격시험 장소 조회 매퍼
	public List<LicenseTestLocation> selectLicenseTestLocation(LicenseTestLocation licenseTestLocation);
	//자격시험 장소 PK 매퍼
	public String selectLicenseTestLocationPk();
	//자격시험 장소 등록 매퍼
    public void insertLicenseTestLocation(LicenseTestLocation licenseTestLocation);
    
}
