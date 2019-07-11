package kr.or.ksmart.lms.pa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Board;

@Mapper
public interface PABoardMapper {
	//	Notice 리스트 출력
	public List<Board> getNotice(String institutionCode);
	//	Q&A 리스트 출력
	public List<Board> getQnA(String institutionCode);
	//	FAQ 리스트 출력
	public List<Board> getFAQ(String institutionCode);
	//	Board 상세보기
	public Board getBoardDetail(String board);
}
