package kr.or.ksmart.lms.license.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.license.service.InfoQualificationService;
import kr.or.ksmart.lms.license.vo.InfoQualification;
import kr.or.ksmart.lms.login.vo.LoginRequest;
import kr.or.ksmart.lms.login.vo.MemberOnline;

@Controller
public class InfoQualificationController {
	@Autowired
	InfoQualificationService infoQualificationService;
	
	@PostMapping("/infoQualification")
	public ModelAndView infoQualification(ModelAndView mav) {
		mav.setViewName("infoQualification");
		List<InfoQualification> list = infoQualificationService.getInfoQualification();
		mav.addObject("list", list);
		return mav;
	
			}
	}

