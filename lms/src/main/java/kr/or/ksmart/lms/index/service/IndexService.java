package kr.or.ksmart.lms.index.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.mapper.IndexMapper;
import kr.or.ksmart.lms.index.vo.IndexInstitution;

@Service
public class IndexService {
	@Autowired
	IndexMapper indexMapper;
	
	public IndexInstitution PIIndex(String institutionCode) {
		return indexMapper.selectInstitution(institutionCode);
	}
}
