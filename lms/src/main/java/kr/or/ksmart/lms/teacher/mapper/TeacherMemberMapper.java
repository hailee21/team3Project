package kr.or.ksmart.lms.teacher.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.association.vo.MemberTeacher;
import kr.or.ksmart.lms.institution.vo.Institution;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Mapper
public interface TeacherMemberMapper {
	//	회원가입폼에서 교육원 리스트 보여주기
	public List<Institution> selectInstList();
	//	teacher_approval 테이블에서 발행된코드인지 조회
	public String selectTeacherApprovalCode(String teacherApprovalCode);
	//	member_teacher 테이블에서 사용여부확인을 위한 조회
	public String selectMemberTeacherApprovalCode(String teacherApprovalCode);
	//	신규 회원 등록(member)
	public int insertMember(Member member);
	//	회원 아이디 저장
	public int insertMemberOnlineId(String memberOnlineInsertid);
	//	교육원 코드로 교육원이름 조회
	public String selectInstitutionName(String institutionCode);
	//	신규 회원 등록(memberOnline)
	public int insertMemberOnline(MemberOnline memberOnline);
	//	신규 강사 등록
	public void insertTeacher(MemberTeacher memberTeacher);
}
