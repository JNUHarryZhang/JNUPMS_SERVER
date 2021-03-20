package com.ruoyi.project.system.domain.vo;

public class TechTotal {

    private Long id;

    private Integer total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TechTotal{" +
                "id=" + id +
                ", total=" + total +
                '}';
    }
}
