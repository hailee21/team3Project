package kr.or.ksmart.lms.institution.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionLoginService;
import kr.or.ksmart.lms.institution.vo.LoginRequest;
import kr.or.ksmart.lms.institution.vo.MemberOnline;

@Controller
public class InstitutionLoginController {
	@Autowired
	InstitutionLoginService InstitutionLoginService;

	//교육원 로그인 폼 controller
	@GetMapping("/institutionLogin")
	public ModelAndView institutionLogin(HttpSession session, ModelAndView mav) {
		mav.setViewName("institution/institutionLogin");
		return mav;
	}

	//교육원 로그인 액션 controller
	@PostMapping("/institutionLogin")
	public ModelAndView instituteLayoutLoginAction(HttpSession session, ModelAndView mav, LoginRequest loginRequest) {
		Map<String, Object> map = InstitutionLoginService.getMemberOnline(loginRequest);
		MemberOnline loginMember = (MemberOnline)map.get("memberOnline");
		//boolean Check = (boolean)map.get("Check");
		boolean Check = true;
		int remainingDate = (int)map.get("remainingDate");
		if(loginMember == null) {
			mav.setViewName("redirect:/institutionLogin");
		} else {
			System.out.println("로그인 성공");
			if(Check) {
				session.setAttribute("memberName", loginMember.getMemberName());
				session.setAttribute("memberCode", loginMember.getMemberCode());
				session.setAttribute("memberOnlineId", loginMember.getMemberOnlineId());
				session.setAttribute("memberRank", loginMember.getMemberRank());
				session.setAttribute("institutionCode", loginMember.getInstitutionCode());
				session.setAttribute("institutionName", loginMember.getInstitutionName());
				session.setAttribute("remainingDate", remainingDate);
				mav.setViewName("redirect:/institutionIndex");
			} else {
				System.out.println("남은일 0");
				String availability = "사용권이 만료되었습니다.";
				session.setAttribute("availability", availability);
				mav.setViewName("redirect:/institutionLogin");
			}
		}
		return mav;
	}

	//교육원 index 출력 controller
	@GetMapping("/institutionIndex")
	public ModelAndView institutionIndex(HttpSession session, ModelAndView mav) {
		mav.setViewName("institution/institutionIndex");
		return mav;
	}

	//협회 로그아웃 controller
	@GetMapping("/institutionLogout")
	public ModelAndView institutionLogout(HttpSession session, ModelAndView mav) {
		session.invalidate();
		mav.setViewName("redirect:/institutionLogin");
		return mav;
	}
}
