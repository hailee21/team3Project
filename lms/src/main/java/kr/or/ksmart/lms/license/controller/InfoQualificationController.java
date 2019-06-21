package kr.or.ksmart.lms.license.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.license.service.InfoQualificationService;
import kr.or.ksmart.lms.license.vo.InfoQualification;

@Controller
public class InfoQualificationController {
	@Autowired
	InfoQualificationService infoQualificationService;
	@GetMapping("/addinfoQualification") // 2.자격증 추가 폼 컨트롤러
	public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav) {
		System.out.println("[InfoQualificationController addinfoQualification] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/addInfoQualification");
		} else {
			System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


	@PostMapping("/addinfoQualification") // 2.자격증을 추가 액션
		public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav, InfoQualification infoQualification) {
			System.out.println("[InfoQualificationController addinfoQualification] 호출");
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank.equals("협회직원")) {
				infoQualificationService.insertQualification(infoQualification);
				System.out.println("[InfoQualificationController insertQualification] 호출");
				mav.setViewName("association/addInfoQualification");
			} else {
				System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
				mav.setViewName("association/associationLogin");
			}
		
		return mav;
	}
		
	@GetMapping("/infoQualification") // 1.자격 정보 개요 리스트를 보여주기 위한 메서드
	public ModelAndView infoQualification(HttpSession session, ModelAndView mav) {
		mav.setViewName("infoQualification");
		List<InfoQualification> list = infoQualificationService.getInfoQualification();
		mav.addObject("list", list);
		return mav;
	
	}
}
