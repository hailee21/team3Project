package kr.or.ksmart.lms.lecture.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.index.mapper.IndexMapper;
import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.lecture.service.InfoLectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.mapper.SubjectMapper;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Controller
public class InfoLectureController {

	@Autowired InfoLectureService infoLectureService;
	@Autowired SubjectMapper subjectMapper;
	@Autowired IndexMapper indexMapper;
	
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
		
	// LE layout 강의항목, 과목 리스트 출력 controller
		@GetMapping("/LE/Lecture/subjectList")
		public ModelAndView getSubjectList(ModelAndView mav, HttpSession session
										, @RequestParam(value="institutionCode", required = true) String institutionCode) {
			System.out.println("[InfoLectureController getSubjectList] institutionCode:"+institutionCode);	
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원 코드를 활용해서 교육원명 mav에 담기
			IndexInstitution institution = indexMapper.selectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[InfoLectureController getSubjectList] institutionName:"+institution.getInstitutionName());
			
			String memberRank = (String)session.getAttribute("memberRank");
			
				System.out.println("[InfoLectureController getSubjectList] 수강생 강의,과목 조회시작");
				mav.setViewName("/LE/Lecture/subjectList");
				
				List<InfoLecture> sortList = infoLectureService.getInfoLectureSortList();
				System.out.println("[InfoLectureController getSubjectList] sortList : "+ sortList);
				
				mav.addObject("sortList", sortList);	
			return mav;
		}
}