package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationLectureService;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@Controller
public class AssociationLectureController {

	@Autowired private AssociationLectureService associationLectureService;
	
	// association layout 강의표준 등록
	@GetMapping("/association/lecture/addInfoLecture")
	public ModelAndView associationAddInfoLecture(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[associationLectureController associationAddInfoLecture]");
			mav.setViewName("/association/lecture/addInfoLecture");	
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	// 강의표준 등록처리
	@PostMapping("/association/lecture/addInfoLecture")
	public ModelAndView associationAddInfoLecture(ModelAndView mav, HttpSession session, InfoLecture infoLecture) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[associationLectureController associationAddInfoLecture]");
			System.out.println("[associationLectureController associationAddInfoLecture] infoLecture : "+ infoLecture);
			mav.setViewName("redirect:/association/lecture/infoLectureList");
			
			// 등록을 위한 service의 메서드 호출하기
			associationLectureService.associationAddInfoLecture(infoLecture);
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
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
			
			System.out.println("[AssociationLectureController associationGetSubjectList]");
			mav.setViewName("/association/lecture/detailInfoLecture");
			
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
	
	// association layout 과목등록 controller
	@GetMapping("/association/lecture/addInfoSubject")
	public ModelAndView associationAddInfoSubject(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationLectureController associationAddInfoSubject]");
			mav.setViewName("/association/lecture/addInfoSubject");
			
			// 과목등록을 위한 강의개요코드 구하기
			// 강의개요항목 리스트를 화면에서 사용하여 비동기로 강의개요명 추출하자
			// mav내부에 Service에서 호출하여 리스트형식의 infoLecture객체참조변수에 담은 값을 넣어서 뷰에서 활용하기
			List<InfoLecture> infoLectureSort = associationLectureService.associationGetInfoLectureSortList();
			System.out.println("[associationLectureController associationAddInfoSubject] infoLectureSort 리스트 : "+ infoLectureSort);
			mav.addObject("infoLectureSort", infoLectureSort);				
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	// 과목등록처리
	@PostMapping("/association/lecture/addInfoSubject")
	public ModelAndView associationAddInfoSubject(ModelAndView mav, HttpSession session, InfoSubject infoSubject) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationLectureController associationAddInfoSubject]");
			System.out.println("[AssociationLectureController associationAddInfoSubject]infoSubject: "+infoSubject);
			mav.setViewName("redirect:/association/lecture/subjectList");
			
			// 등록을 위한 service의 메서드 호출하기
			associationLectureService.associationAddInfoSubject(infoSubject);
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
	// association layout 과목 상세조회 출력 controller
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