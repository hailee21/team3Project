package kr.or.ksmart.lms.association.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationNoticeLectureService;
import kr.or.ksmart.lms.association.vo.NoticeLecture;

@Controller
public class AssociationNoticeLectureController {
	
	@Autowired private AssociationNoticeLectureService associationNoticeLectureService;
	
	// association Layout 강의등록 출력 controller
	@GetMapping("/association/lecture/addNoticeLecture")
	public ModelAndView associationAddNoticeLecture(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationNoticeLectureController associationAddNoticeLecture]");
			
			Map<String, Object> map = associationNoticeLectureService.associationReadyForAddNoticeLecture();
			// service에서 가져온 list들을 map으로 받아서 mav에 담아서 뷰에서 활용
			mav.setViewName("association/lecture/addNoticeLecture");
			mav.addObject("infoLectureSort", map.get("infoLectureSort"));
			mav.addObject("memberTeacher", map.get("memberTeacher"));
			mav.addObject("institution", map.get("institution"));

			System.out.println("[AssociationNoticeLectureController] infoLectureSort 사이즈: "+((List)map.get("infoLectureSort")).size());
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	// 강의등록 처리 
	@PostMapping("/association/lecture/addNoticeLecture")
	public ModelAndView associationAddNoticeLecture(ModelAndView mav, HttpSession session, NoticeLecture noticeLecture) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationNoticeLectureController associationAddNoticeLecture]");
			System.out.println("[AssociationNoticeLectureController associationAddNoticeLecture] noticeLecture: "+noticeLecture);
			
			associationNoticeLectureService.associationAddNoticeLecture(noticeLecture);
			mav.setViewName("redirect:/association/lecture/noticeLectureList");
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}		
		return mav;
	}
	
	// association Layout 강의공고 리스트 출력 controller
	@GetMapping("/association/lecture/noticeLectureList")
	public ModelAndView associationGetNoticeLectureList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationNoticeLectureController associationGetNoticeLectureList]");
			
			// service에서 가져온 list를 mav에 담아서 뷰에서 활용
			List<NoticeLecture> list = associationNoticeLectureService.associationGetNoticeLectureList();
			mav.setViewName("association/lecture/noticeLectureList");
			mav.addObject("noticeLectureList", list);
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	// association Layout 강의공고 상세조회 출력 controller
	@GetMapping("/association/lecture/detailNoticeLecture")
	public ModelAndView associationGetNoticeLectureByNoticeLectureCode(ModelAndView mav, HttpSession session
																	, @RequestParam String noticeLectureCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationNoticeLectureController associationGetNoticeLectureList]");
			System.out.println("[AssociationNoticeLectureController associationGetNoticeLectureList]noticeLectureCode : "+noticeLectureCode);
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			NoticeLecture noticeLecture = associationNoticeLectureService.associationGetNoticeLectureByNoticeLectureCode(noticeLectureCode);
			mav.setViewName("association/lecture/detailNoticeLecture");
			mav.addObject("noticeLecture", noticeLecture);
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}

}
