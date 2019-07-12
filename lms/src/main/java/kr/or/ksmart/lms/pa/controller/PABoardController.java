package kr.or.ksmart.lms.pa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.pa.service.PABoardService;

@Controller
public class PABoardController {
	@Autowired private PABoardService paBoardService;
	
	//	협회 홈페이지 공지사항 view
	@GetMapping("/PANotice")
	public ModelAndView getNoticeByPA (HttpSession session, ModelAndView mav) {
		//	리스트 출력
		String institutionCode = (String)session.getAttribute("institutionCode");
		List<Board> board = paBoardService.getNoticeList(institutionCode);
		mav.addObject("board", board);
		mav.setViewName("PA/Board/listPaNotice");
		return mav;
	}
	//	협회 홈페이지 QnA view
	@GetMapping("/PAQnA")
	public ModelAndView getQnAListByPA(HttpSession session, ModelAndView mav) {
		//	리스트 출력
		String institutionCode = (String)session.getAttribute("institutionCode");
		List<Board> board = paBoardService.getQnAList(institutionCode);
		mav.addObject("board", board);
		mav.setViewName("PA/Board/listPaQnA");
		return mav;
	}
	//	협회 홈페이지 FAQ view
	@GetMapping("/PAFAQ")
	public ModelAndView getFAQListByPA(HttpSession session, ModelAndView mav) {
		//	리스트 출력
		String institutionCode = (String)session.getAttribute("institutionCode");
		List<Board> board = paBoardService.getFAQList(institutionCode);
		mav.addObject("board", board);
		mav.setViewName("PA/Board/listPaFAQ");
		return mav;
	}
	//	협회 홈페이지 공지사항 글쓰기 화면 get요청
	@GetMapping("/PANoticeWrite")
	public ModelAndView paNoticeWrite (HttpSession session, ModelAndView mav) {
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PABoardController paNoticeWrite] 로그아웃상태");
			mav.setViewName("redirect:/PALogin");
		} else if (memberName != null) {
			mav.setViewName("PA/Board/addPaNotice");
		}
		return mav;
	}
	//	협회 홈페이지 Q&A 글쓰기 화면 get요청
	@GetMapping("/PAqnaWrite")
	public ModelAndView paQnaWrite (HttpSession session, ModelAndView mav) {
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PABoardController paQnaWrite] 로그아웃상태");
			mav.setViewName("redirect:/PALogin");
		} else if (memberName != null) {
			mav.setViewName("PA/Board/addPaQnA");
		}
		return mav;
	}
	//	협회 홈페이지 faq 글쓰기 화면 get요청
	@GetMapping("/PAFaqWrite")
	public ModelAndView paFaqWrite (HttpSession session, ModelAndView mav) {
		String memberName = (String)session.getAttribute("memberName");
		if (memberName == null) {
			System.out.println("[PABoardController paFaqWrite] 로그아웃상태");
			mav.setViewName("redirect:/PALogin");
		} else if (memberName != null) {
			mav.setViewName("PA/Board/addPaFAQ");
		}
		return mav;
	}
	//	협회 홈페이지 게시글 상세보기
	@GetMapping("/PABoardDetail")
	public ModelAndView boardDetailView (HttpSession session, ModelAndView mav
			,@RequestParam(value="boardNo", required = true) String boardNo) {
		Map<String, Object> map = paBoardService.boardDetailView(boardNo);
		mav.addObject("board", map.get("board"));
		mav.addObject("boardCommentList", map.get("boardCommentList"));
		mav.setViewName("PA/Board/detailPaBoard");
		return mav;
	}
}
