package kr.or.ksmart.lms.association.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;

@RestController
public class AssociationEvaluationRestController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;
	
	//교육원 평가 합계 리스트 차트 출력 controller
	@PostMapping("/restEvaluationTotalChart")
	public Map<String, Object> getEvalTotatChart(
			@RequestParam(value="evalTotalYear") int evalTotalYear
			, @RequestParam(value="evalTotalType") String evalTotalType) {
		System.out.println("[AssociationEvaluationController getEvalTotatList] 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("evalTotalYear", evalTotalYear);
		map.put("evalTotalType", evalTotalType);
		Map<String, Object> returnMap = associationEvaluationService.getEvalTotatList(map);
		return returnMap;
	}
}
