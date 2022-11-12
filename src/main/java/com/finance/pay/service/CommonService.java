package com.finance.pay.service;

import com.finance.pay.vo.common.RepeatStatus;
import com.finance.pay.vo.common.WorkType;

import java.util.ArrayList;
import java.util.List;

public class CommonService {

    /**
     * repeat combo
     */
    public RepeatStatus[] getRepeatComboList() {
        List<RepeatStatus> result = new ArrayList<>();

        // TODO : MYBATIS Connection

        result.add(new RepeatStatus("0", "반복없음"));
        result.add(new RepeatStatus("1", "비규칙적"));
        result.add(new RepeatStatus("2", "주"));
        result.add(new RepeatStatus("3", "월"));
        result.add(new RepeatStatus("4", "년"));
        result.add(new RepeatStatus("5", "특정주기"));

        return result.toArray(new RepeatStatus[result.size()]);
    }

    public RepeatStatus getRepeatStatusById(String id) {
        // TODO : MYBATIS Connection
        RepeatStatus status = new RepeatStatus(id, (id.equals("0"))?"반복없음":"비반복적");
        return status;
    }

    /**
     * worktype combo
     */
    public WorkType[] getWorktypeComboList() {
        List<WorkType> result = new ArrayList<>();

        // TODO : Same with repeat

        result.add(new WorkType("00", "운영-단순가이드"));
        result.add(new WorkType("01", "운영-데이터확인"));
        result.add(new WorkType("02", "운영-데이터추출"));
        result.add(new WorkType("10", "개발-APP"));
        result.add(new WorkType("11", "개발-OS"));
        result.add(new WorkType("13", "개발-DDL/DML(Only)"));
        result.add(new WorkType("14", "개발-DB기타"));
        result.add(new WorkType("20", "반복-기안"));
        result.add(new WorkType("21", "반복-설정"));
        result.add(new WorkType("99", "기타"));

        return result.toArray(new WorkType[result.size()]);
    }


}
