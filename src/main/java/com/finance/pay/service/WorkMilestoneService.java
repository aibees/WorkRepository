package com.finance.pay.service;

import com.finance.vo.WorkMilestoneVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkMilestoneService {

    public List<WorkMilestoneVo> getMilestoneList() {
        List<WorkMilestoneVo> list = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate_today = LocalDate.now();
        String today = localDate_today.format(format);

        System.out.println("today : " + today);

        WorkMilestoneVo vo_Test = new WorkMilestoneVo("TEST_", "20221020", "20221115", "255_255_255");
        list.add(vo_Test);
        WorkMilestoneVo vo_Test_under = new WorkMilestoneVo("\t→ TEST_under1", "20221020", "20221030", "255_255_255");
        list.add(vo_Test_under);
        WorkMilestoneVo vo_Test_under1 = new WorkMilestoneVo("\t→ TEST_under2", "20221028", "20221113", "255_255_255");
        list.add(vo_Test_under1);

        return list;
    }
}
