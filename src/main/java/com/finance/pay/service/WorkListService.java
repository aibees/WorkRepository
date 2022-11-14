package com.finance.pay.service;

import com.finance.pay.vo.WorkListVo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkListService {

    public String getNewWorkCode() {
        String prefix = "NC";
        String ym = LocalDate.now().getYear() + Integer.toString(LocalDate.now().getMonthValue()+1);
        String seq = "004";

        return (prefix + ym + seq);
    }

    public WorkListVo getWorkDataById(String id) {
        // TODO : datasource connection

        if(id.equals("NC202211001")) {
            String desc = "전기차 충전시스템 재무연동 협의 및 대응업무\n" +
                    "\n" +
                    "- 진행내역\n" +
                    "  - 협의 내용\n" +
                    "    - 지불업체코드 I/F 관련\n" +
                    "      - 전기차 충전시스템에서 발생하는 사외영업비/매입채무데이터 I/F 시 CUSTCD 값이 필요하여 아이앤씨 지불시스템과의 업체코드 I/F 필요\n" +
                    "\n" +
                    "      - 초기 통합정보시스템에서 채번한 후 해당 업체코드 사용 예정이었으나, 지불시스템과 직접적인 I/F 하는 방식으로 진행할 예정\n" +
                    "        - 구매팀, 전기차충전사업팀, 재무시스템팀 각 팀장님 상호 합의 완료(2022.10.21)\n" +
                    "        - CUSTCD_TEMP 테이블 레이아웃 전달 완료(박준호 담당) \n" +
                    "\n" +
                    "        - 주의점\n" +
                    "          - SEQ 컬럼의 경우 I/F 시스템마다 대역대가 다름\n" +
                    "          - 통합정보시스템 : 1~999,999\n" +
                    "          - 스파로스 클래스 : 1,000,000 ~ 1,999,999 ( 21년도 말 업체코드 I/F 사용하고 싶다는 의견이 있어 위 대역대와 테이블 레이아웃 전달하였으나 이후 진전이 없어 잠정중단 )\n" +
                    "          - 전기차 충전시스템 : 2,000,000 ~ 2,999,999\n" +
                    "\n" +
                    "    - 매입채무 I/F 관련\n" +
                    "      - 매입채무 계정코드를 신규채번(3110214)\n" +
                    "        - 해당내용은 재무팀과 전기차충전사업팀에서 사전 협의 후 결론지어버린 건으로 개입 불가능했음.\n" +
                    "      \n" +
                    "    - 재무팀과 협의하여 매입채무 데이터는 재고(sw영업비) 방식으로 I/F 받기로 함\n" +
                    "        - AP9011T(매입전표), AP9031T(계산서)\n" +
                    "        - 해당 테이블들에 대한 테이블 레이아웃 전달 완료\n" +
                    "\n" +
                    "- 차후 대응방향\n" +
                    "  - 매입채무 계정코드 신규채번에 따라 거래구분값(TRADETP)을 신규생성해야할 것으로 보임\n" +
                    "  - 전기차 충전 사업팀 측에, 공수 및 테스트 기간이 많이 필요한 작업으로 충분한 내부협의 후 12월 안으로  세부일정 잡아 통보할 것이라는 의견 공유함.\n" +
                    "  - '로밍서비스'가 실제 오픈되어야 신규채번된 매입채무 데이터가 발생하는데, 올 해 안으로 오픈할 예정 없음(대략 내년 1~2분기 가닥)\n" +
                    "  - 신규 거래구분 값 추가에 따른 지불/지급이관 로직 검토 및 수정 필요";

            LocalDate fr = LocalDate.parse("20221121", DateTimeFormatter.ofPattern("yyyyMMdd"));
            LocalDate to = LocalDate.parse("20221210", DateTimeFormatter.ofPattern("yyyyMMdd"));
            return new WorkListVo("NC202211001", "업무인수인계", fr, to, "99", "00", "0", "", desc, "Finance Dev1", "");

        } else if(id.equals("NC202211002")) {
            String desc = "○ 한자테스트 韓字";
            LocalDate fr = LocalDate.parse("20221130", DateTimeFormatter.ofPattern("yyyyMMdd"));
            LocalDate to = LocalDate.parse("20221225", DateTimeFormatter.ofPattern("yyyyMMdd"));
            return new WorkListVo("NC202211002", "SSL 갱신작업", fr, to, "21", "08", "4", "매주 화요일", desc, "재무팀", "Finance Dev1, 2, Finance Prod1, 2");
        } else {
            return new WorkListVo();
        }
    }

    public int deleteWorkDataById(String id) {
        int result = -1;

        System.out.println("Delete service : " + id);

        return result;
    }
}
