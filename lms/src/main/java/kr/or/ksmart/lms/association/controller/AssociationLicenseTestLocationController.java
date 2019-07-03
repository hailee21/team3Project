package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLicenseTestLocationService;
import kr.or.ksmart.lms.association.vo.LicenseTestLocation;
import kr.or.ksmart.lms.association.vo.LicenseTestLocationDetail;

@Controller
public class AssociationLicenseTestLocationController {

    @Autowired
	AssociationLicenseTestLocationService licenseTestLocationService;

    @GetMapping("/association/license/addLicenseTestLocationDetail") //자격 시험 장소 세부 등록 폼 컨트롤러
    public ModelAndView addLicenseTestLocationDetail(HttpSession session, ModelAndView mav, @RequestParam String licenseTestLocationCode) {
		System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocationDetail]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.addObject("licenseTestLocationCode", licenseTestLocationCode);
			mav.setViewName("/association/license/addLicenseTestLocationDetail");
		} else {
			System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocationDetail] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
    }
    
    @PostMapping("/association/license/addLicenseTestLocaitonDetail") //자격 시험 장소 세부 등록 액션 컨트롤러
    public ModelAndView addLicenseTestLocationDetail(HttpSession session, ModelAndView mav, LicenseTestLocationDetail licenseTestLocationDetail) {
		System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocationDetail]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			licenseTestLocationService.insertTestLocationDetail(licenseTestLocationDetail);	
			mav.setViewName("redirect:/association/license/licenseTestLocationDetailList");
		} else {
			System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocationDetail] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
    }
    @GetMapping("/association/license/licenseTestLocationDetailList") // 자격시험 세부 조회 리스트
    public ModelAndView selectLicenseTestLocationDetail(HttpSession session, ModelAndView mav, @RequestParam String licenseTestLocationCode) {
		System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocationDetail]");
		System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocationDetail]licenseTestLocationCode"+licenseTestLocationCode);
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<LicenseTestLocationDetail> list = licenseTestLocationService.selectTestLocationDetail(licenseTestLocationCode);
			System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocationDetail]list"+list);
			mav.addObject("list", list);
			mav.addObject("licenseTestLocationCode", licenseTestLocationCode);
			mav.setViewName("/association/license/licenseTestLocationDetailList");
		} else {
			System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocationDetail] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
    }
    
    @GetMapping("/association/license/LicenseTestLocationList") // 자격시험 장소 조회
    public ModelAndView selectLicenseTestLocation(HttpSession session, ModelAndView mav, LicenseTestLocation licenseTestLocation) {
		System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocation]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<LicenseTestLocation> list = licenseTestLocationService.selectTestLocation(licenseTestLocation);
			mav.addObject("list", list);
			mav.setViewName("/association/license/LicenseTestLocationList");
		} else {
			System.out.println("[AssociationLicenseTestLocationController selectLicenseTestLocation] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
    }
    
    
	@GetMapping("/association/license/addLicenseTestLocation") // 자격시험 장소 등록 폼 컨트롤러
	public ModelAndView addLicenseTestLocation(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocation] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.setViewName("/association/license/addLicenseTestLocation");
		} else {
			System.out.println("[AssociationLicenseTestLocationController addLicenseTestLocation] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


	@PostMapping("/association/license/addLicenseTestLocation") // 자격시험 장소 등록 액션 컨트롤러
		public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav, LicenseTestLocation licenseTestLocation) {
			System.out.println("[LicenseTestLocationController addLicenseTestLocation] 호출");
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank == null) {
				memberRank = "로그인 실패";
			}
			if(memberRank.equals("협회직원")) {
				licenseTestLocationService.addLicenseTestLocationPk(licenseTestLocation);
				System.out.println("[AssociationLicenseTestLocationController addinfoQualification] 호출");
				mav.setViewName("/association/license/addLicenseTestLocation");
			} else {
				System.out.println("[AssociationLicenseTestLocationController addinfoQualification] 협회직원 아님");
				mav.setViewName("association/associationLogin");
			}
		
		return mav;
	}
}
