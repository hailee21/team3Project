package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationNoticeLicenseTestService;
import kr.or.ksmart.lms.association.vo.NoticeLicenseTest;

@Controller
public class AssociationNoticeLicenseTestController {
	
	@Autowired
	AssociationNoticeLicenseTestService associationNoticeLicenseTestService;
	
	@GetMapping("/association/notice/addNoticeLicenseTest") //자격 시험 공고 등록 폼
	public ModelAndView addNoticeLicenseTest(HttpSession session, ModelAndView mav,
											@RequestParam String noticeLicenseTestCode,
											@RequestParam String infoQualificationCode,
											@RequestParam String licenseTestLocationCode,
											@RequestParam String noticeAnnualLicenseTestCode) {
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest]noticeLicenseTestCode"+noticeLicenseTestCode);
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest]infoQualificationCode"+infoQualificationCode);
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest]licenseTestLocationCode"+licenseTestLocationCode);
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest]noticeAnnualLicenseTestCode"+noticeAnnualLicenseTestCode);
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			mav.addObject("noticeLicenseTestCode", noticeLicenseTestCode);
			mav.addObject("infoQualificationCode", infoQualificationCode);
			mav.addObject("licenseTestLocationCode", licenseTestLocationCode);
			mav.addObject("noticeAnnualLicenseTestCode", noticeAnnualLicenseTestCode);
			mav.setViewName("/association/notice/addNoticeLicenseTest");
		} else {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	@PostMapping("/association/notice/addNoticeLicenseTest") //자격 시험 공고 등록 액션 컨트롤러
	public ModelAndView addNoticeLicenseTest(HttpSession session, ModelAndView mav, NoticeLicenseTest noticeLicenseTest) {
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			
			associationNoticeLicenseTestService.insertNoticeLicenseTest(noticeLicenseTest);
			System.out.println("[AssociationNoticeLicenseTestController addNoticeLicenseTest]noticeLicenseTest"+noticeLicenseTest);
			mav.setViewName("redirect:/association/notice/noticelistLicenseTestLocation?noticeAnnualLicenseTestCode="+noticeLicenseTest.getNoticeAnnualLicenseTestCode());
			
		} else {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	@GetMapping("/association/notice/listNoticeLicenseTestLocation") //자격 시험 공고 리스트
	public ModelAndView selectNoticeLicenseTest(HttpSession session, ModelAndView mav) {
		System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest] 호출");
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<NoticeLicenseTest> list = associationNoticeLicenseTestService.selectNoticeLicenseTest();
			System.out.println("[AssociationNoticeLicenseTestController selectNoticeLicenseTest]list"+list);
			mav.addObject("list", list);
			mav.setViewName("/association/notice/listNoticeLicenseTestLocation");
		} else {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
}
