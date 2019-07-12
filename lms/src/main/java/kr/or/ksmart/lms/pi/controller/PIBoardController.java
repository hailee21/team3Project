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

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.service.PIBoardService;

@Controller
public class PIBoardController {
	@Autowired private PIBoardService piBoardService;
	//	교육원홈페이지 공지사항 view
	@GetMapping("/PINotice")
	public ModelAndView getNoticeByPI (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		//	institutionCode 가져오기
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		//	리스트 출력
		List<Board> noticeList = piBoardService.getNoticeList(institutionCode);
		mav.addObject("noticeList", noticeList);
		mav.setViewName("PI/Board/listPiNotice");
		return mav;
	}
	//	교육원/협회 공지사항 글쓰기 화면 get요청
	@GetMapping("/PINoticeWrite")
	public ModelAndView piWriteNotice (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberRank = (String)session.getAttribute("memberRank");
		if (memberRank == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberRank != null) {
			mav.setViewName("PI/Board/addPiNotice");
		}
		return mav;
	}
	//	교육원홈페이지 view
	@GetMapping("/PIBoard")
	public ModelAndView getBoardByPI (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		List<Board> boardList = piBoardService.getBoardList(institutionCode);
		mav.addObject("boardList", boardList);
		mav.setViewName("PI/Board/listPiBoard");
		return mav;
	}
	//	교육원홈페이지 글쓰기 화면 get요청
	@GetMapping("/PIBoardWrite")
	public ModelAndView piWriteBoard (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PIBoardController piWriteBoard] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberName != null) {
			mav.setViewName("PI/Board/addPiBoard");
		}
		return mav;
	}
	//	교육원홈페이지 글쓰기 처리 POST 요청
	@PostMapping("/addBoard")
	public ModelAndView addBoard (Board board, HttpSession session, ModelAndView mav) {
		System.out.println("[PIBoardController addBoard] 글등록 처리요청");
		piBoardService.addBoard(board, session);
		String instCode=(String)session.getAttribute("institutionCode");
		if (instCode.equals("I20120101000000")) {
			if (board.getBoardType().equals("공지사항")) {
				mav.setViewName("redirect:/PANotice");
			} else if (board.getBoardType().equals("커뮤니티")) {
				mav.setViewName("redirect:/PIBoard");
			} else if (board.getBoardType().equals("QnA")) {
				mav.setViewName("redirect:/PIQnA");
			} else if (board.getBoardType().equals("FAQ")) {
				mav.setViewName("redirect:/PIFAQ");
			}
		} else {
			if (board.getBoardType().equals("공지사항")) {
				mav.setViewName("redirect:/PINotice?institutionCode="+instCode);
			} else if (board.getBoardType().equals("커뮤니티")) {
				mav.setViewName("redirect:/PIBoard?institutionCode="+instCode);
			} else if (board.getBoardType().equals("QnA")) {
				mav.setViewName("redirect:/PIQnA?institutionCode="+instCode);
			} else if (board.getBoardType().equals("FAQ")) {
				mav.setViewName("redirect:/PIFAQ?institutionCode="+instCode);
			}
		}
		return mav;
	}
	
	//	교육원홈페이지 질의응답 view
	@GetMapping("/PIQnA")
	public ModelAndView getBoardByPIQnA (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		//	리스트 출력
		List<Board> QnAList = piBoardService.getQnAList(institutionCode);
		mav.addObject("QnAList", QnAList);
		mav.setViewName("PI/Board/listPiQnA");
		return mav;
	}
	@GetMapping("/PIqnaWrite")
	public ModelAndView piWriteQna (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberName != null) {
			mav.setViewName("PI/Board/addPiQna");
		}
		return mav;
	}
	//	교육원홈페이지 자주하는질문 view
	@GetMapping("/PIFAQ")
	public ModelAndView getBoardByPIFAQ (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		//	리스트 출력
		List<Board> FAQList = piBoardService.getFAQList(institutionCode);
		mav.addObject("FAQList", FAQList);
		mav.setViewName("PI/Board/listPiFAQ");
		return mav;
	}
	@GetMapping("/PIFaqWrite")
	public ModelAndView piWriteFaq (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode) {
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		String memberRank = (String)session.getAttribute("memberName");
		if (memberRank == null) {
			System.out.println("[PIMemberController memberInfoModify] 로그아웃상태");
			mav.setViewName("redirect:/PILogin?"+institutionCode);
		} else if (memberRank != null) {
			mav.setViewName("PI/Board/addPiFaq");
		}
		return mav;
	}
	//	교육원 글 상세보기
	@GetMapping("/PIBoardDetail")
	public ModelAndView boardDetailView (HttpSession session, ModelAndView mav
			, @RequestParam(value="institutionCode", required = true) String institutionCode,
			@RequestParam(value="boardNo", required = true) String boardNo) {
		System.out.println("boardDetailView 호출");
		IndexInstitution institution = piBoardService.PIIndex(institutionCode);
		mav.addObject("institutionCode", institution.getInstitutionCode());
		mav.addObject("institutionName", institution.getInstitutionName());
		Map<String, Object> map = piBoardService.boardDetailView(boardNo);
		mav.addObject("board", map.get("board"));
		mav.addObject("boardCommentList", map.get("boardCommentList"));
		mav.setViewName("PI/Board/detailPiBoard");
		return mav;
	}
	
}
