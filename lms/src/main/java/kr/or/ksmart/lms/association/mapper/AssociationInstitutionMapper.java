package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Institution;

@Mapper
public interface AssociationInstitutionMapper {
	
	// 교욱원 목록 출력 메서드
	public List<Institution> associationSelectInstitutionList();

	// 교육원 상세정보 출력 메서드
	public Institution associationSelectInstitutionByInstitutionCode(String institutionCode);
}
