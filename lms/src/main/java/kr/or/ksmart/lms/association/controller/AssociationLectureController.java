package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLectureService;
import kr.or.ksmart.lms.association.vo.InfoLecture;

@Controller
public class AssociationLectureController {

	@Autowired AssociationLectureService associationLectureService;
	
	// 협회
	// association layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/association/subject/subjectList")
	public ModelAndView associationGetSubjectList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[LectureController getSubjectListAssociation] 협회 강의,과목 조회시작");
			mav.setViewName("/association/subject/subjectList");
			
			List<InfoLecture> sortList = associationLectureService.getInfoLectureSortList();
			System.out.println("[LectureController getSubjectListAssociation] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);			
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
}