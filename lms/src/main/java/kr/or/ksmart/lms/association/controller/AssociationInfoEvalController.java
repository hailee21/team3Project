package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationInfoEvalService;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InfoEvalByInstitution;
import kr.or.ksmart.lms.association.vo.InfoEvalInstitutionByStudent;
import kr.or.ksmart.lms.association.vo.InfoEvalLectureByStudent;

@Controller
public class AssociationInfoEvalController {
	@Autowired private AssociationInfoEvalService associationInfoEvalService;
	
	//	평가조회
	@GetMapping("/lookup")
	public ModelAndView lookupMap (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/evaluation/lookupMap");
		} else {
			System.out.println("[AssociationInfoEvalController lookupMap] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	평가항목관리
	@GetMapping("/itemManagement")
	public ModelAndView itemManagementMap (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/evaluation/itemManagementMap");
		} else {
			System.out.println("[AssociationInfoEvalController itemManagementMap] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//	평가항목관리 : 교육원 view
	@GetMapping("/evalByAssociation")
	public ModelAndView getEvalByAssociation (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/infoEvaluation/evaluationByAssociation");
			List<InfoEvalByAssociation> evalByAssociationSort = associationInfoEvalService.getInfoEvalByAssociationList();
			mav.addObject("evalByAssociationSort", evalByAssociationSort);
		} else {
			System.out.println("[AssociationInfoEvalController getEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	교육원평가항목 추가 form
	@GetMapping("/addInfoEvalByAssociation")
	public ModelAndView addEvalByAssociation (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addInfoEvalByAssociation..
			mav.setViewName("association/infoEvaluation/addInfoEvalByAssociation");
		} else {
			System.out.println("[AssociationInfoEvalController addEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	교육원평가항목 insert submit
	@PostMapping("/infoEvalByAssociationInsert")
	public ModelAndView insertInfoEvalByAssociation (InfoEvalByAssociation eval
			, ModelAndView mav, HttpSession session) {
		System.out.println("[AssociationInfoEvalController insertInfoEvalByAssociation] 호출");
		//	회원 등급 session 검사
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addInfoEvalByAssociation..
			associationInfoEvalService.insertInfoEvalByAssociation(eval);
			mav.setViewName("redirect:/evalByAssociation");
		} else {
			System.out.println("[AssociationInfoEvalController insertInfoEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//	평가항목관리 : 교육원-강사 view
	@GetMapping("/evalByInstitution")
	public ModelAndView getEvalbyInstitution (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/infoEvaluation/evaluationByInstitution");
			List<InfoEvalByInstitution> evalByInstitutionSort = associationInfoEvalService.getInfoEvalByInstitutionList();
			mav.addObject("evalByInstitutionSort", evalByInstitutionSort);
		} else {
			System.out.println("[AssociationInfoEvalController getEvalbyInstitution] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	교육원-강사 평가항목 추가 form addInfoEvalByInstitution
	@GetMapping("/addInfoEvalByInstitution")
	public ModelAndView addEvalByInstitution (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addEvalByInstitution..
			mav.setViewName("association/infoEvaluation/addInfoEvalByInstitution");
		} else {
			System.out.println("[AssociationInfoEvalController addEvalByInstitution] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	교육원-강사 평가항목 insert submit
	@PostMapping("/infoEvalByInstitutionInsert")
	public ModelAndView insertInfoEvalByInstitution (InfoEvalByInstitution eval
			, ModelAndView mav, HttpSession session) {
		System.out.println("[AssociationInfoEvalController insertInfoEvalByInstitution] 호출");
		//	회원 등급 session 검사
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addInfoEvalByAssociation..
			associationInfoEvalService.insertInfoEvalByInstitution(eval);
			mav.setViewName("redirect:/evalByInstitution");
		} else {
			System.out.println("[AssociationInfoEvalController insertInfoEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	//	평가항목관리 : 수강생-교육원 view
	@GetMapping("/institutionByStudent")
	public ModelAndView getInstitutionbyStudent (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/infoEvaluation/institutionByStudent");
			List<InfoEvalInstitutionByStudent> evalInstitutionByStudent = associationInfoEvalService.getInfoEvalInstitutionByStudent();
			mav.addObject("evalInstitutionByStudent", evalInstitutionByStudent);
		} else {
			System.out.println("[AssociationInfoEvalController getInstitutionbyStudent] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	수강생-교육원 평가항목 추가 form addInfoEvalByInstitution
	@GetMapping("/addInfoEvalInstitutionByStudent")
	public ModelAndView addInfoEvalInstitutionByStudent (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addEvalByInstitution..
			mav.setViewName("association/infoEvaluation/addInfoEvalInstitutionByStudent");
		} else {
			System.out.println("[AssociationInfoEvalController addInfoEvalInstitutionByStudent] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	수강생-교육원 평가항목 insert submit
	@PostMapping("/infoEvalInstitutionByStudentInsert")
	public ModelAndView insertInfoEvalInstitutionByStudent (InfoEvalInstitutionByStudent eval
			, ModelAndView mav, HttpSession session) {
		System.out.println("[AssociationInfoEvalController insertInfoEvalInstitutionByStudent] 호출");
		//	회원 등급 session 검사
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addInfoEvalByAssociation..
			associationInfoEvalService.insertInfoEvalInstitutionByStudent(eval);
			mav.setViewName("redirect:/institutionByStudent");
		} else {
			System.out.println("[AssociationInfoEvalController insertInfoEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	
	
	//	평가항목관리 : 수강생-강의/강사 view
	@GetMapping("/lectureByStudent")
	public ModelAndView getLecturebyStudent (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank 여부로 권한별 session 검사
			memberRank = "로그인 실패";
		} if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 sendEmailToTeacher..
			mav.setViewName("association/infoEvaluation/lectureByStudent");
			List<InfoEvalLectureByStudent> evalLectureByStudent = associationInfoEvalService.getInfoEvalLectureByStudent();
			mav.addObject("evalLectureByStudent", evalLectureByStudent);
		} else {
			System.out.println("[AssociationInfoEvalController getLecturebyStudent] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	수강생-강의/강사 평가항목 추가 form addInfoEvalByInstitution
	@GetMapping("/addInfoEvalLectureByStudent")
	public ModelAndView addInfoEvalLectureByStudent (ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addEvalByInstitution..
			mav.setViewName("association/infoEvaluation/addInfoEvalLectureByStudent");
		} else {
			System.out.println("[AssociationInfoEvalController addInfoEvalLectureByStudent] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
	//	수강생-강의/강사 평가항목 insert submit
	@PostMapping("/infoEvalLectureByStudentInsert")
	public ModelAndView insertInfoEvalLectureByStudent (InfoEvalLectureByStudent eval
			, ModelAndView mav, HttpSession session) {
		System.out.println("[AssociationInfoEvalController insertInfoEvalLectureByStudent] 호출");
		//	회원 등급 session 검사
		String memberRank = (String)session.getAttribute("memberRank");
		if(memberRank == null) {	//	memberRank로 로그인 여부 확인
			memberRank = "로그인 실패";
		}
		if (memberRank.equals("협회직원")) {	//	요청한 회원등급이 협회직원이면 association 내 addInfoEvalByAssociation..
			associationInfoEvalService.insertInfoEvalLectureByStudent(eval);
			mav.setViewName("redirect:/lectureByStudent");
		} else {
			System.out.println("[AssociationInfoEvalController insertInfoEvalByAssociation] 협회 직원이 아님");
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}
}
