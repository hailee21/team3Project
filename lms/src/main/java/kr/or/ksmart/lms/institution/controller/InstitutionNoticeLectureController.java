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

import kr.or.ksmart.lms.institution.service.InstitutionNoticeLectureService;
import kr.or.ksmart.lms.institution.vo.Classroom;
import kr.or.ksmart.lms.institution.vo.LectureFail;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Controller
public class InstitutionNoticeLectureController {
	
	@Autowired private InstitutionNoticeLectureService institutionNoticeLectureService;
	
	// institution Layout 강의공고등록 출력 controller
	@GetMapping("/institution/lecture/addNoticeLecture")
	public ModelAndView institutionAddNoticeLecture(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture]");
			
			Map<String, Object> map = institutionNoticeLectureService.institutionReadyForAddNoticeLecture();
			// service에서 가져온 list들을 map으로 받아서 mav에 담아서 뷰에서 활용
			mav.setViewName("institution/lecture/addNoticeLecture");
			mav.addObject("infoLectureSort", map.get("infoLectureSort"));
			mav.addObject("memberTeacher", map.get("memberTeacher"));
			System.out.println("[institutionNoticeLectureController] infoLectureSort 사이즈: "+((List)map.get("infoLectureSort")).size());
			
			// 강의실 조회를 위해서 session에서 교육원 코드를 가져온 뒤 강의실 조회를 한다. 
			String institutionCode = (String)session.getAttribute("institutionCode");		
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture] 세션에서 가져온 institutionCode: "+institutionCode);
			// service에서 리턴받은 classroom 리스트들을 mav내부에 담아서 뷰에서 활용하자. 
			List<Classroom> classroom = institutionNoticeLectureService.institutionGetClassroomListByInstitutionCode(institutionCode);
			mav.addObject("classroom", classroom);
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture] classroom : "+classroom);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	// 강의공고 등록 처리 
	@PostMapping("/institution/lecture/addNoticeLecture")
	public ModelAndView institutionAddNoticeLecture(ModelAndView mav, HttpSession session, NoticeLecture noticeLecture) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture]");
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture] noticeLecture: "+noticeLecture);
			
			// 강의공고 등록을 위해서 session에서 교육원 코드를 가져온 뒤 이를 noticeLecture vo내부에 담아 리턴한다. 
			String institutionCode = (String)session.getAttribute("institutionCode");		
			System.out.println("[institutionNoticeLectureController institutionAddNoticeLecture] noticeLecture vo에 입력할 institutionCode: "+institutionCode);
			
			noticeLecture.setInstitutionCode(institutionCode);
			institutionNoticeLectureService.institutionAddNoticeLecture(noticeLecture);
			mav.setViewName("redirect:/institution/lecture/noticeLectureList");
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution Layout 강의공고 리스트 출력 controller
	@GetMapping("/institution/lecture/noticeLectureList")
	public ModelAndView institutionGetNoticeAndFailLectureList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[institutionNoticeLectureController institutionGetNoticeLectureList]");
			
			// service에서 가져온 list를 mav에 담아서 뷰에서 활용
			Map<String, Object> map = institutionNoticeLectureService.institutionGetNoticeLectureList();
			List<NoticeLecture> noticeLecturelist = (List<NoticeLecture>)map.get("noticeLecturelist");
			List<LectureFail> lectureFailList = (List<LectureFail>)map.get("lectureFailList");
			System.out.println("[institutionNoticeLectureController institutionGetNoticeLectureList] noticeLecturelist: "+noticeLecturelist);
			System.out.println("[institutionNoticeLectureController institutionGetNoticeLectureList] lectureFailList: "+lectureFailList);
			
			mav.setViewName("institution/lecture/noticeLectureList");
			mav.addObject("noticeLecturelist", noticeLecturelist);
			mav.addObject("lectureFailList", lectureFailList);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}
	
	// institution Layout 강의공고 상세조회 출력 controller
	@GetMapping("/institution/lecture/detailNoticeLecture")
	public ModelAndView institutionGetNoticeLectureByNoticeLectureCode(ModelAndView mav, HttpSession session
																	, @RequestParam String noticeLectureCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[institutionNoticeLectureController institutionGetNoticeLectureList]");
			System.out.println("[institutionNoticeLectureController institutionGetNoticeLectureList]noticeLectureCode : "+noticeLectureCode);
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			NoticeLecture noticeLecture = institutionNoticeLectureService.institutionGetNoticeLectureByNoticeLectureCode(noticeLectureCode);
			mav.setViewName("institution/lecture/detailNoticeLecture");
			mav.addObject("noticeLecture", noticeLecture);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("institution/institutionLogin");
		}
		return mav;
	}

}
