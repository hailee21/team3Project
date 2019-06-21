package kr.or.ksmart.lms.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.license.mapper.InfoQualificationMapper;
import kr.or.ksmart.lms.license.vo.InfoQualification;

@Service
public class InfoQualificationService {
	@Autowired 
	InfoQualificationMapper infoQualificationMapper;
	//2.자격증을 추가 하기 위한 추상 메서드 선언 
	public void insertQualification(InfoQualification infoQualification) {
		infoQualificationMapper.insertInfoQualification(infoQualification);
	}
	//1.자격 정보 개요 리스트를 보여주기 위한 메서드
	public List<InfoQualification> getInfoQualification(){
		List<InfoQualification> list = infoQualificationMapper.selectInfoQualification();
		return list;
	}
}
