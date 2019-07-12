package kr.or.ksmart.lms.pi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.vo.BoardComment;
import kr.or.ksmart.lms.pi.service.PIBoardService;

@RestController
public class PIBoardCommentRestController {
	@Autowired	private PIBoardService piBoardService;
	
	//	댓글 등록
	@PostMapping("/addComment")
	public void addComment (BoardComment comment, HttpSession session, ModelAndView mav) {
		System.out.println("[PIBoardCommentRestController addComment] 댓글등록 처리요청");
		piBoardService.addComment(comment, session);
	}
}
