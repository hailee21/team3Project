package kr.or.ksmart.lms.license.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.license.vo.LicenseTestLocation;

@Mapper
public interface LicenseTestLocationMapper {
	
	//자격시험 장소 조회 매퍼
	public List<LicenseTestLocation> selectLicenseTestLocation(LicenseTestLocation licenseTestLocation);
	
	//자격시험 장소 PK 매퍼
	public String selectLicenseTestLocationPk();
	
	//자격시험 장소 등록 매퍼
    public void insertLicenseTestLocation(LicenseTestLocation licenseTestLocation);
    
}
