package kr.or.ksmart.lms.member.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.member.component.EmailComponent;
import kr.or.ksmart.lms.member.mapper.SendEmailMapper;
import kr.or.ksmart.lms.member.vo.EmailContents;

@Service
public class SendEmailService {
	
	@Autowired
	SendEmailMapper sendEmailMapper;
	@Autowired
	EmailComponent emailComponent;
	
	public void sendEmailToTeacherService(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String teacherApprovalCode = uuid.toString().replace("-", "");
		sendEmailMapper.insertTeacherApproval(teacherApprovalCode);
		EmailContents emailContents = new EmailContents();
		emailContents.setToEmailAddress(emailAddress);
		emailContents.setSubject("3팀 평생 교육원 협회 강사 승인코드 입니다.");
		emailContents.setText(teacherApprovalCode);
		emailComponent.teacherApprovalCode(emailContents);
	}
	
	public void sendEmailToInstitutionService(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String institutionApproval = uuid.toString().replace("-", "");
		sendEmailMapper.insertInstitutionApproval(institutionApproval);
		EmailContents emailContents = new EmailContents();
		emailContents.setToEmailAddress(emailAddress);
		emailContents.setSubject("3팀 평생 교육원 협회 교육원 승인코드 입니다.");
		emailContents.setText(institutionApproval);
		emailComponent.institutionApprovalCode(emailContents);
	}
}
