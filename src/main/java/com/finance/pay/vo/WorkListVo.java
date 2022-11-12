package com.finance.pay.vo;


import java.time.LocalDate;

public class WorkListVo {

    public WorkListVo() {
    }

    public WorkListVo(String workId, String workTitle, LocalDate frDate, LocalDate toDate, String worktype, String repeat, String desc) {
        this.workId = workId;
        this.workTitle = workTitle;
        this.frDate = frDate;
        this.toDate = toDate;
        this.worktype = worktype;
        this.repeat = repeat;
        this.desc = desc;
    }

    private String workId;
    private String workTitle;
    private LocalDate frDate;
    private LocalDate toDate;
    private String worktype;
    private String repeat;
    private String desc;

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

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WorkListVo{" +
                "workId='" + workId + '\'' +
                ", workTitle='" + workTitle + '\'' +
                ", frDate=" + frDate +
                ", toDate=" + toDate +
                ", worktype='" + worktype + '\'' +
                ", repeat='" + repeat + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {
        private String workId;
        private String workTitle;
        private LocalDate frDate;
        private LocalDate toDate;
        private String worktype;
        private String repeat;
        private String desc;

        public Builder workId(String workId) {
            this.workId = workId;
            return this;
        }
        public Builder workTitle(String workTitle) {
            this.workTitle = workTitle;
            return this;
        }
        public Builder frDate(LocalDate frDate) {
            this.frDate = frDate;
            return this;
        }
        public Builder toDate(LocalDate toDate) {
            this.toDate = toDate;
            return this;
        }
        public Builder worktype(String worktype) {
            this.worktype = worktype;
            return this;
        }
        public Builder repeat(String repeat) {
            this.repeat = repeat;
            return this;
        }
        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public WorkListVo create() {
            return new WorkListVo(workId, workTitle, frDate, toDate, worktype, repeat, desc);
        }
    }
}
