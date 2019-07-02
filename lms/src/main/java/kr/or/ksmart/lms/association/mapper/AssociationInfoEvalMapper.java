package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InfoEvalByInstitution;

@Mapper
public interface AssociationInfoEvalMapper {
	public List<InfoEvalByAssociation> selectInfoEvalByAssociationList ();
	public void insertInfoEvalByAssociation (InfoEvalByAssociation infoEvalByAssociation);
	public List<InfoEvalByInstitution> selectInfoEvalByInstitutionList ();
	public void insertInfoEvalByInstitution (InfoEvalByInstitution infoEvalByInstitution);
}
