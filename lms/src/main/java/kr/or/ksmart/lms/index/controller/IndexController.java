package kr.or.ksmart.lms.index.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.mapper.IndexMapper;
import kr.or.ksmart.lms.index.vo.InfoSubject;

@Controller
public class IndexController {
	@Autowired
	IndexMapper indexMapper;
	
	@RequestMapping("/")
	public ModelAndView index(HttpSession session, ModelAndView mav) {
		mav.setViewName("index");
		List<InfoSubject> list = indexMapper.selectInfoSubjectList();
		mav.addObject("list", list);
		mav.addObject("session", session);
		return mav;
	}
}