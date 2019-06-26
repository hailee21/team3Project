package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.NoticeAnnualLicenseTest;

@Mapper
public interface AssocitationNoticeAnnualLicenseTestMapper {
	//연간 자격 시험 일정 등록
	public void insertNoticeAnnualLicenseTest(NoticeAnnualLicenseTest noticeAnnualLicenseTest);
	//연간 자격 시험 일정 List
	public List<NoticeAnnualLicenseTest> selectNoticeAnnualLicenseTest();
}
