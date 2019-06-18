package kr.or.ksmart.lms.license.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.license.service.InfoQualificationService;
import kr.or.ksmart.lms.license.vo.InfoQualification;

@Controller
public class InfoQualificationController {
	@Autowired
	InfoQualificationService infoQualificationService;
	@GetMapping("/addinfoQualification") // 2.자격증을 추가 하기 위한 메서드 선언
	public ModelAndView addinfoQualification(HttpSession session, ModelAndView mav) {
		mav.setViewName("/addinfoQualification");
		infoQualificationService.insertInfoQualification();
		return mav;
	}
		
	@GetMapping("/infoQualification") // 1.자격 정보 개요 리스트를 보여주기 위한 메서드
	public ModelAndView infoQualification(HttpSession session, ModelAndView mav) {
		mav.setViewName("infoQualification");
		List<InfoQualification> list = infoQualificationService.getInfoQualification();
		mav.addObject("list", list);
		return mav;
	
	}
}
