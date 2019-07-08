package kr.or.ksmart.lms.pi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		board.setBoardNo(boardNo);	//Member VO 내 memberCode set
		
		//	session에서 회원 정보 가져오기
		String memberOnlineCode = (String)session.getAttribute("memberOnlineCode");
		String memberOnlineId = (String)session.getAttribute("memberOnlineId");
		String memberName = (String)session.getAttribute("memberName");
		String institutionName = (String)session.getAttribute("institutionName");
		board.setMemberOnlineCode(memberOnlineCode);
		board.setMemberOnlineId(memberOnlineId);
		board.setMemberName(memberName);
		board.setInstitutionName(institutionName);
		System.out.println(board.getBoardTitle());
		
		piBoardMapper.insertBoard(board);
	}
}
