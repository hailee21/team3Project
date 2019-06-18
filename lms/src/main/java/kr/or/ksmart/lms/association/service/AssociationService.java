package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationMapper;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;

@Service
public class AssociationService {
	@Autowired
	AssociationMapper associationMapper;
	
	public List<InfoAnnualFee> getInfoAnnualFeeList(){
		return associationMapper.selectInfoAnnualFeeList();
	}
}
