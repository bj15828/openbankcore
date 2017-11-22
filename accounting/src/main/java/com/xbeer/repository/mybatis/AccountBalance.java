package com.xbeer.repository.mybatis;

import java.util.Date;

public class AccountBalance {
    private String acctId;

    private Double balance;

    private Double frozenAmount;

    private Date lastModiTime;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Double frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Date getLastModiTime() {
        return lastModiTime;
    }

    public void setLastModiTime(Date lastModiTime) {
        this.lastModiTime = lastModiTime;
    }
}