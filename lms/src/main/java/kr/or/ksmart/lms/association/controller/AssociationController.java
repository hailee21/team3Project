package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationService;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;

@Controller
public class AssociationController {
	@Autowired
	AssociationService associationService;
	
	@GetMapping("/associationInfoAnnualFeeList")
	public ModelAndView infoAnnualFeeList(HttpSession session, ModelAndView mav) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			mav.setViewName("association/infoAnnualFee/infoAnnualFeeList");
			List<InfoAnnualFee> infoAnnualFeelist = associationService.getInfoAnnualFeeList();
			mav.addObject("infoAnnualFeelist", infoAnnualFeelist);			
		} else {
			System.out.println("협회직원아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
