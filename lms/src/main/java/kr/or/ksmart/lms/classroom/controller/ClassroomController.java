package kr.or.ksmart.lms.classroom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.classroom.service.ClassroomService;
import kr.or.ksmart.lms.classroom.vo.Classroom;

@Controller
public class ClassroomController {
	@Autowired ClassroomService classroomService;
	// 협회
	// association layout 강의실 추가 controller
	@GetMapping("/association/classroom/addClassroom")
	public ModelAndView addClassroom(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[ClassroomController addClassroom]");
			mav.setViewName("/association/classroom/addClassroom");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}
		return mav;
	}
	// 강의실 추가 처리 
	@PostMapping("/association/classroom/addClassroom")
	public ModelAndView addClassroom(ModelAndView mav, HttpSession session, Classroom classroom) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[ClassroomController addClassroom]");
			classroomService.addClassroom(classroom);
			mav.setViewName("/association/classroom/classroomList");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}
		return mav;
	}
	// 교육원 검색
	@GetMapping("/association/classroom/searchInstitution")
	public ModelAndView getInstitutionList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[ClassroomController getInstitutionList 교육원 검색]");
			mav.setViewName("/association/classroom/searchInstitution");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}
		return mav;
	}
				
	// 강의실 리스트 조회
	@GetMapping("/association/classroom/classroomList")
	public ModelAndView getClassroomList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[ClassroomController getClassroomList]");
			mav.setViewName("/association/classroom/classroomList");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}
		return mav;
	}
	
	

	 
	
}
