package kr.or.ksmart.lms.pa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.pa.mapper.PABoardMapper;

@Service
@Transactional
public class PABoardService {
	@Autowired private PABoardMapper paBoardMapper;
	
	//	협회 홈페이지 공지사항 list view
	public List<Board> getNoticeList(String institutionCode) {
		List<Board> board = paBoardMapper.getNotice(institutionCode);
		return board;
	}
	//	협회 홈페이지 Q&A list view
	public List<Board> getQnAList(String institutionCode) {
		List<Board> board = paBoardMapper.getQnA(institutionCode);
		return board;
	}
	//	협회 홈페이지 FAQ list view
	public List<Board> getFAQList(String institutionCode) {
		List<Board> board = paBoardMapper.getFAQ(institutionCode);
		return board;
	}
	//	게시글 보기
	public Map<String, Object> boardDetailView(String boardNo) {
		Board board = paBoardMapper.getBoardDetail(boardNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		return map;
	}
}
