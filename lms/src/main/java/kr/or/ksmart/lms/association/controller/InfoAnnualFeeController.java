package kr.or.ksmart.lms.association.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.InfoAnnualFeeService;
import kr.or.ksmart.lms.association.vo.InfoAnnualFee;
import kr.or.ksmart.lms.association.vo.RefundAnnualFee;

@Controller
public class InfoAnnualFeeController {
	@Autowired
	InfoAnnualFeeService infoAnnualFeeService;
	
	//연회비 리스트 출력 controller
	@GetMapping("/association/infoAnnualFee/infoAnnualFeeList")
	public ModelAndView getInfoAnnualFeeList(HttpSession session, ModelAndView mav) {
		System.out.println("[InfoAnnualFeeController getInfoAnnualFeeList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/infoAnnualFee/infoAnnualFeeList");
			Map<String, Object> map = infoAnnualFeeService.getInfoAnnualFeeList();
			mav.addObject("infoAnnualFeelist", map.get("infoAnnualFeeList"));
			mav.addObject("availableList", map.get("availableList"));
			mav.addObject("refundAnnualList", map.get("refundAnnualList"));
		} else {
			System.out.println("[InfoAnnualFeeController getInfoAnnualFeeList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//연회비 추가 폼 출력 controller
	@GetMapping("/association/infoAnnualFee/addInfoAnnualFee")
	public ModelAndView getInfoAnnualFeeAddForm(HttpSession session, ModelAndView mav) {
		System.out.println("[InfoAnnualFeeController getInfoAnnualFeeAddForm] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			mav.setViewName("association/infoAnnualFee/addInfoAnnualFee");
		} else {
			System.out.println("[InfoAnnualFeeController getInfoAnnualFeeAddForm] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 연회비 추가 액션 controller
	@PostMapping("/associationAddInfoAnnualFee")
	public ModelAndView addInfoAnnualFee(HttpSession session, ModelAndView mav, InfoAnnualFee infoAnnualFee) {
		System.out.println("[AssociationController addInfoAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			infoAnnualFeeService.addInfoAnnualFee(infoAnnualFee);
			mav.setViewName("redirect:/association/infoAnnualFee/infoAnnualFeeList");
		} else {
			System.out.println("[AssociationController addInfoAnnualFee] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//연회비 환불 리스트 폼 출력 controller
	@GetMapping("/association/infoAnnualFee/refundAnnualFeeList")
	public ModelAndView getRefundAnnualFeeList(HttpSession session, ModelAndView mav) {
		System.out.println("[InfoAnnualFeeController getRefundAnnualFeeList] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = infoAnnualFeeService.getAssociationRefundAnnualFeeList();
			mav.setViewName("association/infoAnnualFee/refundAnnualFeeList");
			mav.addObject("paymentList", map.get("paymentList"));
			mav.addObject("paymentListForRefund", map.get("paymentListForRefund"));
		} else {
			System.out.println("[InfoAnnualFeeController getRefundAnnualFeeList] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//교육원 사용권한 새로고침 controller
	@GetMapping("/availableInstitutionRefresh")
	public ModelAndView getAvailableInstitutionRefresh(HttpSession session, ModelAndView mav) {
		System.out.println("[InfoAnnualFeeController getAvailableInstitutionRefresh] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			infoAnnualFeeService.getAvailableInstitutionRefresh();
			mav.setViewName("redirect:/association/infoAnnualFee/infoAnnualFeeList");
		} else {
			System.out.println("[InfoAnnualFeeController getAvailableInstitutionRefresh] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//associationLayout 연회비 환불 폼 controller
	@GetMapping("/association/infoAnnualFee/addRefundAnnualFee")
	public ModelAndView getRefundAnnualFeeForm(HttpSession session, ModelAndView mav
			,@RequestParam(value="paymentAnnualFeeCode", required = true) String paymentAnnualFeeCode) {
		System.out.println("[InfoAnnualFeeController getRefundAnnualFeeForm] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			Map<String, Object> map = infoAnnualFeeService.getRefundAnnualFeeForm(paymentAnnualFeeCode);
			mav.setViewName("association/infoAnnualFee/addRefundAnnualFee");
			mav.addObject("refundPolicyAnnualFeeList", map.get("refundPolicyAnnualFeeList"));
			mav.addObject("remainingDate", map.get("remainingDate"));
			mav.addObject("payment", map.get("payment"));
		} else {
			System.out.println("[InfoAnnualFeeController getRefundAnnualFeeForm] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

	//associationLayout 연회비 환불 액션 controller
	@PostMapping("/addRefundAnnualFee")
	public ModelAndView addRefundAnnualFee(HttpSession session, ModelAndView mav, RefundAnnualFee refundAnnualFee) {
		System.out.println("[InfoAnnualFeeController addRefundAnnualFee] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println(refundAnnualFee);
			infoAnnualFeeService.addRefundAnnualFee(refundAnnualFee);
			mav.setViewName("redirect:/association/infoAnnualFee/infoAnnualFeeList");
		} else {
			System.out.println("[InfoAnnualFeeController addRefundAnnualFee] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
