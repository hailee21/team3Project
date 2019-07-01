package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationLicenseTestLocationMapper;
import kr.or.ksmart.lms.association.vo.LicenseTestLocation;
import kr.or.ksmart.lms.association.vo.LicenseTestLocationDetail;

@Service
@Transactional
public class AssociationLicenseTestLocationService {

    @Autowired
    private AssociationLicenseTestLocationMapper AssociationlicenseTestLocationMapper;
    //자격 시험 장소 상세 등록 폼
    public List<LicenseTestLocationDetail> insertTestLocationDetail(LicenseTestLocationDetail licenseTestLocationDetail) {
		List<LicenseTestLocationDetail> list = AssociationlicenseTestLocationMapper.insertLicenseTestLocationDetail(licenseTestLocationDetail);
    	System.out.println("[AssociationLicenseTestLocationService insertTestLocationDetail]list"+list);
		return list;
    	
    }
    //자격 시험 장소 상세보기 메서드
    public List<LicenseTestLocationDetail> selectTestLocationDetail(String licenseTestLocationCode) {
		List<LicenseTestLocationDetail> list = AssociationlicenseTestLocationMapper.selectLicenseTestLocationDetail(licenseTestLocationCode);
    	System.out.println("[AssociationLicenseTestLocationService selectTestLocationDetail]list"+list);
		return list;
    	
    }
    //자격 시험 장소 조회 메서드
    public List<LicenseTestLocation> selectTestLocation(LicenseTestLocation licenseTestLocation) {
		List<LicenseTestLocation> list = AssociationlicenseTestLocationMapper.selectLicenseTestLocation(licenseTestLocation);
		System.out.println("[AssociationLicenseTestLocationService selectTestLocationDetail]list"+list);
    	return list;
    	
    }
    
    //자격 시험 장소 Pk 등록 메서드
    public void addLicenseTestLocationPk(LicenseTestLocation licenseTestLocation) {
    	System.out.println("[AssociationLicenseTestLocationService addLicenseTestLocationPk]");
    	
    	String selectLicenseTestLocationPk = AssociationlicenseTestLocationMapper.selectLicenseTestLocationPk();
    	System.out.println("[AssociationLicenseTestLocationService addLicenseTestLocationPk] selectLicenseTestLocationPk:"+selectLicenseTestLocationPk);
    	
    	int lastNo = Integer.parseInt(selectLicenseTestLocationPk.substring(3)); //가져온 PK 값에서 문자를 제외한 숫자값을 얻는다.
    	System.out.println("[AssociationLicenseTestLocationService addLicenseTestLocationPk] lastNo:"+lastNo);
    	
    	lastNo++; //얻은 숫자값에 +1을 한다.
    	System.out.println("[AssociationLicenseTestLocationService addLicenseTestLocationPk] lastNo++:"+lastNo);
		
    	String licenseTestLocationCode = "LTL"+lastNo; //입력할 테이블의 PK 형식에 맞게 변수를 선언한다.
		System.out.println("[AssociationLicenseTestLocationService addLicenseTestLocationPk] licenseTestLocationCode:"+licenseTestLocationCode);
		
		licenseTestLocation.setLicenseTestLocationCode(licenseTestLocationCode);//선언된 PK를 VO에 입력한다.
		//license_test_location 테이블에 입력 매퍼 호출
		AssociationlicenseTestLocationMapper.insertLicenseTestLocation(licenseTestLocation);

     }
}