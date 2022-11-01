package com.finance.pay.service;

import com.finance.vo.WorkListVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkListService {

    public WorkListVo getWorkDataById(String id) {
        // TODO : datasource connection

        if(id.equals("NC202211001")) {
            LocalDate fr = LocalDate.parse("20221121", DateTimeFormatter.ofPattern("yyyyMMdd"));
            LocalDate to = LocalDate.parse("20221210", DateTimeFormatter.ofPattern("yyyyMMdd"));
            return new WorkListVo("NC202211001", "업무인수인계", fr, to);
        } else if(id.equals("NC202211002")) {
            LocalDate fr = LocalDate.parse("20221130", DateTimeFormatter.ofPattern("yyyyMMdd"));
            LocalDate to = LocalDate.parse("20221225", DateTimeFormatter.ofPattern("yyyyMMdd"));
            return new WorkListVo("NC202211002", "[개발]채권양도로직 리팩토링", fr, to);
        } else {
            return new WorkListVo();
        }
    }
}
