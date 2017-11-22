package com.xbeer.mybatis.model;

import java.util.Date;

public class BalanceCompositionAccumulate {
    private Long seqNo;

    private String acctId;

    private String balaCompId;

    private Date actionDate;

    private Double balanceDeposit;

    private Double balanceWithdraw;

    private Date interestStartDate;

    private Date interestEndDate;

    private Integer dayCount;

    private Integer interestNumber;

    private Long eventId;

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public String getBalaCompId() {
        return balaCompId;
    }

    public void setBalaCompId(String balaCompId) {
        this.balaCompId = balaCompId == null ? null : balaCompId.trim();
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Double getBalanceDeposit() {
        return balanceDeposit;
    }

    public void setBalanceDeposit(Double balanceDeposit) {
        this.balanceDeposit = balanceDeposit;
    }

    public Double getBalanceWithdraw() {
        return balanceWithdraw;
    }

    public void setBalanceWithdraw(Double balanceWithdraw) {
        this.balanceWithdraw = balanceWithdraw;
    }

    public Date getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(Date interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public Date getInterestEndDate() {
        return interestEndDate;
    }

    public void setInterestEndDate(Date interestEndDate) {
        this.interestEndDate = interestEndDate;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getInterestNumber() {
        return interestNumber;
    }

    public void setInterestNumber(Integer interestNumber) {
        this.interestNumber = interestNumber;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}