package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.NoticeLicenseTest;

@Mapper
public interface AssociationNoticeLicenseTestMapper {
	//자격 시험 공고 등록
	public List<String> insertNoticeLicenseTest(NoticeLicenseTest noticeLicenseTest);
	//자격 시험 공고 리스트
	public List<NoticeLicenseTest> selectNoticeLicenseTest();
	
}
