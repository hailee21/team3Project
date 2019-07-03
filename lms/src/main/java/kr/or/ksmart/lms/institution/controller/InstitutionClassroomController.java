package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionClassroomService;
import kr.or.ksmart.lms.institution.vo.Classroom;

@Controller
public class InstitutionClassroomController {
	
	@Autowired InstitutionClassroomService institutionClassroomService;

	
	// institution layout 강의실등록 controller
	
	
	// institution layout 강의실목록조회 controller
	@GetMapping("/institution/classroom/classroomList")
	public ModelAndView institutionGetClassroomListByInstitutionCode(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode]");
			mav.setViewName("/institution/classroom/classroomList");
			
			// 해당 교육원의 강의만을 보여주어야 하므로 로그인시 session에 담아둔 institutionCode를 꺼내어서 service의 메서드 호출하자
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode]session에서 가져온 institutionCode :"+institutionCode);
			
			// mav내부에 service에서 받은 리스트 처리된 classroomList값을 classroom객체참조변수에 담아서 뷰에서 활용하자
			List<Classroom> classroom = institutionClassroomService.institutionGetClassroomListByInstitutionCode(institutionCode);
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode] classroom : "+ classroom);
			
			mav.addObject("classroom", classroom);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout 강의실세부조회 controller
	@GetMapping("/institution/classroom/detailClassroom")
	public ModelAndView institutionGetDetailClassroomByClassroomCode(ModelAndView mav, HttpSession session
																	, @RequestParam String classroomCode) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode]");
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode]classroomCode: "+classroomCode);
			mav.setViewName("/institution/classroom/detailClassroom");
			
			// mav내부에 service에서 받은 classroom값을 classroom객체참조변수에 담아서 뷰에서 활용하자
			Classroom classroom = institutionClassroomService.institutionGetDetailClassroomByClassroomCode(classroomCode);
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode] classroom : "+ classroom);
			mav.addObject("classroom", classroom);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
}
