package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationNoticeLicenseTestService;
import kr.or.ksmart.lms.association.vo.NoticeLicenseTest;

@Controller
public class AssociationNoticeLicenseTestController {
	
	@Autowired
	AssociationNoticeLicenseTestService associationNoticeLicenseTestService;
	//자격 시험 공고 리스트
	@GetMapping("/association/notice/noticeLicenseTestLocationList")
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
			mav.setViewName("/association/notice/noticeLicenseTestLocationList");
		} else {
			System.out.println("[AssociationInfoQualificationController addinfoQualification] 협회직원 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
