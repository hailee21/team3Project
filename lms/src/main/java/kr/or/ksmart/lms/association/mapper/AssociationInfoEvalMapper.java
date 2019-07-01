package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;

@Mapper
public interface AssociationInfoEvalMapper {
	public void insertInfoEvalByAssociation (InfoEvalByAssociation infoEvalByAssociation);
	public List<InfoEvalByAssociation> selectInfoEvalByAssociationList ();
}
