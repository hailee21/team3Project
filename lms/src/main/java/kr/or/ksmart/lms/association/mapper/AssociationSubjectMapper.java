package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoSubject;
@Mapper
public interface AssociationSubjectMapper {
	
	public List<InfoSubject> associationSubjectList ();
}