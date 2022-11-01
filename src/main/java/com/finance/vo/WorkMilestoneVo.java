package com.finance.vo;

public class WorkMilestoneVo {

    private String workname;
    private String starttime;
    private String endtime;
    private String color; // 255_255_255

    public WorkMilestoneVo() {
    }

    public WorkMilestoneVo(String workname, String starttime, String endtime, String color) {
        this.workname = workname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.color = color;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
