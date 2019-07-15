package kr.or.ksmart.lms.institution.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionClassroomService;
import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.Institution;

@Controller
public class InstitutionClassroomController {
	
	@Autowired InstitutionClassroomService institutionClassroomService;

	// institution layout 강의실등록 controller
	@GetMapping("/institution/classroom/addClassroom")
	public ModelAndView institutionAddClassroom(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionClassroomController institutionAddClassroom]");
			mav.setViewName("/institution/classroom/addClassroom");
			
			// 해당 교육원의 강의실만을 등록해야 하므로 로그인시 session에 담아둔 institutionCode를 꺼내어서 service의 메서드 호출하자
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionClassroomController institutionAddClassroom]session에서 가져온 institutionCode :"+institutionCode);
			
			// mav내부에 service에서 받은 교육원의 정보값을 담아서 뷰에서 활용하자
			Map<String, Object> map = institutionClassroomService.institutionGetInstitutionByInstitutionCode(institutionCode);
			System.out.println("[InstitutionClassroomController institutionAddClassroom] institution : "+ map.get("instituiton"));
			System.out.println("[InstitutionClassroomController institutionAddClassroom] useList : "+ map.get("useList"));
			
			Institution institution = (Institution)map.get("institution");
			System.out.println("[InstitutionClassroomController institutionAddClassroom] institutionCode : "+ institution.getInstitutionCode());
			System.out.println("[InstitutionClassroomController institutionAddClassroom] institutionName : "+ institution.getInstitutionName());
			
			mav.addObject("useList", map.get("useList"));
			mav.addObject("institutionCode", institution.getInstitutionCode());
			mav.addObject("institutionName", institution.getInstitutionName());
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// 강의실 등록 메서드 
	@PostMapping("/institution/classroom/addClassroom")
	public ModelAndView institutionAddClassroom(ModelAndView mav, HttpSession session, Classroom classroom) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionClassroomController institutionAddClassroom]");
			institutionClassroomService.institutionAddClassroom(classroom);
			// 강의실 추가 처리 이후에 강의실 리스트 조회 페이지로 이동
			mav.setViewName("redirect:/institution/classroom/listClassroom");
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout 강의실목록조회 controller
	@GetMapping("/institution/classroom/listClassroom")
	public ModelAndView institutionGetClassroomListByInstitutionCode(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionClassroomController institutionGetClassroomListByInstitutionCode]");
			mav.setViewName("/institution/classroom/listClassroom");
			
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
