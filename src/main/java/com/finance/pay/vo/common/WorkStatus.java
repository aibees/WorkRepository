package com.finance.pay.vo.common;

import java.util.Objects;

public class WorkStatus {

    public WorkStatus() {
    }

    public WorkStatus(String number, String status) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkStatus that = (WorkStatus) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, status);
    }
}
