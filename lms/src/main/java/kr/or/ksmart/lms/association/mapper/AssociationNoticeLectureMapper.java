package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import kr.or.ksmart.lms.association.vo.NoticeLecture;

public interface AssociationNoticeLectureMapper {
	
	// 강의공고 목록 출력
	public List<NoticeLecture>associationSelectNoticeLectureList();
	
	// 세부 강의공고 조회
	public NoticeLecture associationSelectNoticeLectureByNoticeLectureCode(String NoticeLectureCode);
}
