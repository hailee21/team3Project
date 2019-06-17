package kr.or.ksmart.lms.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoSubjectController {
	@GetMapping("/infoSubject")
	public String informationSubjectList () {
		
		return "/infoSubject";
	}
	
}
