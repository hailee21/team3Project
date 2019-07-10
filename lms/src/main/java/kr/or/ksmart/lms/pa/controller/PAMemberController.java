package kr.or.ksmart.lms.pa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pa.service.PAMemberService;
import kr.or.ksmart.lms.pa.vo.IndexInstitution;

@Controller
@Transactional
public class PAMemberController {
	@Autowired private PAMemberService paMemberService;
	
	@GetMapping ("/PAmyInfo")
	public ModelAndView myPage(HttpSession session, ModelAndView mav) {
		IndexInstitution institution = paMemberService.PAIndex();
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PALogin?");
		} else if (memberName != null) {
			mav.setViewName("PA/myPage/PAmyInfo");
		}
		return mav;
	}
}
