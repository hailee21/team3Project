package kr.or.ksmart.lms.institution.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionLectureFailService;
import kr.or.ksmart.lms.institution.vo.LectureFail;

@Controller
public class InstitutionLectureFailController {
	
	@Autowired InstitutionLectureFailService institutionLectureFailService;
	
	// institution layout 폐강상세보기 controller
	@GetMapping("/institution/lecture/detailLectureFail")
	public ModelAndView institutionGetLectureFailByLectureFailCode(ModelAndView mav, HttpSession session
																	, @RequestParam String lectureFailCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureFailController institutionGetLectureFailByLectureFailCode]");
			System.out.println("[InstitutionLectureFailController institutionGetLectureFailByLectureFailCode]lectureFailCode : "+lectureFailCode);
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			LectureFail lectureFail = institutionLectureFailService.institutionGetLectureFailByLectureFailCode(lectureFailCode);
			mav.setViewName("institution/lecture/detailLectureFail");
			mav.addObject("lectureFail", lectureFail);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}

}
