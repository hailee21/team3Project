package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
			mav.setViewName("association/evaluation/evaluationTotal");
		} else {
			System.out.println("[AssociationEvaluationController getEvaluationTotal] 협회직원 아님");
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
}
