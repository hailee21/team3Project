package kr.or.ksmart.lms.association.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationEvaluationMapper;
import kr.or.ksmart.lms.association.vo.EvalTotal;
import kr.or.ksmart.lms.association.vo.InsertEvalTotal;

@Service
@Transactional
public class AssociationEvaluationService {
    @Autowired
    AssociationEvaluationMapper associationEvaluationMapper;

    //교육원 평가 항목 추가 액션 service
    public void addEvaluationTotal(InsertEvalTotal insertEvalTotal) {
        //평가를 해야하는 교육원들의 교육원 코드 출력 mapper 호출
        List<String> institutionCodeList = associationEvaluationMapper.selectInstitutionCodeList();
        
        //교육원 평가 합계의 PK를 출력한다.
        String evalTotalPK = associationEvaluationMapper.selectEvalTotalPK();
        int lastNo = 0;
		if(evalTotalPK == null){
			//refund_annual_fee 테이블에 아무 데이터가 없으면 lastNo는 1이 된다.
			lastNo = 0;	
		} else {
			lastNo = Integer.parseInt(evalTotalPK.substring(2)); //가져온 PK 값에서 문자를 제외한 숫자값을 얻는다.
		}
        lastNo++;

        //평가 해야한 교육원들 수만큼 반복하여 교육원 평가 합계를 추가한다.
        for(String institutionCode: institutionCodeList) {
            InsertEvalTotal insert = new InsertEvalTotal();
            String evalTotalCode = "ET" + lastNo;
            insert.setEvalTotalCode(evalTotalCode);
            insert.setInstitutionCode(institutionCode);
            insert.setEvalTotalType(insertEvalTotal.getEvalTotalType());
            insert.setEvalTotalYear(insertEvalTotal.getEvalTotalYear());

            //교육원 평가 합계 추가 mapper 호출
            associationEvaluationMapper.insertEvalTotal(insert);

            //추가하면 lastNo에 1을더하여 PK가 중복되지 않도록 한다.
            lastNo++;
		}
    }

    //교육원 평가 합계 비동기 출력 service
    public Map<String, Object> getEvalTotatListRest(int evalTotalYear) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<EvalTotal> evalTotalList  = associationEvaluationMapper.selectEvalTotalList(evalTotalYear);
        map.put("evalTotalList", evalTotalList);
        return map;
    }
}
