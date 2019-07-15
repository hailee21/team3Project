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

import kr.or.ksmart.lms.institution.service.InstitutionLectureFailService;
import kr.or.ksmart.lms.institution.service.InstitutionNoticeLectureService;
import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Controller
public class InstitutionLectureFailController {
	
	@Autowired InstitutionLectureFailService institutionLectureFailService;

	// institution layout 폐강, 폐강예정 목록 출력하기 controller
	@GetMapping("/institution/lecture/listFailLecture")
	public ModelAndView institutionGetFailWaitingLectureList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureFailController institutionGetFailWaitingLectureList]");
			
			// 해당 교육원만의 폐강 대상들 보여주기 위해 instituitonCode 사용하기
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionLectureFailController institutionGetFailWaitingLectureList] institutionCode: "+institutionCode);
			
			// service에서 map내부에 담아 가져온 list를 mav에 담아서 뷰에서 활용
			Map<String, Object> map = institutionLectureFailService.institutionGetFailWaitingLectureList(institutionCode);
			// 폐강대기리스트
			List<NoticeLecture> failWaitingList = (List<NoticeLecture>)map.get("failWaitingList");
			System.out.println("[InstitutionLectureFailController institutionGetFailWaitingLectureList] failWaitingList: "+failWaitingList);
			// 폐강리스트
			List<LectureFail> failLectureList = (List<LectureFail>)map.get("failLectureList");
			System.out.println("[InstitutionLectureFailController institutionGetFailWaitingLectureList] failLectureList: "+failLectureList);
			
			mav.setViewName("institution/lecture/listFailLecture");
			mav.addObject("failWaitingList", failWaitingList);
			mav.addObject("failLectureList", failLectureList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	// institution layout 폐강상세보기 controller
	@GetMapping("/institution/lecture/detailFailLecture")
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
			mav.setViewName("institution/lecture/detailFailLecture");
			mav.addObject("lectureFail", lectureFail);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	// institution layout 폐강 등록하기 폼 controller
	@GetMapping("/institution/lecture/addFailLecture")
	public ModelAndView institutionAddFailLecture(ModelAndView mav, HttpSession session
																	, @RequestParam String noticeLectureCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureFailController institutionAddFailLecture]");
			System.out.println("[InstitutionLectureFailController institutionAddFailLecture]noticeLectureCode : "+noticeLectureCode);
			
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			NoticeLecture noticeLecture = institutionLectureFailService.institutionGetFailLectureInfo(noticeLectureCode);
			mav.setViewName("institution/lecture/addFailLecture");
			mav.addObject("noticeLectureCode", noticeLecture.getNoticeLectureCode());
			mav.addObject("noticeLectureTitle", noticeLecture.getNoticeLectureTitle());
			mav.addObject("institutionCode", noticeLecture.getInstitutionCode());
			mav.addObject("institutionName", noticeLecture.getInstitutionName());
			mav.addObject("memberTeacherCode", noticeLecture.getMemberTeacherCode());
			mav.addObject("memberTeacherName", noticeLecture.getMemberTeacherName());
			mav.addObject("lectureStartDate", noticeLecture.getNoticeLectureStartDate());
			mav.addObject("lectureEndDate", noticeLecture.getNoticeLectureEndDate());
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	// 폐강 등록하기
	@PostMapping("/institution/lecture/addLectureFail")
	public ModelAndView institutionAddFailLecture(ModelAndView mav, HttpSession session, LectureFail lectureFail
																	, @RequestParam String noticeLectureCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureFailController institutionAddFailLecture]");
			System.out.println("[InstitutionLectureFailController institutionAddFailLecture]lectureFail : "+lectureFail);
			System.out.println("[InstitutionLectureFailController institutionAddFailLecture]noticeLectureCode : "+noticeLectureCode);
			
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			institutionLectureFailService.institutionAddFailLectureAndUpdateNoticeLecture(lectureFail, noticeLectureCode);
			mav.setViewName("redirect:/institution/lecture/listNoticeLecture");
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
}
