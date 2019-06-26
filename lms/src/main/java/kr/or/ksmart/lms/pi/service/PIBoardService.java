package kr.or.ksmart.lms.pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.mapper.PIBoardMapper;

@Service
public class PIBoardService {
	@Autowired private PIBoardMapper piBoardMapper;
	public IndexInstitution PIIndex(String institutionCode) {
		return piBoardMapper.selectInstitution(institutionCode);
	}
}
