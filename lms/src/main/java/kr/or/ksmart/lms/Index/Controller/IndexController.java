package kr.or.ksmart.lms.Index.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.Index.Mapper.IndexMapper;
import kr.or.ksmart.lms.Index.VO.InfoSubject;

@Controller
public class IndexController {
	@Autowired
	IndexMapper indexMapper;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		List<InfoSubject> list = indexMapper.selectInfoSubjectList();
		mav.addObject("list", list);
		return mav;
	}
}
