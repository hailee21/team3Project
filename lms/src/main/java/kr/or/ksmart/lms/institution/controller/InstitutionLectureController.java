package kr.or.ksmart.lms.institution.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.institution.service.InstitutionLectureService;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;
import kr.or.ksmart.lms.institution.vo.Lecture;

@Controller
public class InstitutionLectureController {

	@Autowired private InstitutionLectureService institutionLectureService;
	
	// institution layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/institution/lecture/subjectList")
	public ModelAndView institutionGetSubjectListInstitution(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetSubjectListInstitution] 교육원 강의,과목 조회시작");
			mav.setViewName("/institution/lecture/subjectList");
			
			List<InfoLecture> sortList = institutionLectureService.institutionGetInfoLectureSortList();
			System.out.println("[InstitutionLectureController institutionGetSubjectListInstitution] sortList : "+ sortList);
			
			mav.addObject("sortList", sortList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout detailSubject controller
	@GetMapping("/institution/lecture/detailInfoSubject")
	public ModelAndView institutionGetDetailInfoSubjectByInfoSubjectCode(ModelAndView mav, HttpSession session
															, @RequestParam String infoSubjectCode) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetDetailInfoSubjectByInfoSubjectCode]");
			mav.setViewName("/institution/lecture/detailInfoSubject");
			
			// service에서 받은 detailSubject값을 infoSubject객체참조변수에 담아서 뷰에서 활용하자
			InfoSubject infoSubject = institutionLectureService.institutionGetDetailSubjectByInfoSubjectCode(infoSubjectCode);
			System.out.println("[InstitutionLectureController institutionGetDetailInfoSubjectByInfoSubjectCode] infoSubject : "+ infoSubject);
			
			mav.addObject("infoSubject", infoSubject);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout 강의등록 출력 controller	
	@GetMapping("/institution/lecture/addLecture")
	public ModelAndView institutionAddLecture(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionAddLecture]");
			mav.setViewName("/institution/lecture/addLecture");
			
			// 해당 교육원의 강의만을 보여주어야 하므로 로그인시 session에 담아둔 institutionCode를 꺼내어서 service의 메서드 호출하자
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode]session에서 가져온 institutionCode :"+institutionCode);
			
			// mav내부에 service에서 받은 리스트 처리된 lectureList값을 list객체참조변수에 담아서 뷰에서 활용하자
			
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout 강의목록 출력 controller
	@GetMapping("/institution/lecture/lectureList")
	public ModelAndView institutionGetLectureListByInstitutionCode(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode]");
			mav.setViewName("/institution/lecture/lectureList");
			
			// 해당 교육원의 강의만을 보여주어야 하므로 로그인시 session에 담아둔 institutionCode를 꺼내어서 service의 메서드 호출하자
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode]session에서 가져온 institutionCode :"+institutionCode);
			
			// mav내부에 service에서 받은 리스트 처리된 lectureList값을 list객체참조변수에 담아서 뷰에서 활용하자
			List<Lecture> lectureList = institutionLectureService.institutionGetLectureListByInstitutionCode(institutionCode);
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode] lectureList : "+ lectureList);
			
			mav.addObject("lectureList", lectureList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout detailLecture 출력 controller
		@GetMapping("/institution/lecture/detailLecture")
		public ModelAndView institutionGetDetailLectureByLectureCode(ModelAndView mav, HttpSession session
												, @RequestParam String lectureCode) {
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank == null) {
				memberRank="로그인 실패";
			}
			if(memberRank.equals("교육원직원")) {
				System.out.println("교육원직원");
				
				System.out.println("[InstitutionLectureController institutionGetDetailLecture]");
				System.out.println("[InstitutionLectureController institutionGetDetailLecture]lectureCode: "+lectureCode);
				mav.setViewName("/institution/lecture/detailLecture");
				
				// 해당 교육원의 해당 강의만을 보여주어야 하므로 lectureCode를 받아와서 service의 메서드 호출하자
				Lecture lecture = institutionLectureService.institutionGetDetailLectureByLectureCode(lectureCode);
				// mav내부에 service에서 받은 detailLecture값을 lecture객체참조변수에 담아서 뷰에서 활용하자
				mav.addObject("lecture", lecture);
			}else {
				System.out.println("교육원직원아님");
				
				mav.setViewName("/institution/institutionLogin");
			}		
			return mav;
		}
	
}