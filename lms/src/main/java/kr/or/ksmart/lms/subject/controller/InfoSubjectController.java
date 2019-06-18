package kr.or.ksmart.lms.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.subject.mapper.SubjectMapper;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Controller
public class InfoSubjectController {
	@Autowired
	private SubjectMapper subjectMapper;
	@RequestMapping("/infosubject")
	public ModelAndView informationSubjectList (ModelAndView mav) {
		mav.setViewName("infoSubject/infoSubject");
		List<InfoSubject> subjectlist = subjectMapper.subjectList();
		mav.addObject("subjectlist", subjectlist);
		return mav;
	}
	
}

