package kr.or.ksmart.lms.institution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionMemberMapper;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.institution.vo.InstitutionMember;

@Service
@Transactional
public class InstitutionMemberService {
	@Autowired InstitutionMemberMapper institutionMemberMapper;
	
	//	교육원 직원 가입화면에서 select박스에 institutionList 출력
	public List<Institution> insertAdmin() {
		System.out.println("[InstitutionMemberService insertAdmin] 호출");
		List<Institution> instList = institutionMemberMapper.selectInstList();
		return instList;
	}
	//	회원 목록 출력
	public List<InstitutionMember> institutionMemberList (String institutionCode) {
		List<InstitutionMember> memberList = institutionMemberMapper.selectInstitutionMemberList(institutionCode);
		return memberList;
	}
	//	회원 목록에서 권한별 select
	public List<InstitutionMember> selectMemberRankList () {
		List<InstitutionMember> memberRank = institutionMemberMapper.selectInstitutionMemberRank();
		return memberRank;
	}
	//	회원 목록에서 권한별로 조회하기
	public List<InstitutionMember> selectMemberRank(String memberRank, String institution) {
		System.out.println("[InstitutionMemberService selectMemberRank] 서비스 호출" + memberRank);
		List<InstitutionMember> rank = institutionMemberMapper.selectMemberRank(institution, memberRank);
		System.out.println("[InstitutionMemberService selectMemberRank] 맵퍼 실행 result" + rank);
		return rank;
	}
}
