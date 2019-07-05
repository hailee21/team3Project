package kr.or.ksmart.lms.institution.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.institution.vo.LectureFail;

@Mapper
public interface InstitutionLectureFailMapper {
	
	// 폐강 세부조회
	public LectureFail institutionSelectLectureFailByLectureFailCode(String lectureFailCode);

}
