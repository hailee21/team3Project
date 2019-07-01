package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.mapper.AssociationInfoEvalMapper;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;

@Service
public class AssociationInfoEvalService {
	@Autowired private AssociationInfoEvalMapper associationInfoEvalMapper;
	
	public void insertInfoEvalByAssociation(InfoEvalByAssociation eval) {
		//	info_eval_by_association 테이블에 insert 준비-> code 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 11);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String infoEvalByAssociationCode="IEIA"+nowDate+randomNo;
		eval.setInfoEvalByAssociationCode(infoEvalByAssociationCode);	//생성된 코드를 infoEvalByAssociation VO 내setting한다.
		//	info_eval_by_association 테이블에 insert
		associationInfoEvalMapper.insertInfoEvalByAssociation(eval);
	}
	
	public List<InfoEvalByAssociation> getInfoEvalByAssociationList() {
		List<InfoEvalByAssociation> evalByAssociationSort = associationInfoEvalMapper.selectInfoEvalByAssociationList();
		return evalByAssociationSort;
	}
}
