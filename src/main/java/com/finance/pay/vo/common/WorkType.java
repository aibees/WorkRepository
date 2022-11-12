package com.finance.pay.vo.common;

public class WorkType {

    public WorkType() {
    }

    public WorkType(String number, String type) {
        this.number = number;
        this.type = type;
    }

    private String number;
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
