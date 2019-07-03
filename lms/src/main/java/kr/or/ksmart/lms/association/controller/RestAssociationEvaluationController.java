package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;

@RestController
public class RestAssociationEvaluationController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;

	//교육원 평가 항목에 따른 내용 출력 비동기 처리 controller
	@PostMapping("/getInfoEvalByAssociation")
	public List<InfoEvalByAssociation> getInfoEvalByAssociation(String infoEvalByAssociationSort){
		return associationEvaluationService.getInfoEvalByAssociation(infoEvalByAssociationSort);
	}
}
