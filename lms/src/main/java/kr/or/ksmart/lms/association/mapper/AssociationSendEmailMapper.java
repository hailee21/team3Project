package kr.or.ksmart.lms.association.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssociationSendEmailMapper {
	public void insertTeacherApproval(String teacherApprovalCode);
	public void insertAdminApproval(String institutionApproval);
}
