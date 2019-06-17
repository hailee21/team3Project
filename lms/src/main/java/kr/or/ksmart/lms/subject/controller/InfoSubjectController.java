package kr.or.ksmart.lms.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.lms.subject.mapper.SubjectMapper;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Controller
public class InfoSubjectController {
	@Autowired
	private SubjectMapper subjectMapper;
	@GetMapping("/infoSubject")
	public List<InfoSubject> informationSubjectList () {
		List<InfoSubject> subjectlist = subjectMapper.subjectList();
		return subjectlist;
	}
	
}

