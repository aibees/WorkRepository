package com.finance.pay.service;

import com.finance.pay.vo.common.RepeatStatus;
import com.finance.pay.vo.common.WorkStatus;
import com.finance.pay.vo.common.WorkType;
import com.finance.util.database.ConnClient;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CommonService {

    /**
     * repeat combo
     */
    public RepeatStatus[] getRepeatComboList() {
        SqlSession db = ConnClient.getSession();
        List<RepeatStatus> result = db.selectList("common.getRepeatStatusList");
        return result.toArray(new RepeatStatus[result.size()]);
    }

    public RepeatStatus getRepeatStatusById(String id) {
        return ConnClient.getSession().selectOne("common.getRepeatStatusById", id);
    }

    /**
     * worktype combo
     */
    public WorkType[] getWorktypeComboList() {
        SqlSession db = ConnClient.getSession();
        List<WorkType> result = db.selectList("common.getWorkTypeList");
        return result.toArray(new WorkType[result.size()]);
    }

    public WorkType getWorktypeById(String id) {
        return ConnClient.getSession().selectOne("common.getWorkTypeById", id);
    }

    /**
     * workstatus combo
     */
    public WorkStatus[] getWorkStatusComboList() {
        SqlSession db = ConnClient.getSession();
        List<WorkStatus> result = db.selectList("common.getWorkStatusList");
        return result.toArray(new WorkStatus[result.size()]);
    }

    public WorkStatus getWorkStatusById(String id) {
        return ConnClient.getSession().selectOne("common.getWorkStatusById", id);
    }
}
