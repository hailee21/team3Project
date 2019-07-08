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
import kr.or.ksmart.lms.association.vo.EvalByAssociation;
import kr.or.ksmart.lms.association.vo.EvalTotal;
import kr.or.ksmart.lms.association.vo.InfoEvalByAssociation;
import kr.or.ksmart.lms.association.vo.InsertEvalTotal;
import kr.or.ksmart.lms.association.vo.ModifyEvalByAssociation;

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

        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
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


        //평가 해야한 교육원들 수만큼 반복하여 교육원 평가 합계를 추가한다.
        for(String institutionCode: institutionCodeList) {
            int randomNo1 = (int)(Math.random()*10000);
            int randomNo2 = (int)(Math.random()*1000);
            int randomNo3 = (int)(Math.random()*100);
            int randomNo = randomNo1 + randomNo2 + randomNo3;
            if(randomNo >= 10000) {
                randomNo = randomNo/10;
            }
            InsertEvalTotal insert = new InsertEvalTotal();
            String evalTotalCode = "ET" + nowDate + randomNo;
            insert.setEvalTotalCode(evalTotalCode);
            insert.setInstitutionCode(institutionCode);
            insert.setEvalTotalType(insertEvalTotal.getEvalTotalType());
            insert.setEvalTotalYear(insertEvalTotal.getEvalTotalYear());

            //교육원 평가 합계 추가 mapper 호출
            associationEvaluationMapper.insertEvalTotal(insert);
		}
    }

    //교육원 평가 합계 출력 service
    public Map<String, Object> getEvalTotatList(Map<String, Object> map) {
        //입력조건에 따른 교육원 평가 합계 리스트 출력 mapper 호출
        List<EvalTotal> evalTotalList = associationEvaluationMapper.selectSerachEvalTotalList(map);
        
        //검색 조건 항목 service 호출
        Map<String, Object> serachKey = getEvaluationTotal();
        Map<String, Object> serachMap = new HashMap<String, Object>();
        int currentEvalPage = (int)map.get("currentEvalPage");
        final int ROW_PER_PAGE = 10;
		int beginRow = (currentEvalPage-1)*ROW_PER_PAGE;
		serachMap.put("beginRow", beginRow);
		serachMap.put("rowPerPage", ROW_PER_PAGE);
        List<EvalByAssociation> evalList = associationEvaluationMapper.selectEvalByAssociationList(serachMap);

        //페이징을 위한 데이터 처리
        int maxEvalCount = associationEvaluationMapper.selectEvalByAssociationConut();
        int currentTenEvalPage = currentEvalPage/10;
		if(currentEvalPage%10 == 0) {
			currentTenEvalPage--;
		}
		int lastEvalPage = maxEvalCount/ROW_PER_PAGE;
		if(maxEvalCount%ROW_PER_PAGE !=0) {
			lastEvalPage++;
		}
		int lastTenEvalPage = lastEvalPage/10;
		if(lastEvalPage%10 == 0) {
			lastTenEvalPage--;
		}
		int repetitionPage = 10;
		if((lastEvalPage - currentTenEvalPage*10) < 10) {
			repetitionPage = lastEvalPage % 10 ;
		}	
        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("evalTotalList", evalTotalList);
        returnMap.put("evalList", evalList);
        returnMap.put("currentEvalPage", currentEvalPage);
        returnMap.put("currentTenEvalPage", currentTenEvalPage);
        returnMap.put("lastEvalPage", lastEvalPage);
        returnMap.put("lastTenEvalPage", lastTenEvalPage);
        returnMap.put("repetitionPage", repetitionPage);
        returnMap.put("evalTotalType", serachKey.get("evalTotalType"));
        returnMap.put("evalTotalYear", serachKey.get("evalTotalYear"));
        return returnMap;
    }

    //교육원 평가 합계 차트 service
    public Map<String, Object> getEvalTotatChart(Map<String, Object> map) {
        //입력조건에 따른 교육원 평가 합계 리스트 출력 mapper 호출
        List<EvalTotal> evalTotalList = associationEvaluationMapper.selectSerachEvalTotalList(map);
        
        //컨트롤러로 리턴할 데이터 선언 및 설정
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("evalTotalList", evalTotalList);
        return returnMap;
    }

    //교육원 평가 합계 한개 출력 service
    public Map<String, Object> getEvalTotal(String evalTotalCode) {
        EvalTotal evalTotal = associationEvaluationMapper.selectEvalTotal(evalTotalCode);
        
        String infoEvalByAssociationSort = evalTotal.getEvalTotalType();
        List<InfoEvalByAssociation> infoEvalByAssociation = associationEvaluationMapper.selectInfoEvalByAssociationList(infoEvalByAssociationSort);
        
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("evalTotal", evalTotal);
        returnMap.put("infoEvalByAssociation", infoEvalByAssociation);
        return returnMap;
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
        String institutionCode = addEvalByAssociation.getInstitutionCode();
        List<String> infoEvalByAssociationCodeList = addEvalByAssociation.getInfoEvalByAssociationCode();
        List<Integer> evalByAssociationScoreList = addEvalByAssociation.getEvalByAssociationScore();
        
        //테이블의 PK를 위한 무작위 숫자 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//날짜
		Date now = new Date(); 
        String nowDate = dateFormat.format(now);
		nowDate = nowDate.substring(0, 13);
		nowDate = nowDate.toString().replace("-", "");
        nowDate = nowDate.toString().replace(" ", "");

        int sumScore = 0;
        for(int i=0; i<infoEvalByAssociationCodeList.size(); i++) {
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
            map.put("evalTotalCode",addEvalByAssociation.getEvalTotalCode() );
            map.put("institutionCode", institutionCode);
            map.put("evalTotalYear", addEvalByAssociation.getYear());
            map.put("infoEvalByAssociationCode", infoEvalByAssociationCodeList.get(i));
            map.put("evalByAssociationScore", evalByAssociationScoreList.get(i));
            map.put("evalByAssociationStartDate", addEvalByAssociation.getEvalByAssociationStartDate());
            map.put("evalByAssociationEndDate", addEvalByAssociation.getEvalByAssociationEndDate());
            map.put("evalByAssociationMonth", addEvalByAssociation.getEvalByAssociationMonth());
            map.put("evalByAssociationResultDate", addEvalByAssociation.getEvalByAssociationResultDate());
            sumScore = sumScore + evalByAssociationScoreList.get(i);
            //EvalByAssociation 테이블에 insert mapper 호출
            associationEvaluationMapper.insertEvalByAssociation(map);
        }
        //교육원 평가 합계 월별 점수 수정
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("evalTotalCode",addEvalByAssociation.getEvalTotalCode());
        map.put("evalByAssociationMonth", addEvalByAssociation.getEvalByAssociationMonth());
        map.put("sumScore", sumScore);
        associationEvaluationMapper.updateEvalTotalMonth(map);

        //교육원 평가 합계 총합 수정
        EvalTotal evalTotal = associationEvaluationMapper.selectEvalTotal(addEvalByAssociation.getEvalTotalCode());
        modifyEvalTotal(evalTotal);

    }
    
    //각 교육원 월별 평가 리스트 출력 service
    public List<EvalByAssociation> getEvalByAssociationListByInstitutionCodeAndMonth(Map<String, Object> map) {
        return associationEvaluationMapper.selectEvalByAssociationListByEvalTotalCodeAndMonth(map);
    }

    //교육원 평가 세부사항 수정 service
	public void modifyEvalByAssociationScore(ModifyEvalByAssociation modifyEvalByAssociation) {
        //ModifyEvalByAssociation의 변수 나누기
        List<String> evalByAssociationCodeList = modifyEvalByAssociation.getEvalByAssociationCode();
        List<Integer> evalByAssociationScoreList = modifyEvalByAssociation.getEvalByAssociationScore();
        String evalTotalCode = modifyEvalByAssociation.getEvalTotalCode();
        String evalByAssociationMonth = modifyEvalByAssociation.getEvalByAssociationMonth();
        int sumScore = 0;

        //mapper 호출을 위한 map 만들기
        int i = evalByAssociationCodeList.size();
        for(int a = 0; a<i; a++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("evalByAssociationCode", evalByAssociationCodeList.get(a));
            map.put("evalByAssociationScore", evalByAssociationScoreList.get(a));
            associationEvaluationMapper.updateEvalByAssociationScore(map);
            sumScore = sumScore+evalByAssociationScoreList.get(a);
        }

        //교육원 평가 합계 월별 점수 수정
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("evalTotalCode",evalTotalCode);
        map.put("evalByAssociationMonth", evalByAssociationMonth);
        map.put("sumScore", sumScore);
        associationEvaluationMapper.updateEvalTotalMonth(map);

        //교육원 평가 합계 총합 수정
        EvalTotal evalTotal = associationEvaluationMapper.selectEvalTotal(evalTotalCode);
        modifyEvalTotal(evalTotal);
	}
}
