package kr.or.ksmart.lms.association.vo;

public class EmailContents {
	private String toEmailAddress;
	private String subject;
	private String text;
	
	public String getToEmailAddress() {
		return toEmailAddress;
	}
	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "MailContents [toEmailAddress=" + toEmailAddress + ", subject=" + subject + ", text=" + text + "]";
	}
	
}