package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssocitationNoticeAnnualLicenseTestService;
import kr.or.ksmart.lms.association.vo.NoticeAnnualLicenseTest;

@Controller
public class AssocitationNoticeAnnualLicenseTestController {
	@Autowired
	AssocitationNoticeAnnualLicenseTestService associtationNoticeAnnualLicenseTestService;
	
	@GetMapping("/association/notice/addnoticeAnnualLicenseTest") //연간 자격 시험 일정 등록 폼
	public ModelAndView insertNoticeAnnualLicenseTestController(HttpSession session, ModelAndView mav) {
		System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<NoticeAnnualLicenseTest> list = associtationNoticeAnnualLicenseTestService.selectNoticeAnnualLicenseTest();
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectNoticeAnnualLicenseTestController]list" +list);
			mav.addObject("list", list);
			mav.setViewName("association/notice/addnoticeAnnualLicenseTest");
		} else {
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
	}
	@PostMapping("/association/notice/addnoticeAnnualLicenseTest") //연간 자격 시험 일정 등록 액션
	public ModelAndView insertNoticeAnnualLicenseTestController(HttpSession session, ModelAndView mav, NoticeAnnualLicenseTest noticeAnnualLicenseTest) {
		System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<NoticeAnnualLicenseTest> list = associtationNoticeAnnualLicenseTestService.selectNoticeAnnualLicenseTest();
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectNoticeAnnualLicenseTestController]list" +list);
			associtationNoticeAnnualLicenseTestService.insertNoticeAnnualLicenseTest(noticeAnnualLicenseTest);
			mav.addObject("list", list);
			mav.setViewName("/association/notice/addnoticeAnnualLicenseTest");
		} else {
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
    }
	@GetMapping("/association/notice/noticeAnnualLicenseTestList") //연간 자격 시험 일정 List
	public ModelAndView selectNoticeAnnualLicenseTestController(HttpSession session, ModelAndView mav) {
		System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation]");
    	String memberRank = (String)session.getAttribute("memberRank");
    	if(memberRank == null) {
			memberRank = "로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			List<NoticeAnnualLicenseTest> list = associtationNoticeAnnualLicenseTestService.selectNoticeAnnualLicenseTest();
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectNoticeAnnualLicenseTestController]list" +list);
			mav.addObject("list", list);
			mav.setViewName("association/notice/noticeAnnualLicenseTestList");
		} else {
			System.out.println("[AssocitationNoticeAnnualLicenseTestController selectLicenseTestLocation] 협회직원 아님");
			
			mav.setViewName("association/associationLogin");
		}
    	return mav;
	}
}
