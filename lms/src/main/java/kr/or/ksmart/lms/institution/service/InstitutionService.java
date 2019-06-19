package kr.or.ksmart.lms.institution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionMapper;

@Service
@Transactional
public class InstitutionService {
	@Autowired
	InstitutionMapper institutionMapper;
}
