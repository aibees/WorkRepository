package com.finance.pay.vo.common;

public class RepeatStatus {

    public RepeatStatus() {
    }

    public RepeatStatus(String number, String status) {
        this.number = number;
        this.status = status;
    }

    private String number;
    private String status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
