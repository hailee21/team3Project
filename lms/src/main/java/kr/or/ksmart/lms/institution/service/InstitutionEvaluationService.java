package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionEvaluationMapper;
import kr.or.ksmart.lms.institution.vo.MemberTeacher;

@Service
@Transactional
public class InstitutionEvaluationService {
    @Autowired
    InstitutionEvaluationMapper institutionEvaluationMapper;

    //강사 회원 리스트 출력 service
    public List<MemberTeacher> getMemberTeacherList() {
        return institutionEvaluationMapper.selectMemberTeacher();
    }
}
