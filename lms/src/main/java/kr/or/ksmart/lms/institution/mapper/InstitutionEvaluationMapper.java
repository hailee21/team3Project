package kr.or.ksmart.lms.institution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.MemberTeacher;

@Mapper
public interface InstitutionEvaluationMapper {
    //강사 리스트 출력 mapper
    public List<MemberTeacher> selectMemberTeacher();
}
