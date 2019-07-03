package kr.or.ksmart.lms.pi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pi.vo.NoticeLecture;
import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.service.PILectureService;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.Institution;
import kr.or.ksmart.lms.pi.vo.LectureSignup;

@Controller
public class PILectureController {

	@Autowired private PILectureService piLectureService;
	@Autowired private PILectureMapper piLectureMapper;
	
	// PI layout 강의항목, 과목 리스트 출력 controller
	@GetMapping("/PI/lecture/subjectList")
	public ModelAndView piGetSubjectList(ModelAndView mav, @RequestParam String institutionCode) {
		System.out.println("[PILectureController piGetSubjectList] institutionCode:"+institutionCode);	
		// 교육원코드를 mav에 담아 활용
		mav.addObject("institutionCode", institutionCode);
		// 교육원코드 활용해서 교육원명 mav에 담기
		Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
		mav.addObject("institutionName", institution.getInstitutionName());
		System.out.println("[PILectureController piSetSubjectList] institutionName:"+institution.getInstitutionName());
		
		System.out.println("[PILectureController piSetSubjectList] 수강생 강의,과목 조회시작");
		mav.setViewName("/PI/lecture/subjectList");
		
		List<InfoLecture> sortList = piLectureService.piGetInfoLectureSortList();
		System.out.println("[PILectureController piSetSubjectList] sortList : "+ sortList);
		
		mav.addObject("sortList", sortList);	
		return mav;
	}
	
	// PI layout 수강신청을 위한 강의공고 리스트 출력 controller 
	@GetMapping("/PI/lecture/lectureSignupNoticeLectureList")
	public ModelAndView piGetNoticeLectureList(ModelAndView mav, HttpSession session
												, @RequestParam String institutionCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("수강생")) {
			System.out.println("수강생");
			
			System.out.println("[PILectureController piGetNoticeLectureList]");
			System.out.println("[PILectureController piGetNoticeLectureList] institutionCode:"+institutionCode);	
			
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원코드 활용해서 교육원명 mav에 담기
			Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[PILectureController piGetNoticeLectureList] institutionName:"+institution.getInstitutionName());
			
			// service에서 가져온 list를 mav에 담아서 뷰에서 활용
			List<NoticeLecture> list = piLectureService.piGetNoticeLectureList(institutionCode);
			mav.setViewName("PI/lecture/lectureSignupNoticeLectureList");
			mav.addObject("noticeLectureList", list);
		}else {
			System.out.println("수강생아님");
			
			mav.setViewName("PI/PILogin");
		}
		return mav;
	}
	
	// PI layout 수강신청을 위한 세부강의공고 출력 controller 
	@GetMapping("/PI/lecture/lectureSignupNoticeLectureDetail")
	public ModelAndView piSelectNoticeLectureDetailByNoticeLectureCode(ModelAndView mav, HttpSession session
																	, @RequestParam String noticeLectureCode
																	, @RequestParam String institutionCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("수강생")) {
			System.out.println("수강생");
			
			System.out.println("[PILectureController piSelectNoticeLectureDetailByNoticeLectureCode]");
			System.out.println("[PILectureController piSelectNoticeLectureDetailByNoticeLectureCode] noticeLectureCode : "+noticeLectureCode);
			
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원코드 활용해서 교육원명 mav에 담기
			Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[PILectureController piSelectNoticeLectureDetailByNoticeLectureCode] institutionName:"+institution.getInstitutionName());
			
			// service에서 가져온 공고 상세내용을 mav에 담아서 뷰에서 활용
			NoticeLecture noticeLecture = piLectureService.piSelectNoticeLectureDetailByNoticeLectureCode(noticeLectureCode);
			mav.setViewName("PI/lecture/lectureSignupNoticeLectureDetail");
			mav.addObject("noticeLecture", noticeLecture);
		}else {
			System.out.println("수강생아님");
			
			mav.setViewName("PI/PILogin");
		}
		return mav;
	}
	
	// PI layout 수강신청 폼 controller  
	@GetMapping("/PI/lecture/lectureSignup")
	public ModelAndView piAddLectureSignup(ModelAndView mav, HttpSession session
																	, @RequestParam String noticeLectureCode
																	, @RequestParam String institutionCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("수강생")) {
			System.out.println("수강생");
			
			System.out.println("[PILectureController piAddLectureSignup]");
			System.out.println("[PILectureController piAddLectureSignup] noticeLectureCode : "+noticeLectureCode);
			
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원코드 활용해서 교육원명 mav에 담기
			Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[PILectureController piAddLectureSignup] institutionName:"+institution.getInstitutionName());
			
			// 강의공고 코드를 이용하여 noticeLecture 정보 가져와서 mav에 담고 뷰에서 사용하자
			NoticeLecture noticeLecture = piLectureService.piGetNoticeLectureInfoForLectureSignup(noticeLectureCode);
			mav.addObject("noticeLectureCode", noticeLecture.getNoticeLectureCode());
			mav.addObject("noticeLectureTitle", noticeLecture.getNoticeLectureTitle());
			mav.addObject("noticeLectureStartDate", noticeLecture.getNoticeLectureStartDate());
			mav.addObject("noticeLectureEndDate", noticeLecture.getNoticeLectureEndDate());
			
			// 세션에 담긴 member정보 가져와서 mav에 담고 뷰에서 사용하자
			String memberCode = (String)session.getAttribute("memberCode");
			String memberName = (String)session.getAttribute("memberName");
			mav.addObject("memberCode", memberCode);
			mav.addObject("memberName", memberName);
			
			mav.setViewName("/PI/lecture/lectureSignup");
		}else {
			System.out.println("수강생아님");
			
			mav.setViewName("PI/PILogin");
		}
		return mav;
	}
	
	// 수강신청 처리 
	@PostMapping("/PI/lecture/lectureSignup")
	public ModelAndView piAddLectureSignup(ModelAndView mav, HttpSession session, LectureSignup lectureSignup
										, @RequestParam String institutionCode) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("수강생")) {
			System.out.println("수강생");
			
			System.out.println("[PILectureController piAddLectureSignup]");
			
			// 교육원코드를 mav에 담아 활용
			mav.addObject("institutionCode", institutionCode);
			// 교육원코드 활용해서 교육원명 mav에 담기
			Institution institution = piLectureMapper.piSelectInstitution(institutionCode);
			mav.addObject("institutionName", institution.getInstitutionName());
			System.out.println("[PILectureController piAddLectureSignup] institutionName:"+institution.getInstitutionName());
			
			// INSERT 작업을 위해 service 메서드 호출
			piLectureService.piAddLectureSignup(lectureSignup);
			mav.setViewName("redirect:/PIIndex");
		}else {
			System.out.println("수강생아님");
			
			mav.setViewName("PI/PILogin");
		}
		return mav;
	}
}