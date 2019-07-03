package kr.or.ksmart.lms.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;
import kr.or.ksmart.lms.association.vo.EvalTotal;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;

@RestController
public class RestAssociationEvaluationController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;

	//교육원 평가 년도에 따른 교육원 이름 출력 비동기 처리 controller
	@PostMapping("/getInstitutionNameInEvalTotal")
	public List<EvalTotal> getInstitutionNameInEvalTotal(int evalTotalYear) {
		return associationEvaluationService.getInstitutionNameInEvalTotal(evalTotalYear);
	}

	//교육원 평가 항목에 따른 내용 출력 비동기 처리 controller
	@PostMapping("/getInfoEvalByAssociation")
	public List<InfoEvalByAssociation> getInfoEvalByAssociation(String infoEvalByAssociationSort){
		return associationEvaluationService.getInfoEvalByAssociation(infoEvalByAssociationSort);
	}
}
