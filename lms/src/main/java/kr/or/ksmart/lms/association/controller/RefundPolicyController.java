package kr.or.ksmart.lms.association.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.RefundPolicyService;
import kr.or.ksmart.lms.association.vo.RefundPolicy;

@Controller
public class RefundPolicyController {
	@Autowired
	RefundPolicyService refundPolicyService;
		
	//환불 정책 리스트 출력 controller
	@GetMapping("/association/refundPolicy/refundPolicyList")
	public ModelAndView getRefundPolicyList(HttpSession session, ModelAndView mav) {
		System.out.println("[RefundPolicyController getRefundPolicyList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/refundPolicyList");
			Map<String, Object> refundPolicyListMap = refundPolicyService.getRefundPolicyList();
			mav.addObject("refundPolicyAnnualFeeList", refundPolicyListMap.get("refundPolicyAnnualFeeList"));
			mav.addObject("refundPolicyLectureList", refundPolicyListMap.get("refundPolicyLectureList"));
			mav.addObject("refundPolicyLicenseList", refundPolicyListMap.get("refundPolicyLicenseList"));
		} else {
			System.out.println("[RefundPolicyController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//연회비 환불 추가 폼 controller
	@GetMapping("/association/refundPolicy/addRefundPolicyAnnualFee")
	public ModelAndView addRefundPolicyAnnualFee(HttpSession session, ModelAndView mav) {
		System.out.println("[RefundPolicyController addRefundPolicyAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyAnnualFee");
		} else {
			System.out.println("[RefundPolicyController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//강의 환불 추가 폼 controller
	@GetMapping("/association/refundPolicy/addRefundPolicyLectureList")
	public ModelAndView addRefundPolicyLectureList(HttpSession session, ModelAndView mav) {
		System.out.println("[RefundPolicyController addRefundPolicyLectureList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyLectureList");
	} else {
			System.out.println("[RefundPolicyController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//자격시험 환불 추가 폼 controller
	@GetMapping("/association/refundPolicy/addRefundPolicyLicense")
	public ModelAndView addRefundPolicyLicense(HttpSession session, ModelAndView mav) {
		System.out.println("[RefundPolicyController addRefundPolicyLicense] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/refundPolicy/addRefundPolicyLicense");
		} else {
			System.out.println("[RefundPolicyController getRefundPolicyList] 협회직원 아님");
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	//환불 정택 추가 액션 controller
	@PostMapping("/addRefundPolicy")
	public ModelAndView addRefundPolicy(HttpSession session, ModelAndView mav, RefundPolicy refundPolicy) {
		System.out.println("[RefundPolicyController addRefundPolicy] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			refundPolicyService.addRefundPolicy(refundPolicy);
			mav.setViewName("redirect:/association/refundPolicy/refundPolicyList");
		} else {
			System.out.println("[RefundPolicyController addRefundPolicy] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
