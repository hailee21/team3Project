package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Board;
import kr.or.ksmart.lms.index.vo.IndexInstitution;

@Mapper
public interface PIBoardMapper {
	//	institution 코드
	public IndexInstitution selectInstitution(String institutionCode);
	//	Notice 리스트 출력
	public List<Board> getNotice(String institutionCode);
	//	Board 리스트 출력
	public List<Board> getBoard(String institutionCode);
	//	Q&A 리스트 출력
	public List<Board> getQnA(String institutionCode);
	//	FAQ 리스트 출력
	public List<Board> getFAQ(String institutionCode);
	//	Board 
	public void insertBoard(Board board);
}
