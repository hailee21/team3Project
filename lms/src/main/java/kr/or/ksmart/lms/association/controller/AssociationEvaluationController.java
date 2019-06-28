package kr.or.ksmart.lms.association.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;
import kr.or.ksmart.lms.association.vo.InsertEvalTotal;

@Controller
public class AssociationEvaluationController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;
	
	//교육원 평가 합계 리스트 출력 controller
	@GetMapping("/association/evaluation/evaluationTotal")
	public ModelAndView getEvaluationTotal(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationEvaluationController getEvaluationTotal] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = associationEvaluationService.getEvaluationTotal();
			mav.addObject("evalTotalList", map.get("evalTotalList"));
			mav.addObject("evalTotalType", map.get("evalTotalType"));
			mav.addObject("evalTotalYear", map.get("evalTotalYear"));
			mav.setViewName("association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvaluationTotal] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 합계 차트 출력 controller
	@GetMapping("/association/evaluation/evaluationTotalChart")
	public ModelAndView getEvaluationTotalChart(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationEvaluationController getEvaluationTotalChart] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = associationEvaluationService.getEvaluationTotal();
			mav.addObject("evalTotalList", map.get("evalTotalList"));
			mav.addObject("evalTotalType", map.get("evalTotalType"));
			mav.addObject("evalTotalYear", map.get("evalTotalYear"));
			mav.setViewName("association/evaluation/evaluationTotalChart");
		} else {
			System.out.println("[AssociationEvaluationController getEvaluationTotalChart] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 합계 수정 폼 출력 controller
	@GetMapping("/association/evaluation/modifyEvalTotal")
	public ModelAndView modifyEvalTotal(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationEvaluationController modifyEvalTotal] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/evaluation/modifyEvalTotal");
		} else {
			System.out.println("[AssociationEvaluationController modifyEvalTotal] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//평가 항목 상세 추가 폼 출력 controller
	@GetMapping("/association/evaluation/addEvalByAssociation")
	public ModelAndView addEvalByAssociation(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationEvaluationController addEvalByAssociation] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/evaluation/addEvalByAssociation");
		} else {
			System.out.println("[AssociationEvaluationController addEvalByAssociation] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 항목 추가 폼 controller
	@GetMapping("/association/evaluation/addEvaluationTotal")
	public ModelAndView getEvaluationTotalAddForm(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationEvaluationController getEvaluationTotalAddForm] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/evaluation/addEvaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvaluationTotalAddForm] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 항목 추가 액션 controller
	@PostMapping("/associationAddEvalTotal")
	public ModelAndView addEvaluationTotal(HttpSession session, ModelAndView mav, InsertEvalTotal insertEvalTotal) {
		System.out.println("[AssociationEvaluationController getEvaluationTotalAddForm] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			associationEvaluationService.addEvaluationTotal(insertEvalTotal);
			mav.setViewName("redirect:/association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvaluationTotalAddForm] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 합계 년도 입력시 출려 controller
	@PostMapping("/association/evaluation/evaluationTotal")
	public ModelAndView getEvalTotatList(HttpSession session, ModelAndView mav
			, @RequestParam(value="evalTotalYear") int evalTotalYear
			, @RequestParam(value="evalTotalType") String evalTotalType) {
		System.out.println("[AssociationEvaluationController getEvalTotatList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("evalTotalYear", evalTotalYear);
			map.put("evalTotalType", evalTotalType);
			Map<String, Object> returnMap = associationEvaluationService.getEvalTotatList(map);
			mav.addObject("evalTotalList", returnMap.get("evalTotalList"));
			mav.addObject("evalTotalType", returnMap.get("evalTotalType"));
			mav.addObject("evalTotalYear", returnMap.get("evalTotalYear"));
			System.out.println(returnMap.get("evalTotalList"));
			System.out.println(returnMap.get("evalTotalType"));
			System.out.println(returnMap.get("evalTotalYear"));
			mav.setViewName("association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvalTotatList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
