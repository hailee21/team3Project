package kr.or.ksmart.lms.pa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pa.service.PALicenseTestApplicationService;
import kr.or.ksmart.lms.pa.vo.LicenseTestApplication;

@Controller
public class PALicenseTestApplicationController {
	@Autowired 
	PALicenseTestApplicationService pALicenseTestApplicationService;
	
	@GetMapping("/PA/license/listLicenseTestApplication") //자격증 시험 신청 리스트
	public ModelAndView addLicenseTestApplication(HttpSession session, ModelAndView mav) {
		System.out.println("[PALicenseTestApplicationController addLicenseTestApplication] 호출");
		String memberName = (String)session.getAttribute("memberName");
		if(memberName == null) {
			memberName = "로그인 실패";
		}
		if(memberName.equals("로그인 실패")) {
		System.out.println("로그인 안됨");
		mav.setViewName("/PALogin");	
		} else {
		List<LicenseTestApplication> list = pALicenseTestApplicationService.selectLicenseTestApplication(); //자격증 시험 리스트
		System.out.println("[PALicenseTestApplicationController addLicenseTestApplication]"+list);
		mav.addObject("list", list);
		mav.setViewName("/PA/license/listLicenseTestApplication");
		}		
		return mav;
	}
}
