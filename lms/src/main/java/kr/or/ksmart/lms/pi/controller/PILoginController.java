package kr.or.ksmart.lms.pi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pi.service.PILoginService;
import kr.or.ksmart.lms.pi.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.vo.LoginRequest;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Controller
public class PILoginController {
	@Autowired
	private PILoginService piLoginService;

	//PI 로그인 폼 controller
	@GetMapping("/PILogin")
	public ModelAndView PILogin(HttpSession session, ModelAndView mav
		, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piLoginService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PI/PILogin");
		return mav;
	}

	//PI 로그인 액션 controller
	@PostMapping("/PILogin")
	public ModelAndView PILogin(HttpSession session, ModelAndView mav, LoginRequest loginRequest) {
		MemberOnline loginMember = piLoginService.getMemberOnline(loginRequest);
		if(loginMember == null) {
			mav.setViewName("redirect:/PILogin");
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("memberName", loginMember.getMemberName());
			session.setAttribute("memberCode", loginMember.getMemberCode());
			session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
			session.setAttribute("memberRank", loginMember.getMemberRank());
			session.setAttribute("institutionCode", loginMember.getInstitutionCode());
			session.setAttribute("institutionName", loginMember.getInstitutionName());
			if(session.getAttribute("memberRank").equals("협회직원")){
				mav.setViewName("redirect:/PAIndex?institutionCode="+loginMember.getInstitutionCode());
			} else {
				mav.setViewName("redirect:/PIIndex?institutionCode="+loginMember.getInstitutionCode());
			}
		}
		return mav;
	}
	
	//PI index 출력 controller
	@GetMapping("/PIIndex")
	public ModelAndView PIIndex(HttpSession session, ModelAndView mav
		, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		mav.setViewName("PI/PIIndex");
		IndexInstitution institution = piLoginService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		return mav;
	}

	//PI 로그아웃 controller
	@GetMapping("/PILogout")
	public ModelAndView PILogout(HttpSession session, ModelAndView mav
		, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		session.invalidate();
		mav.setViewName("redirect:/PIIndex?institutionCode="+institutionCode);
		return mav;
	}
}
