package com.ruoyi.project.system.domain;

import com.ruoyi.project.system.domain.vo.TechTotal;

import java.util.List;

public class Tech {

    private String paperYear;

    private List<TechTotal> techTotals;

    public String getPaperYear() {
        return paperYear;
    }

    public void setPaperYear(String paperYear) {
        this.paperYear = paperYear;
    }

    public List<TechTotal> getTechTotals() {
        return techTotals;
    }

    public void setTechTotals(List<TechTotal> techTotals) {
        this.techTotals = techTotals;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "paperYear='" + paperYear + '\'' +
                ", techTotals=" + techTotals +
                '}';
    }
}
