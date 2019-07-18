package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.vo.License;

@Controller
public class AssociationLicenseController {
	
	@GetMapping("/association/license/addLicense") //자격증 발급 등록 폼 컨트롤러
	public ModelAndView addLicense(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationLicenseController addLicense]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("[AssociationLicenseController addLicense]로그인");
			mav.setViewName("/association/license/addLicense");
		} else {
			System.out.println("[AssociationLicenseController selectLicense] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
	}
	@GetMapping("/association/license/listLicense") //자격증 발급 리스트
    public ModelAndView selectLicense(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationLicenseController selectLicense]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println();
			mav.setViewName("/association/license/listLicense");
		} else {
			System.out.println("[AssociationLicenseController selectLicense] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
    }
}
