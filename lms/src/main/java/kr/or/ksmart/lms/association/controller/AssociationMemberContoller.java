package kr.or.ksmart.lms.association.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationMemberService;
import kr.or.ksmart.lms.association.vo.MemberInstitution;
import kr.or.ksmart.lms.pi.vo.Member;
import kr.or.ksmart.lms.pi.vo.MemberOnline;

@Controller
public class AssociationMemberContoller {
	@Autowired private AssociationMemberService associationMemberService;
	
	//	협회 직원 등록화면 get요청
	@GetMapping("/insertAssociationAdmin")
	public ModelAndView insertInstAdmin (ModelAndView mav) {
		mav.setViewName("association/member/insertAssociationAdmin");
		return mav;
	}
	//	직원 등록 처리(협회직원/교육원직원)
	@PostMapping("/insertAdmin")
	public ModelAndView insertAdmin(ModelAndView mav, Member member, MemberOnline memberOnline, MemberInstitution memberInstitution
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		System.out.println("[AssociationMemberController insertAdmin] member:" + member);
		associationMemberService.insertAdmin(member, memberOnline, memberInstitution, institutionCode);
		if(member.getMemberRank()=="협회직원") { // 협회직원이면
			mav.setViewName("redirect:/associationLogin");	// 처리 후 협회 로그인 바로가기
		} else if(member.getMemberRank()=="교육원직원") { // 교육원직원이면
			mav.setViewName("redirect:/institutionLogin");	// 처리 후 교육원 로그인 바로가기
		}
		return mav;
	}
}
