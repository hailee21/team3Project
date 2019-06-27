package kr.or.ksmart.lms.association.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationNoticeLectureService;

@Controller
public class AssociationNoticeLectureController {
	
	@Autowired private AssociationNoticeLectureService associationNoticeLectureService;
	
	@GetMapping("/association/lecture/noticeLectureList")
	public ModelAndView associationGetNoticeLectureList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[ClassroomController associationGetNoticeLectureList 교육원 검색]");
			
			// service에서 가져온 list를 mav에 담아서 뷰에서 활용
			mav.setViewName("association/lecture/noticeLectureList");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

}
