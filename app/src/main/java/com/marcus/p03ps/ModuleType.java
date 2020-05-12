package com.marcus.p03ps;

public class ModuleType {

    private String moduleCode;
    private String MG;
    private String week;

    public ModuleType(String moduleCode, String MG, String week) {
        this.moduleCode = moduleCode;
        this.MG = MG;
        this.week = week;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getMG() {
        return MG;
    }

    public void setMG(String MG) {
        this.MG = MG;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}