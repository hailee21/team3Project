package kr.or.ksmart.lms.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.vo.Member;
@Mapper
public interface MemberMapper {
	//	협회코드
	public IndexInstitution selectInstitution(String institutionCode);
	//	신규회원등록
	public int insertMember(Member member);
	//	회원코드 PK 출력mapper
	public String selectMemberCodePk();
}
