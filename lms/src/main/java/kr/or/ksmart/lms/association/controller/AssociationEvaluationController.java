package kr.or.ksmart.lms.association.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationEvaluationService;
import kr.or.ksmart.lms.association.vo.AddEvalByAssociation;
import kr.or.ksmart.lms.association.vo.EvalTotal;
import kr.or.ksmart.lms.association.vo.InsertEvalTotal;
import kr.or.ksmart.lms.association.vo.ModifyEvalByAssociation;

@Controller
public class AssociationEvaluationController {
	@Autowired
	AssociationEvaluationService associationEvaluationService;
	
	//교육원 평가 합계리스트 출력 controller
	@RequestMapping("/association/evaluation/evaluationTotal")
	public ModelAndView getEvalTotatList(HttpSession session, ModelAndView mav
			, @RequestParam(value="evalTotalYear", required = false, defaultValue = "%") String evalTotalYear
			, @RequestParam(value="currentEvalPage", required = false, defaultValue = "1") int currentEvalPage
			, @RequestParam(value="evalTotalType", required = false, defaultValue = "%") String evalTotalType) {
		System.out.println("[AssociationEvaluationController getEvalTotatList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("evalTotalYear", evalTotalYear);
			map.put("evalTotalType", evalTotalType);
			map.put("currentEvalPage", currentEvalPage);
			Map<String, Object> returnMap = associationEvaluationService.getEvalTotatList(map);
			mav.addObject("currentEvalPage", returnMap.get("currentEvalPage"));
			mav.addObject("currentTenEvalPage", returnMap.get("currentTenEvalPage"));
			mav.addObject("lastEvalPage", returnMap.get("lastEvalPage"));
			mav.addObject("lastTenEvalPage", returnMap.get("lastTenEvalPage"));
			mav.addObject("repetitionPage", returnMap.get("repetitionPage"));
			mav.addObject("evalTotalList", returnMap.get("evalTotalList"));
			mav.addObject("evalTotalType", returnMap.get("evalTotalType"));
			mav.addObject("evalTotalYear", returnMap.get("evalTotalYear"));
			mav.addObject("evalList", returnMap.get("evalList"));
			mav.addObject("searchYear", evalTotalYear);
			mav.addObject("searchSort", evalTotalType);
			mav.setViewName("association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvalTotatList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 합계 수정 폼 출력 controller
	@GetMapping("/association/evaluation/modifyEvalTotal")
	public ModelAndView modifyEvalTotal(HttpSession session, ModelAndView mav
		, @RequestParam(value="evalTotalCode") String evalTotalCode) {
		System.out.println("[AssociationEvaluationController modifyEvalTotal] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = associationEvaluationService.getEvalTotal(evalTotalCode);
			mav.addObject("evalTotal", map.get("evalTotal"));
			mav.addObject("infoEvalByAssociation", map.get("infoEvalByAssociation"));
			mav.setViewName("association/evaluation/modifyEvalTotal");
		} else {
			System.out.println("[AssociationEvaluationController modifyEvalTotal] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//평가 항목 상세 추가 액션 controller
	@PostMapping("/associationAddEval")
	public ModelAndView addEvalByAssociation(HttpSession session, ModelAndView mav, AddEvalByAssociation addEvalByAssociation) {
		System.out.println("[AssociationEvaluationController addEvalByAssociation] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			associationEvaluationService.addEvalByAssociation(addEvalByAssociation);
			mav.setViewName("redirect:/association/evaluation/modifyEvalTotal?evalTotalCode="+addEvalByAssociation.getEvalTotalCode());
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
			Map<String, Object> map = associationEvaluationService.getEvaluationTotalAddForm();
			mav.addObject("sortList", map.get("sortList"));
			mav.addObject("yearList", map.get("yearList"));
			System.out.println(map.get("sortList"));
			System.out.println(map.get("yearList"));
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
		System.out.println("[AssociationEvaluationController addEvaluationTotal] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			associationEvaluationService.addEvaluationTotal(insertEvalTotal);
			mav.setViewName("redirect:/association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController addEvaluationTotal] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//교육원 평가 세부사항 수정 controller
	@PostMapping("/modifyEvalByAssociationScore")
	public ModelAndView modifyEvalByAssociationScore(HttpSession session, ModelAndView mav, ModifyEvalByAssociation modifyEvalByAssociation) {
		System.out.println("[AssociationEvaluationController modifyEvalByAssociationScore] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println(modifyEvalByAssociation);
			associationEvaluationService.modifyEvalByAssociationScore(modifyEvalByAssociation);
			mav.setViewName("redirect:/association/evaluation/modifyEvalTotal?evalTotalCode="+modifyEvalByAssociation.getEvalTotalCode());
		} else {
			System.out.println("[AssociationEvaluationController modifyEvalByAssociationScore] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
