package kr.or.ksmart.lms.license.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.license.mapper.LicenseTestLocationMapper;

@Service
public class LicenseTestLocationService {

    @Autowired
    LicenseTestLocationMapper licenseTestLocationMapper;

     public void insertLicenseTestLocation() {
        licenseTestLocationMapper.insertLicenseTestLocation();
     }
}
