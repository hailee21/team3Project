package kr.or.ksmart.lms.member.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SendEmailMapper {
	public void insertTeacherApproval(String teacherApprovalCode);
	public void insertInstitutionApproval(String institutionApproval);
}
