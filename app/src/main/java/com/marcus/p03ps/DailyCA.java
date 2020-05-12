package com.marcus.p03ps;

import java.io.Serializable;

public class DailyCA implements Serializable {

    private String moduleCode;
    private String dgGrade;
    private int week;

    public DailyCA(String moduleCode, String dgGrade, int week) {
        this.moduleCode = moduleCode;
        this.dgGrade = dgGrade;
        this.week = week;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public void setDgGrade(String dgGrade) {
        this.dgGrade = dgGrade;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}