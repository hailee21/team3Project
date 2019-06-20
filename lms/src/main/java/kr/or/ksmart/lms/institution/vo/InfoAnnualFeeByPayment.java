package kr.or.ksmart.lms.institution.vo;

public class InfoAnnualFeeByPayment {
	private String infoAnnualFeeCode;
	private int infoAnnualFeePrice;
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
	@Override
	public String toString() {
		return "InfoAnnualFeeByPayment [infoAnnualFeeCode=" + infoAnnualFeeCode + ", infoAnnualFeePrice="
				+ infoAnnualFeePrice + "]";
	}
	
}
