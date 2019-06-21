package kr.or.ksmart.lms.license.vo;

public class LicenseTestLocation {
    private String licenseTestLocationCode;
    private String licenseTestLocationRegion;
    private String licenseTestLocationAddress;
    private String licenseTestLocationUse;
    private int licenseTestLocationMaximumNumber;

    public String getLicenseTestLocationCode() {
        return licenseTestLocationCode;
    }

    public void setLicenseTestLocationCode(String licenseTestLocationCode) {
        this.licenseTestLocationCode = licenseTestLocationCode;
    }

    public String getLicenseTestLocationRegion() {
        return licenseTestLocationRegion;
    }

    public void setLicenseTestLocationRegion(String licenseTestLocationRegion) {
        this.licenseTestLocationRegion = licenseTestLocationRegion;
    }

    public String getLicenseTestLocationAddress() {
        return licenseTestLocationAddress;
    }

    public void setLicenseTestLocationAddress(String licenseTestLocationAddress) {
        this.licenseTestLocationAddress = licenseTestLocationAddress;
    }

    public String getLicenseTestLocationUse() {
        return licenseTestLocationUse;
    }

    public void setLicenseTestLocationUse(String licenseTestLocationUse) {
        this.licenseTestLocationUse = licenseTestLocationUse;
    }

    public int getLicenseTestLocationMaximumNumber() {
        return licenseTestLocationMaximumNumber;
    }

    public void setLicenseTestLocationMaximumNumber(int licenseTestLocationMaximumNumber) {
        this.licenseTestLocationMaximumNumber = licenseTestLocationMaximumNumber;
    }

    @Override
    public String toString() {
        return "LicenseTestLocation [licenseTestLocationAddress=" + licenseTestLocationAddress
                + ", licenseTestLocationCode=" + licenseTestLocationCode + ", licenseTestLocationMaximumNumber="
                + licenseTestLocationMaximumNumber + ", licenseTestLocationRegion=" + licenseTestLocationRegion
                + ", licenseTestLocationUse=" + licenseTestLocationUse + "]";
    }

}
