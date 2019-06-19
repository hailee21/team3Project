package kr.or.ksmart.lms.association.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationService;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Controller
public class AssociationController {
	@Autowired
	AssociationService associationService;
	
	//associationLayout 연회비 리스트 출력 controller
	@GetMapping("/associationInfoAnnualFeeList")
	public ModelAndView getInfoAnnualFeeList(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationController getInfoAnnualFeeList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/infoAnnualFee/infoAnnualFeeList");
			List<InfoAnnualFee> infoAnnualFeeList = associationService.getInfoAnnualFeeList();
			mav.addObject("infoAnnualFeelist", infoAnnualFeeList);
			System.out.println("[AssociationController getRefundPolicyList] "+infoAnnualFeeList);
		} else {
			System.out.println("[AssociationController getInfoAnnualFeeList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 환불정택 리스트 출력 controller
	@GetMapping("/associationRefundPolicyList")
	public ModelAndView getRefundPolicyList(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationController getRefundPolicyList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/associationRefundPolicyList");
			Map<String, Object> refundPolicyListMap = associationService.getRefundPolicyList();
			mav.addObject("refundPolicyAnnualFeeList", refundPolicyListMap.get("refundPolicyAnnualFeeList"));
			mav.addObject("refundPolicyLectureList", refundPolicyListMap.get("refundPolicyLectureList"));
			mav.addObject("refundPolicyLicenseList", refundPolicyListMap.get("refundPolicyLicenseList"));
		} else {
			System.out.println("[AssociationController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 연회비 환불 추가 controller
	@GetMapping("/addRefundPolicyAnnualFee")
	public ModelAndView addRefundPolicyAnnualFee(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationController addRefundPolicyAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyAnnualFee");
		} else {
			System.out.println("[AssociationController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 강의 환불 추가 controller
	@GetMapping("/addRefundPolicyLectureList")
	public ModelAndView addRefundPolicyLectureList(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationController addRefundPolicyLectureList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyLectureList");
	} else {
			System.out.println("[AssociationController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 자격시험 환불 추가 controller
	@GetMapping("/addRefundPolicyLicense")
	public ModelAndView addRefundPolicyLicense(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationController addRefundPolicyLicense] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyLicense");
		} else {
			System.out.println("[AssociationController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	//associationLayout 환불정택 추가 controller
	@PostMapping("/addRefundPolicy")
	public ModelAndView addRefundPolicy(HttpSession session, ModelAndView mav, RefundPolicy refundPolicy) {
		System.out.println("[AssociationController addRefundPolicy] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			associationService.addRefundPolicy(refundPolicy);
			mav.setViewName("redirect:/associationRefundPolicyList");
		} else {
			System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 교육원 사용권한 새로고침 controller
	@PostMapping("/associationAvailableInstitutionRefresh")
	public ModelAndView getAvailableInstitutionRefresh(HttpSession session, ModelAndView mav, RefundPolicy refundPolicy) {
		System.out.println("[AssociationController getAvailableInstitutionRefresh] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {

			mav.setViewName("redirect:/associationRefundPolicyList");
		} else {
			System.out.println("[AssociationController addRefundPolicy] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
