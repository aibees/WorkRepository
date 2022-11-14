package com.finance.pay.vo.common;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkType workType = (WorkType) o;
        return Objects.equals(number, workType.number) &&
                Objects.equals(type, workType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
