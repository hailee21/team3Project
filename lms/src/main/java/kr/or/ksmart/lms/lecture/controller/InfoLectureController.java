package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;

@Controller
public class InfoLectureController {

	@Autowired InfoLectureService infoLectureService;
	
	// association layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/association/Lecture/subjectList")
	public ModelAndView getSubjectListAssociation(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[InfoLectureController getSubjectListAssociation] 협회 강의,과목 조회시작");
			mav.setViewName("/association/Lecture/subjectList");
			
			List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
			System.out.println("[InfoLectureController getSubjectListAssociation] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}

	// institution layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/institution/Lecture/subjectList")
	public ModelAndView getSubjectListInstitution(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InfoLectureController getSubjectListInstitution] 교육원 강의,과목 조회시작");
			mav.setViewName("/institution/Lecture/subjectList");
			
			List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
			System.out.println("[InfoLectureController getSubjectListInstitution] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// teacher layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/teacher/Lecture/subjectList")
	public ModelAndView getSubjectListTeacher(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("강사")) {
			System.out.println("강사");
			
			System.out.println("[InfoLectureController getSubjectListTeacher] 강사 강의,과목 조회시작");
			mav.setViewName("/teacher/Lecture/subjectList");
			
			List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
			System.out.println("[InfoLectureController getSubjectListTeacher] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("강사아님");
			
			mav.setViewName("/teacher/teacherLogin");
		}		
		return mav;
	}
	
	// LE layout 강의항목, 과목 리스트 출력 controller
		@GetMapping("/LE/Lecture/subjectList")
		public ModelAndView getSubjectList(ModelAndView mav, HttpSession session) {
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank.equals("수강생")) {
				System.out.println("수강생");
				
				System.out.println("[InfoLectureController getSubjectList] 수강생 강의,과목 조회시작");
				mav.setViewName("/LE/Lecture/subjectList");
				
				List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
				System.out.println("[InfoLectureController getSubjectList] sortList : "+ sortList);
				
				mav.addObject("sortList", sortList);
			}else {
				System.out.println("수강생아님");
				
				mav.setViewName("/LE/LELogin");
			}		
			return mav;
		}
}