package kr.or.ksmart.lms.pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.pa.mapper.PAMemberMapper;
import kr.or.ksmart.lms.pa.vo.IndexInstitution;

@Service
@Transactional
public class PAMemberService {
	@Autowired private PAMemberMapper paMemberMapper;
	
	public IndexInstitution PAIndex() {
		String institutionCode = "I20120101000000";
		return paMemberMapper.selectInstitution(institutionCode);
	}
}
