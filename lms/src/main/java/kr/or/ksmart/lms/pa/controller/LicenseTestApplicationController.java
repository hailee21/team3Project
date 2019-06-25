package kr.or.ksmart.lms.pa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationInfoQualificationService;
import kr.or.ksmart.lms.association.vo.InfoQualification;

@Controller
public class LicenseTestApplicationController {
	@Autowired AssociationInfoQualificationService associationinfoQualificationService;
	
	@GetMapping("/PA/lincense/LicenseTestApplication") //PA lincense 자격 시험 접수 controller
	public ModelAndView insertLicenseTestApplication(HttpSession session, ModelAndView mav) {
		System.out.println("[LicenseTestApplicationController insertLicenseTestApplication] 호출");
		String memberRank = (String)session.getAttribute(("memberRank"));
		
		if(memberRank==null){
		System.out.println("로그인 안한 상태");
		mav.setViewName("/login");	
		}
		
		else {
		List<InfoQualification> list = associationinfoQualificationService.getInfoQualification(); //자격종목코드 선택
		System.out.println("[LicenseTestApplicationController insertLicenseTestApplication]"+list.get(0).getInfoQualificationName());
		System.out.println("[LicenseTestApplicationController insertLicenseTestApplication]"+list.get(0).getInfoQualificationCode());
		
		mav.addObject("list", list);
		mav.setViewName("/PA/lincense/LicenseTestApplication");
		
		}
		
		return mav;
	}
	
	
	
	
}
