package kr.or.ksmart.lms.pi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.service.EvalInstitutionByStudentService;
import kr.or.ksmart.lms.pi.service.PIMemberService;
import kr.or.ksmart.lms.pi.vo.InfoEvalInstitutionByStudent;

@Controller
public class EvalInstitutionByStudentController {
	@Autowired
	PIMemberService memberService;
	EvalInstitutionByStudentService evalInstitutionByStudentService;
	
	@GetMapping("/PI/myPage/evaluation")
	//PI/myPage/evaluation을 위한 (수강생이 교육원평가)문제 항목 
	public ModelAndView getEvalInstitutionByStudent(HttpSession session, ModelAndView mav,
			@RequestParam(value = "institutionCode", required = true) String institutionCode) {
		
		//세션 검사
		String memberRank = (String)session.getAttribute(("memberRank"));
		
		if(memberRank==null){
			System.out.println("로그인 안한 상태");
			mav.setViewName("/PILogin");	
		}
		
		//기존 교육원 코드 , 이름 담기
		else {
			System.out.println("[EvalInstitutionByStudentController getEvalInstitutionByStudent 호출]");
			IndexInstitution institution = memberService.PIIndex(institutionCode);
			mav.addObject("institutionCode", institution.getInstitutionCode());
			mav.addObject("institutionName", institution.getInstitutionName());
			
			//기준년도에의한 교육원 평가 문제항목 service에서 select메소드 호출
			List<InfoEvalInstitutionByStudent> list = evalInstitutionByStudentService.getInfoEvalInstitutionBystudent();
			System.out.println(list.get(0).getInfoEvalInstitutionByStudentContents());
			System.out.println(list.get(0).getInfoEvalInstitutionByStudentSort());
			mav.addObject("list", list);
			mav.setViewName("/PI/myPage/evaluation");
		}
		return mav;		
	}
}
