package kr.or.ksmart.lms.pi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.service.PIBoardService;

@Controller
public class PIBoardController {
	@Autowired private PIBoardService piBoardService;
	//	교육원홈페이지 공지사항 view
	@GetMapping("/PINotice")
	public ModelAndView getNoticeByPI (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PI/Board/PINotice");
		return mav;
	}
	//	교육원홈페이지 커뮤니티 view
	@GetMapping("/PIBoard")
	public ModelAndView getBoardByPI (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PI/Board/PIBoard");
		return mav;
	}
	//	교육원홈페이지 질의응답 view
	@GetMapping("/PIQnA")
	public ModelAndView getBoardByPIQnA (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PI/Board/PIQnA");
		return mav;
	}
	//	교육원홈페이지 자주하는질문 view
	@GetMapping("/PIFAQ")
	public ModelAndView getBoardByPIFAQ (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		mav.setViewName("PI/Board/PIFAQ");
		return mav;
	}
}
