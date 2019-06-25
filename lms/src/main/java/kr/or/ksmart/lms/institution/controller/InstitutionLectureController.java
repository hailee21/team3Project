package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionLectureService;
import kr.or.ksmart.lms.institution.vo.InfoLecture;

@Controller
public class InstitutionLectureController {

	@Autowired private InstitutionLectureService institutionLectureService;
	
	// 교육원
	// institution layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/institution/lecture/subjectList")
	public ModelAndView institutionGetSubjectListInstitution(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[LectureController institutionGetSubjectListInstitution] 교육원 강의,과목 조회시작");
			mav.setViewName("/institution/lecture/subjectList");
			
			List<InfoLecture> sortList = institutionLectureService.institutionGetInfoLectureSortList();
			System.out.println("[LectureController institutionGetSubjectListInstitution] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
}