package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		// 1-1. 테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		System.out.println("nowDate1: "+nowDate);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println("nowDate2: "+nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		// 1-2. 테이블 형식에 맞게 변수를 선언하고  이를 vo에 담는다. 
		String IPK = "I"+nowDate+randomNo;		
		institution.setInstitutionCode(IPK);
		System.out.println("[AssociationInstitutionService associationAddInstitution] 최종 IPK: "+IPK);
		
		// 2. Institution 테이블에 강의실 등록하기		
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
