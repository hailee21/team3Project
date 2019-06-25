package kr.or.ksmart.lms.pi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.pi.mapper.PILectureMapper;
import kr.or.ksmart.lms.pi.service.PILectureService;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.Institution;

@Controller
public class PILectureController {

	@Autowired private PILectureService PlectureService;
	@Autowired private PILectureMapper PilectureMapper;
	
	// 수강생	
	// LE layout 강의항목, 과목 리스트 출력 controller
		@GetMapping("/PI/lecture/subjectList")
		public ModelAndView piGetSubjectList(ModelAndView mav, HttpSession session
										, @RequestParam(value="institutionCode", required = true) String institutionCode) {
			String memberRank = (String)session.getAttribute("memberRank");
			if(memberRank == null) {
				memberRank="로그인 실패";
			}
			if(memberRank.equals("수강생")) {
				System.out.println("교육원직원");
				System.out.println("[LectureController piGetSubjectList] institutionCode:"+institutionCode);	
				// 교육원코드를 mav에 담아 활용
				mav.addObject("institutionCode", institutionCode);
				// 교육원 코드를 활용해서 교육원명 mav에 담기
				Institution institution = PilectureMapper.piSelectInstitution(institutionCode);
				mav.addObject("institutionName", institution.getInstitutionName());
				System.out.println("[LectureController piSetSubjectList] institutionName:"+institution.getInstitutionName());
				
					System.out.println("[LectureController piSetSubjectList] 수강생 강의,과목 조회시작");
					mav.setViewName("/PI/lecture/subjectList");
					
					List<InfoLecture> sortList = PlectureService.piGetInfoLectureSortList();
					System.out.println("[LectureController piSetSubjectList] sortList : "+ sortList);
					
					mav.addObject("sortList", sortList);	
			}else {
				System.out.println("수강생 아님");
				
				mav.setViewName("/login");
			}
			return mav;
		}
}