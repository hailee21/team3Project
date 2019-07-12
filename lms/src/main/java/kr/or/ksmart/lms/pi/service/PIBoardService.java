package kr.or.ksmart.lms.pi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.association.vo.BoardComment;
import kr.or.ksmart.lms.index.vo.IndexInstitution;
import kr.or.ksmart.lms.pi.mapper.PIBoardCommentMapper;
import kr.or.ksmart.lms.pi.mapper.PIBoardMapper;

@Service
@Transactional
public class PIBoardService {
	@Autowired private PIBoardMapper piBoardMapper;
	@Autowired private PIBoardCommentMapper piBoardCommentMapper;
	
	public IndexInstitution PIIndex(String institutionCode) {
		return piBoardMapper.selectInstitution(institutionCode);
	}
	//	게시판 Notice 리스트 출력
	public List<Board> getNoticeList(String institutionCode) {
		List<Board> board = piBoardMapper.getNotice(institutionCode);
		return board;
	}
	//	게시판 Board 리스트 출력
	public List<Board> getBoardList(String institutionCode) {
		List<Board> board = piBoardMapper.getBoard(institutionCode);
		return board;
	}
	//	게시판 Q&A 리스트 출력
	public List<Board> getQnAList(String institutionCode) {
		List<Board> board = piBoardMapper.getQnA(institutionCode);
		return board;
	}
	//	게시판 FAQ 리스트 출력
	public List<Board> getFAQList(String institutionCode) {
		List<Board> board = piBoardMapper.getFAQ(institutionCode);
		return board;
	}
	//	게시판 view 보기
	public Map<String, Object> boardDetailView(String boardNo){
		System.out.println("boardDetailView 호출");
		Board board = piBoardMapper.getBoardDetail(boardNo);
		System.out.println(board);
		List<BoardComment> boardCommentList = piBoardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		System.out.println(boardCommentList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);
		return map;
	}
	public void addBoard(Board board, HttpSession session) {
		System.out.println("[PIBoardService addBoard] Service 호출");
		//	board 테이블에 insert 준비. boardNo 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String boardNo="B"+nowDate+randomNo;
		board.setBoardNo(boardNo);	//Board VO 내 BoardNo set
		
		//	session에서 회원 정보 가져오기
		System.out.println("[PIBoardService addBoard session 정보 확인]"+session);
		String memberOnlineId = (String)session.getAttribute("memberOnlineId");
		String memberName = (String)session.getAttribute("memberName");
		String institutionCode = (String)session.getAttribute("institutionCode");
		String institutionName = (String)session.getAttribute("institutionName");
		board.setMemberOnlineId(memberOnlineId);
		board.setMemberName(memberName);
		board.setInstitutionCode(institutionCode);
		board.setInstitutionName(institutionName);
		System.out.println();
		
		piBoardMapper.insertBoard(board);
	}
	public void addComment(BoardComment comment, HttpSession session) {
		System.out.println("[PIBoardService addComment] 호출");
		//	boardComment 테이블에 insert 준비. boardCommentNo 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
		String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
		nowDate = nowDate.toString().replace(" ", "");
		System.out.println(nowDate);
		int randomNo1 = (int)(Math.random()*10000);
		int randomNo2 = (int)(Math.random()*1000);
		int randomNo3 = (int)(Math.random()*100);
		int randomNo = randomNo1 + randomNo2 + randomNo3;
		if(randomNo > 10000) {
			randomNo = randomNo/10;
		}
		String boardCommentNo="C"+nowDate+randomNo;
		comment.setBoardCommentNo(boardCommentNo);	//BoardComment VO 내 boardCommentNo set
		
		//	session에서 회원 정보 가져오기
		System.out.println("[PIBoardService addBoard session 정보 확인]"+session);
		String memberOnlineId = (String)session.getAttribute("memberOnlineId");
		String memberName = (String)session.getAttribute("memberName");
		
		comment.setMemberOnlineId(memberOnlineId);
		comment.setMemberName(memberName);
		System.out.println();
		
		piBoardCommentMapper.insertBoardComment(comment);
	}
}
