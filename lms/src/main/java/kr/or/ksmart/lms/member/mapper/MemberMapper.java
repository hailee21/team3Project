package kr.or.ksmart.lms.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.member.vo.Member;
@Mapper
public interface MemberMapper {
	public IndexInstitution selectInstitution(String institutionCode);

	public int insertMember(Member member);
}
