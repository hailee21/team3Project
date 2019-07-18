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

import kr.or.ksmart.lms.institution.service.InstitutionLectureService;
import kr.or.ksmart.lms.institution.vo.InfoLecture;
import kr.or.ksmart.lms.institution.vo.InfoSubject;
import kr.or.ksmart.lms.institution.vo.Lecture;
import kr.or.ksmart.lms.institution.vo.LectureSignup;
import kr.or.ksmart.lms.institution.vo.LectureSignupResult;
import kr.or.ksmart.lms.institution.vo.NoticeLecture;

@Controller
public class InstitutionLectureController {

	@Autowired private InstitutionLectureService institutionLectureService;
	
	// institution layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/institution/lecture/listSubject")
	public ModelAndView institutionGetSubjectListInstitution(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetSubjectListInstitution] 교육원 강의,과목 조회시작");
			mav.setViewName("/institution/lecture/listSubject");
			
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
	
	// institution layout 강의목록 출력 controller
	@GetMapping("/institution/lecture/listLecture")
	public ModelAndView institutionGetLectureListByInstitutionCode(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode]");
			mav.setViewName("/institution/lecture/listLecture");
			
			// 해당 교육원의 강의만을 보여주어야 하므로 로그인시 session에 담아둔 institutionCode를 꺼내어서 service의 메서드 호출하자
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode]session에서 가져온 institutionCode :"+institutionCode);
			
			// service에서 받은 리스트 처리된 값들을 map에서 꺼내어 mav내부에 담아서 뷰에서 활용하자
			Map<String, Object> map = institutionLectureService.institutionGetLectureListByInstitutionCode(institutionCode);		
			
			mav.addObject("lectureList", map.get("lectureList"));
			mav.addObject("NLlist", map.get("NLlist"));			
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode] lectureList : "+ map.get("lectureList"));			
			System.out.println("[InstitutionLectureController institutionGetLectureListByInstitutionCode] NLlist : "+ map.get("NLlist"));
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
			System.out.println("[InstitutionLectureController institutionAddLecture]session에서 가져온 institutionCode :"+institutionCode);
			
			// service에서 받은 리스트 처리된 값을 map에서 꺼내어 mav내부에 담아서 뷰에서 활용하자
			Map<String, Object> map = institutionLectureService.institutionGetLectureListByInstitutionCode(institutionCode);		
			
			mav.addObject("NLlist", map.get("NLlist"));				
			System.out.println("[InstitutionLectureController institutionAddLecture] NLlist : "+ map.get("NLlist"));			
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	// 강의등록 처리 controller
	@PostMapping("/institution/lecture/addLecture")
	public ModelAndView institutionAddLecture(ModelAndView mav, HttpSession session, Lecture lecture) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionAddLecture]");
			System.out.println("[InstitutionLectureController institutionAddLecture] lecture: "+lecture);
			mav.setViewName("redirect:/institution/lecture/listLecture");
			
			// service의 강의등록 메서드 호출
			institutionLectureService.institutionAddLecture(lecture);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	// institution layout 면접결과 등록을 위한 모집중 강의공고 list 출력 controller
	@GetMapping("/institution/student/listLectureSignupResult")
	public ModelAndView institutionGetNoticeLectureListForLectureSignupResult(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			
			System.out.println("[InstitutionLectureController institutionGetNoticeLectureListForLectureSignupResult]");
			// 해당 교육원만의 강의공고 조회를 위해 session에서 institutionCode받아와서 조회하기
			String institutionCode = (String)session.getAttribute("institutionCode");
			System.out.println("[InstitutionLectureController institutionGetNoticeLectureListForLectureSignupResult]institutionCode: "+institutionCode);
			mav.setViewName("/institution/student/listLectureSignupResult");
			
			// 해당 교육원의 해당 강의만을 보여주어야 하므로 institutionCode를 받아와서 service의 메서드 호출하자
			List<NoticeLecture> list= institutionLectureService.institutionGetNoticeLectureListForLectureSignupResult(institutionCode);
			System.out.println("[InstitutionLectureController institutionGetNoticeLectureListForLectureSignupResult]list: "+list);
			// mav내부에 service에서 받은 detailLecture값을 lecture객체참조변수에 담아서 뷰에서 활용하자
			mav.addObject("list", list);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	// institution layout 면접결과 등록을 위한 해당 강의공고정보 + 수강신청한 학생들 list 출력 controller
	@GetMapping("/institution/student/addLectureSignupResult")
	public ModelAndView institutionAddLectureSignupResult(ModelAndView mav, HttpSession session
														, @RequestParam String noticeLectureCode) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("교육원직원")) {
			System.out.println("교육원직원");
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult]");
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] noticeLectureCode: "+noticeLectureCode);
			
			mav.setViewName("/institution/student/addLectureSignupResult");
			// 해당 강의공고를 수강신청한 학생목록 조회를 위해 noticeLectureCode받아와서 service의 메서드 호출하기
			Map<String, Object> map = institutionLectureService.institutionGetLectureSignupListByNoticeLectureCode(noticeLectureCode);
			
			NoticeLecture noticeLecture = (NoticeLecture)map.get("noticeLecture");
			List<LectureSignup> lectureSignupList = (List<LectureSignup>)map.get("lectureSignupList");
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] noticeLecture: "+noticeLecture);
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] lectureSignupList: "+lectureSignupList);
			
			String NLCode = noticeLecture.getNoticeLectureCode();
			String institutionCode = noticeLecture.getInstitutionCode();
			String institutionName = noticeLecture.getInstitutionName();
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] NLCode: "+NLCode);
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] institutionCode: "+institutionCode);
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] institutionName: "+institutionName);
			// 수강신청 학생 수 
			int num = lectureSignupList.size();
			System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] 수강신청학생 수: "+num);
			
			// mav내부에 service에서 받은 lectureSignup값을 lecture객체참조변수에 담아서 뷰에서 활용하자
			mav.addObject("noticeLecture", noticeLecture);
			mav.addObject("lectureSignupList", lectureSignupList);
			mav.addObject("noticeLectureCode", NLCode);
			mav.addObject("institutionCode", institutionCode);
			mav.addObject("institutionName", institutionName);
		}else {
			System.out.println("교육원직원아님");
			
			mav.setViewName("/institution/institutionLogin");
		}		
		return mav;
	}
	
	
	  // institution layout 면접결과 등록을 위한 해당 강의공고정보 + 수강신청한 학생들 list 출력 controller
	  @PostMapping("/institution/student/addLectureSignupResult") 
	  public ModelAndView institutionAddLectureSignupResult(ModelAndView mav, HttpSession session, LectureSignupResult lectureSignupResult) { 
		  String memberRank = (String)session.getAttribute("memberRank"); 
		  if(memberRank == null) {
			  memberRank="로그인 실패";
		  } 
		  if(memberRank.equals("교육원직원")) {
			  System.out.println("교육원직원"); 
			  System.out.println("[InstitutionLectureController institutionAddLectureSignupResult]");
			  System.out.println("[InstitutionLectureController institutionAddLectureSignupResult] lectureSignupResult:" +lectureSignupResult);
	  
			  mav.setViewName("redirect:/institution/student/listLectureSignupResult");
			  
			  // 등록을 위해 service의 메서드 호출하기
			  institutionLectureService.institutionAddLectureSignupResult(lectureSignupResult);
		  }else { System.out.println("교육원직원아님");
	  
			 mav.setViewName("/institution/institutionLogin"); 
		  } 
		  return mav; 
		}
	}