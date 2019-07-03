package kr.or.ksmart.lms.association.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.lms.association.mapper.AssociationEvaluationMapper;
import kr.or.ksmart.lms.association.vo.AddEvalByAssociation;
import kr.or.ksmart.lms.association.vo.EvalTotal;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InsertEvalTotal;

@Service
@Transactional
public class AssociationEvaluationService {
    @Autowired
    AssociationEvaluationMapper associationEvaluationMapper;

    //교육원 평가 합계 리스트 출력 service
	public Map<String, Object> getEvaluationTotal() {
        //검색 조건 항목 mapper 호출
        List<String> evalTotalType = associationEvaluationMapper.selectEvalTotalType();
        List<Integer> evalTotalYear = associationEvaluationMapper.selectEvalTotalYear();
        
        //전체 리스트 mapper 호출
        List<EvalTotal> evalTotalList = associationEvaluationMapper.selectEvalTotalList();
        
        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("evalTotalList", evalTotalList);
        returnMap.put("evalTotalType", evalTotalType);
        returnMap.put("evalTotalYear", evalTotalYear);
		return returnMap;
	}

    //교육원 평가 항목 추가 액션 service
    public void addEvaluationTotal(InsertEvalTotal insertEvalTotal) {
        //평가를 해야하는 교육원들의 교육원 코드 출력 mapper 호출
        List<String> institutionCodeList = associationEvaluationMapper.selectInstitutionCodeList();
        
        //테이블의 PK를 위한 무작위 숫자 생성
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
		if(randomNo >= 10000) {
			randomNo = randomNo/10;
		}

        //평가 해야한 교육원들 수만큼 반복하여 교육원 평가 합계를 추가한다.
        for(String institutionCode: institutionCodeList) {
            InsertEvalTotal insert = new InsertEvalTotal();
            String evalTotalCode = "ET" + nowDate + randomNo;
            insert.setEvalTotalCode(evalTotalCode);
            insert.setInstitutionCode(institutionCode);
            insert.setEvalTotalType(insertEvalTotal.getEvalTotalType());
            insert.setEvalTotalYear(insertEvalTotal.getEvalTotalYear());

            //교육원 평가 합계 추가 mapper 호출
            associationEvaluationMapper.insertEvalTotal(insert);

            //추가하면 lastNo에 1을더하여 PK가 중복되지 않도록 한다.
            randomNo++;
		}
    }

    //교육원 평가 합계 출력 service
    public Map<String, Object> getEvalTotatList(Map<String, Object> map) {
        System.out.println(map);
        String evalTotalYear = ""+map.get("evalTotalYear");
        if(evalTotalYear.equals("0")){
            evalTotalYear = "%%";
            map.put("evalTotalYear", evalTotalYear);
        }
    	//입력조건에 따른 교육원 평가 합계 리스트 출력 mapper 호출
        List<EvalTotal> evalTotalList = associationEvaluationMapper.selectSerachEvalTotalList(map);
        
        //검색 조건 항목 service 호출
        Map<String, Object> serachKey = getEvaluationTotal();

        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("evalTotalList", evalTotalList);
        returnMap.put("evalTotalType", serachKey.get("evalTotalType"));
        returnMap.put("evalTotalYear", serachKey.get("evalTotalYear"));
        return returnMap;
    }

    //교육원 평가 합계 한개 출력 service
    public EvalTotal getEvalTotal(String evalTotalCode) {
        return associationEvaluationMapper.selectEvalTotal(evalTotalCode);
    }

    //교육원 평가 합계 update service
    public void modifyEvalTotal(EvalTotal evalTotal) {
        //전체 점수 합 구하기
        int evalTotalJan = evalTotal.getEvalTotalJan();
        int evalTotalFed = evalTotal.getEvalTotalFeb();
        int evalTotalMar = evalTotal.getEvalTotalMar();
        int evalTotalApr = evalTotal.getEvalTotalApr();
        int evalTotalMay = evalTotal.getEvalTotalMay();
        int evalTotalJun = evalTotal.getEvalTotalJun();
        int evalTotalJul = evalTotal.getEvalTotalJul();
        int evalTotalAug = evalTotal.getEvalTotalAug();
        int evalTotalSep = evalTotal.getEvalTotalSep();
        int evalTotalOct = evalTotal.getEvalTotalOct();
        int evalTotalNov = evalTotal.getEvalTotalNov();
        int evalTotalDec = evalTotal.getEvalTotalDec();
        int evalTotalSumScore = evalTotalJan + evalTotalFed + evalTotalMar + evalTotalApr + evalTotalMay + evalTotalJun + evalTotalJul + evalTotalAug + evalTotalSep + evalTotalOct + evalTotalNov + evalTotalDec;   
        evalTotal.setEvalTotalSumScore(evalTotalSumScore);
        System.out.println(evalTotalSumScore);
        System.out.println(evalTotal);
        //mapper 호출
        associationEvaluationMapper.updateEvalTotal(evalTotal);
    }

