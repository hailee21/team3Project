package kr.or.ksmart.lms.license.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.license.service.LicenseTestLocationService;
import kr.or.ksmart.lms.license.vo.LicenseTestLocation;

@Controller
public class LicenseTestLocationController {

    @Autowired
	LicenseTestLocationService licenseTestLocationService;
	@GetMapping("/addLicenseTestLocation") // 2.자격시험 장소 등록 폼 컨트롤러
	public ModelAndView addLicenseTestLocation(HttpSession session, ModelAndView mav) {
		System.out.println("[LicenseTestLocationController addLicenseTestLocation] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/addLicenseTestLocation");
		} else {
			System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


	@PostMapping("/addLicenseTestLocation") // 2.자격시험 장소 등록 액션 컨트롤러
		public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav, LicenseTestLocation licenseTestLocation) {
			System.out.println("[LicenseTestLocationController addLicenseTestLocation] 호출");
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank.equals("협회직원")) {
				licenseTestLocationService.addLicenseTestLocationPk(licenseTestLocation);
				System.out.println("[LicenseTestLocationController addinfoQualification] 호출");
				mav.setViewName("association/addLicenseTestLocation");
			} else {
				System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
				mav.setViewName("association/associationLogin");
			}
		
		return mav;
	}
}
