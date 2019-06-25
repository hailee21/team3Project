package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationInstitutionMapper;
import kr.or.ksmart.lms.association.vo.Institution;

@Service
public class AssociationInstitutionService {
	
	@Autowired private AssociationInstitutionMapper associationInstitutionMapper;
	
	public List<Institution> associationGetInstitutionList(){
		System.out.println("[AssociationInstitutionService associationGetInstitutionList]");
		// 교육원 목록을 institution내부에 담아 list처리한 뒤에 이를 리턴한다.  
		List<Institution> list = associationInstitutionMapper.associationSelectInstitutionList();
		System.out.println("[AssociationInstitutionService associationGetInstitutionList] list:"+list);
		return list;
	}

}
