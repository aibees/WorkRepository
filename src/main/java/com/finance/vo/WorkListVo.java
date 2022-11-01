package com.finance.vo;

import java.time.LocalDate;

public class WorkListVo {
    public WorkListVo() {

    }

    public WorkListVo(String workId, String workTitle, LocalDate frDate, LocalDate toDate) {
        this.workId = workId;
        this.workTitle = workTitle;
        this.frDate = frDate;
        this.toDate = toDate;
    }

    private String workId;
    private String workTitle;
    private LocalDate frDate;
    private LocalDate toDate;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public LocalDate getFrDate() {
        return frDate;
    }

    public void setFrDate(LocalDate frDate) {
        this.frDate = frDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
