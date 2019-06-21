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
import kr.or.ksmart.lms.lecture.service.LectureService;
import kr.or.ksmart.lms.lecture.vo.InfoLecture;
import kr.or.ksmart.lms.subject.mapper.SubjectMapper;
import kr.or.ksmart.lms.subject.vo.InfoSubject;

@Controller
public class LectureController {

	@Autowired LectureService lectureService;
	@Autowired SubjectMapper subjectMapper;
	@Autowired IndexMapper indexMapper;
	// 협회
	// association layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/association/subject/subjectList")
	public ModelAndView getSubjectListAssociation(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[LectureController getSubjectListAssociation] 협회 강의,과목 조회시작");
			mav.setViewName("/association/subject/subjectList");
			
			List<InfoLecture> sortList = lectureService.getInfoLectureSortList();
			System.out.println("[LectureController getSubjectListAssociation] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);			
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("/association/associationLogin");
		}		
		return mav;
	}
	
	
	
	// 교육원
	// institution layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/institution/subject/subjectList")
	public ModelAndView getSubjectListInstitution(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[LectureController getSubjectListInstitution] 교육원 강의,과목 조회시작");
			mav.setViewName("/institution/subject/subjectList");
			
			List<InfoLecture> sortList = lectureService.getInfoLectureSortList();
			System.out.println("[LectureController getSubjectListInstitution] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	// 수강생	
	// LE layout 강의항목, 과목 리스트 출력 controller
		@GetMapping("/LE/subject/subjectList")
		public ModelAndView getSubjectList(ModelAndView mav, HttpSession session
										, @RequestParam(value="institutionCode", required = true) String institutionCode) {
			System.out.println("[LectureController getSubjectList] institutionCode:"+institutionCode);	
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원 코드를 활용해서 교육원명 mav에 담기
			IndexInstitution institution = indexMapper.selectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[LectureController getSubjectList] institutionName:"+institution.getInstitutionName());
			
			String memberRank = (String)session.getAttribute("memberRank");
			
				System.out.println("[LectureController getSubjectList] 수강생 강의,과목 조회시작");
				mav.setViewName("/LE/subject/subjectList");
				
				List<InfoLecture> sortList = lectureService.getInfoLectureSortList();
				System.out.println("[LectureController getSubjectList] sortList : "+ sortList);
				
				mav.addObject("sortList", sortList);	
			return mav;
		}
}