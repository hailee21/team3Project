package kr.or.ksmart.lms.index.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	//홈페이지 접속시 초기 화면 출력
	@RequestMapping("/")
	public ModelAndView index(HttpSession session, ModelAndView mav) {
		mav.setViewName("rootIndex");
		return mav;
	}
}