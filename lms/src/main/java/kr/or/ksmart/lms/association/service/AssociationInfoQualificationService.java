package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationInfoQualificationMapper;
import kr.or.ksmart.lms.association.vo.InfoQualification;

@Service
public class AssociationInfoQualificationService {
	@Autowired 
	AssociationInfoQualificationMapper infoQualificationMapper;
	//2.자격증을 추가 하기 위한 추상 메서드 선언 
	public void insertQualification(InfoQualification infoQualification) {
		System.out.println("[AssociationInfoQualificationService insertQualification]");
		infoQualificationMapper.insertInfoQualification(infoQualification);
	}
	//1.자격 정보 개요 리스트를 보여주기 위한 메서드
	public List<InfoQualification> getInfoQualification(){
		List<InfoQualification> list = infoQualificationMapper.selectInfoQualification();
		return list;
	}
}
