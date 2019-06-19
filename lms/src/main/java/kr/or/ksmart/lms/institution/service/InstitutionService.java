package kr.or.ksmart.lms.institution.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.institution.mapper.InstitutionMapper;
import kr.or.ksmart.lms.institution.vo.InfoAnnualFeeByPayment;

@Service
@Transactional
public class InstitutionService {
	@Autowired
	InstitutionMapper institutionMapper;

	public Map<String, Object> getPaymentAnnualFee() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");
		Date nowDate = new Date();
		Timestamp now = Timestamp.valueOf(dateFormat.format(nowDate));
		long today = now.getTime();
		long oneDay = (1000*60*60*24);
		long oneYearLater = today + (oneDay*365);
		Timestamp oneYearLaterDay = Timestamp.valueOf(dateFormat.format(oneYearLater));
		
		return institutionMapper.selectInfoAnnualFee();
	}
}
