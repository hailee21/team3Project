package kr.or.ksmart.lms.association.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;


@RestController
public class AssociationEvaluationRestController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;
	
	//교육원 평가 합계 비동기 출려 controller
	@GetMapping("/getEvalTotatListRest")
	public Map<String, Object> getEvalTotatListRest(
			@RequestParam(value="evalTotalYear") int evalTotalYear) {
		System.out.println("[AssociationEvaluationRestController getEvalTotatListRest] 호출");
		return associationEvaluationService.getEvalTotatListRest(evalTotalYear);

	}

}
