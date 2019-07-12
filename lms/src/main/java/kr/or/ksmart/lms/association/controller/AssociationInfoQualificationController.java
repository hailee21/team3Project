package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationInfoQualificationService;
import kr.or.ksmart.lms.association.vo.InfoQualification;

@Controller
public class AssociationInfoQualificationController {
	@Autowired
	AssociationInfoQualificationService associationinfoQualificationService;
	@GetMapping("/association/license/addInfoQualification") // 자격증 추가 폼 컨트롤러
	public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationInfoQualificationController addinfoQualification] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.setViewName("/association/license/addInfoQualification");
		} else {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


	@PostMapping("/association/license/addInfoQualification") // 자격증을 추가 액션
		public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav, InfoQualification infoQualification) {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 호출");
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank == null) {
				memberRank = "로그인 실패";
			}
			if(memberRank.equals("협회직원")) {
				associationinfoQualificationService.insertQualification(infoQualification);
				System.out.println("[AssociationInfoQualificationController insertQualification] 호출");
				mav.setViewName("/association/license/addInfoQualification");
			} else {
				System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
				mav.setViewName("association/associationLogin");
			}
		
		return mav;
	}
		
	@GetMapping("/PI/infoQualificationList") // 자격 정보 개요 리스트를 보여주기 위한 메서드
	public ModelAndView infoQualification(HttpSession session, ModelAndView mav) {
		mav.setViewName("/PI/infoQualificationList");
		List<InfoQualification> list = associationinfoQualificationService.getInfoQualification();
		mav.addObject("list", list);
		return mav;
	
	}
}
