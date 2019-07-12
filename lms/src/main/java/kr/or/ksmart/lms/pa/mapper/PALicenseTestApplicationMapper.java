package kr.or.ksmart.lms.pa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pa.vo.LicenseTestApplication;

@Mapper
public interface PALicenseTestApplicationMapper {

	//자격 시험 신청 리스트
	public List<LicenseTestApplication> selectLicenseTestApplication();
}
