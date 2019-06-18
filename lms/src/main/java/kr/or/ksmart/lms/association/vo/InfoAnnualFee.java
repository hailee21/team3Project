package kr.or.ksmart.lms.association.vo;

public class InfoAnnualFee {
	private String infoAnnualFeeCode;
	private int infoAnnualFeePrice;
	private String infoAnnualFeeDescription;
	private String infoAnnualFeeEstablishmentDate;
	public String getInfoAnnualFeeCode() {
		return infoAnnualFeeCode;
	}
	public void setInfoAnnualFeeCode(String infoAnnualFeeCode) {
		this.infoAnnualFeeCode = infoAnnualFeeCode;
	}
	public int getInfoAnnualFeePrice() {
		return infoAnnualFeePrice;
	}
	public void setInfoAnnualFeePrice(int infoAnnualFeePrice) {
		this.infoAnnualFeePrice = infoAnnualFeePrice;
	}
	public String getInfoAnnualFeeDescription() {
		return infoAnnualFeeDescription;
	}
	public void setInfoAnnualFeeDescription(String infoAnnualFeeDescription) {
		this.infoAnnualFeeDescription = infoAnnualFeeDescription;
	}
	public String getInfoAnnualFeeEstablishmentDate() {
		return infoAnnualFeeEstablishmentDate;
	}
	public void setInfoAnnualFeeEstablishmentDate(String infoAnnualFeeEstablishmentDate) {
		this.infoAnnualFeeEstablishmentDate = infoAnnualFeeEstablishmentDate;
	}
	@Override
	public String toString() {
		return "InfoAnnualFee [infoAnnualFeeCode=" + infoAnnualFeeCode + ", infoAnnualFeePrice=" + infoAnnualFeePrice
				+ ", infoAnnualFeeDescription=" + infoAnnualFeeDescription + ", infoAnnualFeeEstablishmentDate="
				+ infoAnnualFeeEstablishmentDate + "]";
	}

}
