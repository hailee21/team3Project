package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.License;

@Mapper
public interface AssociationLicenseMapper {
	
	//자격증 발급 등록
	public void	insertLicense();
	//자격증 발급 리스트
	public List<License> selectLicense();
}
