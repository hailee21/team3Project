package kr.or.ksmart.lms.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationInstitutionMapper;
import kr.or.ksmart.lms.association.vo.Institution;

@Service
public class AssociationInstitutionService {
	
	@Autowired private AssociationInstitutionMapper associationInstitutionMapper;
	
	// 교육원 등록 메서드
	public void associationAddInstitution(Institution institution) {
		System.out.println("[AssociationInstitutionService associationaddInstitution]");
		
		// 1. 강의실 테이블에 추가할 PK 구하는 코드 
		// 1-1. 가져온 pk를 string 데이터타입의 변수에 담는다
		String insitutionPK = associationInstitutionMapper.associationSelectInstitutionPK();
		System.out.println("[AssociationInstitutionService associationAddInstitution] 가져온 insitutionPK: "+insitutionPK);
		// 1-2. 이를 substring을 사용해 문자열을 자르고 숫자만 추출한 뒤, integer를 사용하여 int로 바꾸고, 얻은 숫자값에 1을 더한다
		int lastNo = Integer.parseInt(insitutionPK.substring(1));
		System.out.println("[AssociationInstitutionService associationAddInstitution] 추출한 lastNo: "+lastNo);
		lastNo++;
		System.out.println("[AssociationInstitutionService associationAddInstitution] 1을더한 lastNo: "+lastNo);
		// 1-3. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String IPK = "I"+lastNo;
		institution.setInstitutionCode(IPK);
		System.out.println("[AssociationInstitutionService associationAddInstitution] 최종 IPK: "+IPK);
		
		// 2. classroom 테이블에 강의실 등록하기		
		associationInstitutionMapper.associationInsertInstitution(institution);
	}
	
	// 교육원 전체목록 출력
	public List<Institution> associationGetInstitutionList(){
		System.out.println("[AssociationInstitutionService associationGetInstitutionList]");
		// 교육원 목록을 institution내부에 담아 list처리한 뒤에 이를 리턴한다.  
		List<Institution> list = associationInstitutionMapper.associationSelectInstitutionList();
		System.out.println("[AssociationInstitutionService associationGetInstitutionList] list:"+list);
		return list;
	}	
	//교육원 상세조회
	public Institution associationGetInstitutionByInstitutionCode(String institutionCode) {
		System.out.println("[AssociationInstitutionService associationGetInstitutionByInstitutionCode]");
		
		// mapper에서 가져온 교육원 정보를 Institution의 객체참조변수에 담아서 controller로 이동한다. 
		Institution institution = associationInstitutionMapper.associationSelectInstitutionByInstitutionCode(institutionCode);
		System.out.println("[AssociationInstitutionService associationGetInstitutionByInstitutionCode] institution: "+institution);
		return institution;
	}

	
}
