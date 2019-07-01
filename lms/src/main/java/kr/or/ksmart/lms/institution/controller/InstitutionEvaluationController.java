package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionEvaluationService;
import kr.or.ksmart.lms.institution.vo.MemberTeacher;

@Controller
public class InstitutionEvaluationController {
    @Autowired
    InstitutionEvaluationService institutionEvaluationService;

	//강사 리스트 출력 controller
    @GetMapping("/institution/evaluation/evaluationTeacherList")
    public ModelAndView getEvaluationTeacherList(HttpSession session, ModelAndView mav) {
        System.out.println("[InstitutionEvaluationController getEvaluationTeacherList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			List<MemberTeacher> teacherList = institutionEvaluationService.getMemberTeacherList();
			mav.addObject("teacherList", teacherList);
			System.out.println(teacherList);
            mav.setViewName("/institution/evaluation/evaluationTeacherList");
		} else {
			System.out.println("[InstitutionEvaluationController getEvaluationTeacherList] 교육원직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	//강사 개인 평가 폼 출력 controller
	@GetMapping("/institution/evaluation/personalEvaluation")
	public ModelAndView getpersonalEvaluation(HttpSession session, ModelAndView mav) {
        System.out.println("[InstitutionEvaluationController getEvaluationTeacherList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
            mav.setViewName("/institution/evaluation/personalEvaluation");
		} else {
			System.out.println("[InstitutionEvaluationController getEvaluationTeacherList] 교육원직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
