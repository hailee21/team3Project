package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoQualification;

@Mapper
public interface AssociationInfoQualificationMapper {
	//2.자격증을 추가 하기 위한 추상 메서드 선언 
	public void insertInfoQualification(InfoQualification infoQualification);
	//1.자격 정보 개요 리스트를 보여주기 위한 추상 메서드 선언
	public List<InfoQualification> selectInfoQualification();
	
	
}
