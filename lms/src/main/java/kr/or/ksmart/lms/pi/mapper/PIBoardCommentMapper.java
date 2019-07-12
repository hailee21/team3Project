package kr.or.ksmart.lms.pi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.BoardComment;

@Mapper
public interface PIBoardCommentMapper {
	//	게시글에서 BoardComment List 출력
	public List<BoardComment> selectBoardCommentListByBoardNo(String boardNo);
	//	BoardComment insert
	public void insertBoardComment(BoardComment boardComment);
}
