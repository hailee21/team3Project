package kr.or.ksmart.lms.pi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.service.PIMemberService;

@Controller
public class EvalInstitutionByStudentController {
	@Autowired PIMemberService memberService;
	@GetMapping("/PI/myPage/evaluation")

	public ModelAndView getEvalInstitutionByStudent(HttpSession session, ModelAndView mav,
			@RequestParam(value = "institutionCode", required = true) String institutionCode) {

		mav.setViewName("/PI/myPage/evaluation");
		IndexInstitution institution = memberService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;

	}

}
