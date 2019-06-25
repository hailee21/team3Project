package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssociationInstitutionController {
	
	// association layout 교육원 리스트 출력 controller
	@GetMapping("/association/institution/institutionList")
	public ModelAndView associationGetInstitutionList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationInstitutionController associationGetInstitutionList]");
			
			
			mav.setViewName("association/institution/institutionList");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


}
