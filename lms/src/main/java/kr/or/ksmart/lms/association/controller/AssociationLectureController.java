package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLectureService;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@Controller
public class AssociationLectureController {

	@Autowired private AssociationLectureService associationLectureService;
	
	// association layout 강의표준 리스트 출력 controller
	@GetMapping("/association/lecture/infoLectureList")
	public ModelAndView associationGetInfoLectureList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[associationLectureController associationGetInfoLectureList]");
			mav.setViewName("/association/lecture/infoLectureList");
			
			// mav내부에 Service에서 호출하여 list 객체참조변수에 담은 값을 넣어서 뷰에서 활용하기
			List<InfoLecture> infoLectureList = associationLectureService.associationGetInfoLectureList();
			System.out.println("[associationLectureController associationGetInfoLectureList] infoLectureList : "+ infoLectureList);
			mav.addObject("infoLectureList", infoLectureList);			
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	// association layout detailInfoLecture 출력 controller
	@GetMapping("/association/lecture/detailInfoLecture")
	public ModelAndView associationGetDetailInfoLecture(ModelAndView mav, HttpSession session
														,@RequestParam String infoLectureCode) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationLectureController associationGetSubjectList] 협회 강의,과목 조회시작");
			mav.setViewName("/association/lecture/subjectList");
			
			// mav내부에 Service에서 호출하여 infoLecture객체참조변수에 담은 값을 넣어서 뷰에서 활용하기
			InfoLecture infoLecture = associationLectureService.associationGetDetailInfoLecture(infoLectureCode);
			System.out.println("[associationLectureController associationGetDetailInfoLecture] infoLecture : "+ infoLecture);
			mav.addObject("infoLecture", infoLecture);				
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	// association layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/association/lecture/subjectList")
	public ModelAndView associationGetSubjectList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationLectureController associationGetSubjectList] 협회 강의,과목 조회시작");
			mav.setViewName("/association/lecture/subjectList");
			
			// mav내부에 Service에서 호출하여 list 객체참조변수에 담은 값을 넣어서 뷰에서 활용하기
			List<InfoLecture> sortList = associationLectureService.associationGetInfoLectureSortList();
			System.out.println("[associationLectureController associationGetSubjectList] sortList : "+ sortList);
			mav.addObject("sortList", sortList);			
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	@GetMapping("/association/lecture/detailSubject")
	public ModelAndView associationGetDetailSubjectBySubjectCode(ModelAndView mav, HttpSession session
																, @RequestParam String infoSubjectCode) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationLectureController associationGetDetailSubjectBySubjectCode]");
			System.out.println("[AssociationLectureController associationGetDetailSubjectBySubjectCode] infoSubjectCode :"+infoSubjectCode);
			mav.setViewName("/association/lecture/detailSubject");
			
			// mav내부에 Service에서 호출하여 infoSubject 객체참조변수에 담은 값을 넣어서 뷰에서 활용하기
			InfoSubject infoSubject = associationLectureService.associationGetDetailSubjectBySubjectCode(infoSubjectCode);
			System.out.println("[associationLectureController associationGetDetailSubjectBySubjectCode] infoSubject : "+ infoSubject);
			mav.addObject("infoSubject", infoSubject);				
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
}