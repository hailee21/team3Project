package kr.or.ksmart.lms.association.vo;

public class RefundPolicy {
	private String refundPolicyCode;
	private String refundPolicyName;
	private String refundPolicyDescription;
	private String refundPolicyType;
	private int refundPolicyPercentage;
	private String refundPolicyLegislationDate;
	public String getRefundPolicyCode() {
		return refundPolicyCode;
	}
	public void setRefundPolicyCode(String refundPolicyCode) {
		this.refundPolicyCode = refundPolicyCode;
	}
	public String getRefundPolicyName() {
		return refundPolicyName;
	}
	public void setRefundPolicyName(String refundPolicyName) {
		this.refundPolicyName = refundPolicyName;
	}
	public String getRefundPolicyDescription() {
		return refundPolicyDescription;
	}
	public void setRefundPolicyDescription(String refundPolicyDescription) {
		this.refundPolicyDescription = refundPolicyDescription;
	}
	public String getRefundPolicyType() {
		return refundPolicyType;
	}
	public void setRefundPolicyType(String refundPolicyType) {
		this.refundPolicyType = refundPolicyType;
	}
	public int getRefundPolicyPercentage() {
		return refundPolicyPercentage;
	}
	public void setRefundPolicyPercentage(int refundPolicyPercentage) {
		this.refundPolicyPercentage = refundPolicyPercentage;
	}
	public String getRefundPolicyLegislationDate() {
		return refundPolicyLegislationDate;
	}
	public void setRefundPolicyLegislationDate(String refundPolicyLegislationDate) {
		this.refundPolicyLegislationDate = refundPolicyLegislationDate;
	}
	@Override
	public String toString() {
		return "RefundPolicy [refundPolicyCode=" + refundPolicyCode + ", refundPolicyName=" + refundPolicyName
				+ ", refundPolicyDescription=" + refundPolicyDescription + ", refundPolicyType=" + refundPolicyType
				+ ", refundPolicyPercentage=" + refundPolicyPercentage + ", refundPolicyLegislationDate="
				+ refundPolicyLegislationDate + "]";
	}
}