    //교육원 평가 항목 추가 폼 service
	public Map<String, Object> getEvaluationTotalAddForm() {
        //교육원 평가 항목 리스트 mapper 호출
        List<String> sortList = associationEvaluationMapper.selectInfoEvalByAssociationSortList();

        //교육원 평가 년도 선택 리스트 생성
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
        String nowDate = dateFormat.format(now);
        nowDate = nowDate.substring(0, 4);
        int startYear = Integer.parseInt(nowDate);
        startYear = startYear - 2;
        List<Integer> yearList = new ArrayList<Integer>();
        for(int i = 0; i<12; i++) {
            int year = startYear + i;
            yearList.add(year);
            System.out.println(year);
        }

        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("sortList", sortList);
        returnMap.put("yearList", yearList);
        return returnMap;
    }
    
    //평가 항목 상세 추가 폼 출력 service
	public Map<String, Object> addEvalByAssociationForm() {
        //평가 총합에서 년도 가져오기
        List<Integer> yearList = associationEvaluationMapper.selectEvalTotalYear();

        //평가 항목 가져오기
        List<String> sortList = associationEvaluationMapper.selectInfoEvalByAssociationSortList();

        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("yearList", yearList);
        returnMap.put("sortList", sortList);
        return returnMap;
    }
    
    //평가 항목 상세 분류에 따른 내용 출력 service
    public List<InfoEvalByAssociation> getInfoEvalByAssociation(String infoEvalByAssociationSort) {
        return associationEvaluationMapper.selectInfoEvalByAssociationList(infoEvalByAssociationSort);
    }

    //년도에 따른 평가 대상 교육원 코드와 이름 출력 service
    public List<EvalTotal> getInstitutionNameInEvalTotal(int evalTotalYear) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("evalTotalYear", evalTotalYear);

        return associationEvaluationMapper.selectEvalTotalByYear(map);
    }

    //평가 항목 상세 추가 액션 service
	public void addEvalByAssociation(AddEvalByAssociation addEvalByAssociation) {
        //AddEvalByAssociation에서 리스트 분리하기 
        List<String> institutionCodeList = addEvalByAssociation.getInstitutionCode();
        List<String> infoEvalByAssociationCodeList = addEvalByAssociation.getInfoEvalByAssociationCode();

        //테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
        String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
        nowDate = nowDate.toString().replace(" ", "");
        for(String institutionCode: institutionCodeList) {
            for(String infoEvalByAssociationCode: infoEvalByAssociationCodeList) {
                Map<String, Object> map = new HashMap<String, Object>();
                //테이블의 PK를 위한 무작위 숫자 생성
                int randomNo1 = (int)(Math.random()*10000);
                int randomNo2 = (int)(Math.random()*1000);
                int randomNo3 = (int)(Math.random()*100);
                int randomNo = randomNo1 + randomNo2 + randomNo3;
                if(randomNo >= 10000) {
                    randomNo = randomNo/10;
                }
                String evalByAssociationCode = "EA" + nowDate + randomNo;

                //map에 담아서 교육원 평가 항목을 추가한다.
                map.put("evalByAssociationCode", evalByAssociationCode);
                map.put("institutionCode", institutionCode);
                map.put("infoEvalByAssociationSort", addEvalByAssociation.getInfoEvalByAssociationSort());
                map.put("evalTotalYear", addEvalByAssociation.getYear());
                map.put("infoEvalByAssociationCode", infoEvalByAssociationCode);
                map.put("evalByAssociationScore", addEvalByAssociation.getEvalByAssociationScore());
                map.put("evalByAssociationStartDate", addEvalByAssociation.getEvalByAssociationStartDate());
                map.put("evalByAssociationEndDate", addEvalByAssociation.getEvalByAssociationEndDate());
                map.put("evalByAssociationResultDate", addEvalByAssociation.getEvalByAssociationResultDate());

                associationEvaluationMapper.insertEvalByAssociation(map);
            }
        }
	}
}
