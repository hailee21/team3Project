package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLicenseTestResultManagementService;
import kr.or.ksmart.lms.association.vo.LicenseTestResultManagement;

@Controller
public class AssociationLicenseTestResultManagementController {
	@Autowired
	AssociationLicenseTestResultManagementService associationLicenseTestResultManagementService;
	
	@GetMapping("/association/license/addLicenseTestResultManagement") //자격 시험 결과 관리 등록 폼 컨트롤러
	public ModelAndView addLicenseTestResultManagement(HttpSession session, ModelAndView mav) {
		System.out.println("[LicenseTestResultManagement addLicenseTestResultManagement]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("[AssociationLicenseController addLicenseTestResultManagement]로그인");
			mav.setViewName("association/license/addLicenseTestResultManagement");
		} else {
			System.out.println("[AssociationLicenseController selectLicense] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
	}
	
	@PostMapping("/association/license/addLicenseTestResultManagement") //자격 시험 결과 관리 등록 액션 컨트롤러
	public ModelAndView addLicenseTestResultManagement(HttpSession session, ModelAndView mav, LicenseTestResultManagement licenseTestResultManagement) {
		System.out.println("[LicenseTestResultManagement addLicenseTestResultManagement]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			associationLicenseTestResultManagementService.insertLicenseTestResultManagement(licenseTestResultManagement);
			System.out.println("[AssociationLicenseTestResultManagementController addLicenseTestResultManagement]로그인");
			System.out.println("[AssociationLicenseTestResultManagementController addLicenseTestResultManagement]licenseTestResultManagement"+licenseTestResultManagement);
			mav.addObject("licenseTestResultManagement", licenseTestResultManagement);
			mav.setViewName("redirect:/association/license/licenseTestResultManagementList");
		} else {
			System.out.println("[AssociationLicenseController selectLicense] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
	}
	
	@GetMapping("/association/license/licenseTestResultManagementList") //자격 시험 결과 관리 리스트
	public ModelAndView selectLicenseTestResultManagement(HttpSession session, ModelAndView mav) {
		System.out.println("[LicenseTestResultManagement addLicenseTestResultManagement]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<LicenseTestResultManagement> list = associationLicenseTestResultManagementService.selectLicenseTestResultManagement();
			System.out.println("[AssociationLicenseController selectLicenseTestResultManagement]로그인");
			System.out.println("[AssociationLicenseController selectLicenseTestResultManagement]list"+list);
			mav.addObject("list", list);
			mav.setViewName("/association/license/licenseTestResultManagementList");
		} else {
			System.out.println("[AssociationLicenseController selectLicense] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    	
	}
}
