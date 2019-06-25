package kr.or.ksmart.lms.pi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EvalInstitutionByStudentController {
	
	@GetMapping("/PI/evaluation/evalIPIByStudent")
	
	public String getEvalInstitutionByStudent() {
		
		
		
		
		
		return "/PI/evaluation/evalIPIByStudent";
		
	}
	
	
	
}
