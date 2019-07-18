package kr.or.ksmart.lms.association.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.component.AssociationEmailComponent;
import kr.or.ksmart.lms.association.mapper.AssociationSendEmailMapper;
import kr.or.ksmart.lms.association.vo.EmailContents;

@Service
@Transactional
public class AssociationSendEmailService {
	@Autowired private AssociationSendEmailMapper associationSendEmailMapper;
	@Autowired private AssociationEmailComponent associationEmailComponent;
	
	public void sendEmailToTeacherService(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String teacherApprovalCode = uuid.toString().replace("-", "");
		associationSendEmailMapper.insertTeacherApproval(teacherApprovalCode);
		EmailContents emailContents = new EmailContents();
		emailContents.setToEmailAddress(emailAddress);
		emailContents.setSubject("3팀 평생 교육원 협회 강사 승인코드 입니다.");
		emailContents.setText(teacherApprovalCode);
		associationEmailComponent.teacherApprovalCode(emailContents);
	}
	
	public void sendEmailToInstitutionService(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String institutionApproval = uuid.toString().replace("-", "");
		associationSendEmailMapper.insertAdminApproval(institutionApproval);
		EmailContents emailContents = new EmailContents();
		emailContents.setToEmailAddress(emailAddress);
		emailContents.setSubject("3팀 평생 교육원 협회 교육원 승인코드 입니다.");
		emailContents.setText(institutionApproval);
		associationEmailComponent.institutionApprovalCode(emailContents);
	}
}
