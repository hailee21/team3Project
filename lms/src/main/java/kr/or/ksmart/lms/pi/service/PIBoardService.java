package kr.or.ksmart.lms.pi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.mapper.PIBoardMapper;

@Service
public class PIBoardService {
	@Autowired private PIBoardMapper piBoardMapper;
	
	public IndexInstitution PIIndex(String institutionCode) {
		return piBoardMapper.selectInstitution(institutionCode);
	}
	//	게시판 Board 리스트 출력
	public List<Board> getBoardList() {
		List<Board> board = piBoardMapper.getBoard();
		return board;
	}
	public void addBoard(Board board, HttpSession session, String institutionCode) {
		System.out.println("[PIBoardService addBoard] Service 호출");
		String memberOnlineCode = (String)session.getAttribute("memberOnlineCode");
		String memberOnlineId = (String)session.getAttribute("memberOnlineId");
		String memberName = (String)session.getAttribute("memberName");
		String instCode = (String)session.getAttribute("institutionCode");
		String institutionName = (String)session.getAttribute("institutionName");
		board.setMemberOnlineCode(memberOnlineCode);
		board.setMemberOnlineId(memberOnlineId);
		board.setMemberName(memberName);
		board.setInstitutionCode(instCode);
		board.setInstitutionName(institutionName);
		System.out.println(board.getBoardTitle());
		
		piBoardMapper.insertBoard(board);
	}
}
