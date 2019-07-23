package kr.or.ksmart.lms.pi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.lms.pi.service.PILectureService;
import kr.or.ksmart.lms.pi.vo.InfoLecture;
import kr.or.ksmart.lms.pi.vo.InfoSubject;

@RestController
public class RestPILectureController {
	@Autowired private PILectureService piLectureService;
	
	// PI layout 강의표준명 리스트 출력 controller	
	@PostMapping("/PI/getInfoLectureNameList")
	public List<InfoLecture> piGetInfoLectureNameList(@RequestParam() String lectureSort){
		System.out.println("[RestPILectureController piGetInfoLectureNameList] lectureSort: "+ lectureSort);
		return  piLectureService.piGetInfoLectureNameList(lectureSort);
	}
	
	// PI layout 과목리스트 출력 controller
	@PostMapping("/PI/getSubjectList")
	public List<InfoSubject> piGetSubjectListByLectureCode(@RequestParam() String lectureCode){
		System.out.println("[RestPILectureController piGetSubjectListByLectureCode] lectureCode: "+ lectureCode);
		return  piLectureService.piGetSubjectListByLectureCode(lectureCode);
	}
	
	// PI layout 비동기 수강신청 중복조회 controller
	@PostMapping("/PI/lectureSignupCheck")
	public boolean piLectureSignupCheck(@RequestParam() String noticeLectureCode, @RequestParam() String memberRegistrationNumberFront){
		System.out.println("[RestPILectureController piLectureSignupCheck] noticeLectureCode: "+ noticeLectureCode);
		System.out.println("[RestPILectureController piLectureSignupCheck] memberRegistrationNumberFront: "+ memberRegistrationNumberFront);
		
		boolean lectureSignupCheck = piLectureService.piLectureSignupCheck(noticeLectureCode, memberRegistrationNumberFront);
		
		// service에서 boolean 리턴데이터타입으로 검사한 값 확인하기
		if(lectureSignupCheck) {
			System.out.println("RestController ■■xx수강신청 등록 불가xx■■");
		}else {
			System.out.println("RestController ■■oo수강신청 등록 가능oo■■");
		}
		return  lectureSignupCheck;
	}
	
	// PI layout 과목리스트 출력 controller
	@PostMapping("/PI/paymentLectureCheck")
	public boolean piPaymentLectureCheck(@RequestParam() String noticeLectureCode, HttpSession session){
		System.out.println("[RestPILectureController piGetSubjectListByLectureCode] noticeLectureCode: "+ noticeLectureCode);
		
		// 검색조건을 위해 session에서 memberCode를 가져오자
		String memberCode = (String)session.getAttribute("memberCode");
		System.out.println("[RestPILectureController piGetSubjectListByLectureCode] memberCode: "+ memberCode);
		return  piLectureService.piPaymentLectureCheck(noticeLectureCode, memberCode);
	}
}
