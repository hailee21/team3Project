package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationNoticeLicenseTestMapper;
import kr.or.ksmart.lms.association.vo.NoticeLicenseTest;

@Service
@Transactional
public class AssociationNoticeLicenseTestService {
	
	@Autowired
	AssociationNoticeLicenseTestMapper associationNoticeLicenseTestMapper;
	//자격 시험 공고 리스트
	public List<NoticeLicenseTest> selectNoticeLicenseTest() {
		List<NoticeLicenseTest> list = associationNoticeLicenseTestMapper.selectNoticeLicenseTest();
		return list;
	}
}
