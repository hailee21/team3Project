package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.InfoAnnualFee;

@Mapper
public interface AssociationMapper {
	public List<InfoAnnualFee> selectInfoAnnualFeeList();
}
