package com.xbeer.mybatis.model;

import java.util.Date;

public class BalanceComposition {
    private String balaCompId;

    private String name;

    private Date valueDate;

    private String interestRateId;

    private Integer isCalcCompound;

    public String getBalaCompId() {
        return balaCompId;
    }

    public void setBalaCompId(String balaCompId) {
        this.balaCompId = balaCompId == null ? null : balaCompId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(String interestRateId) {
        this.interestRateId = interestRateId == null ? null : interestRateId.trim();
    }

    public Integer getIsCalcCompound() {
        return isCalcCompound;
    }

    public void setIsCalcCompound(Integer isCalcCompound) {
        this.isCalcCompound = isCalcCompound;
    }
}