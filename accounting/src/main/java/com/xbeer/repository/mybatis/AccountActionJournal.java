package com.xbeer.repository.mybatis;

import java.util.Date;

public class AccountActionJournal {
    private Long seqNo;

    private String acctId;

    private Date createTime;

    private Integer action;

    private Double amount;

    private Double beforeBalance;

    private Double afterBalance;

    private String tranUuid;

    private String tranSeqNo;

    private String urlContext;

    private String tranCode;

    private Long rid;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBeforeBalance() {
        return beforeBalance;
    }

    public void setBeforeBalance(Double beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public Double getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Double afterBalance) {
        this.afterBalance = afterBalance;
    }

    public String getTranUuid() {
        return tranUuid;
    }

    public void setTranUuid(String tranUuid) {
        this.tranUuid = tranUuid == null ? null : tranUuid.trim();
    }

    public String getTranSeqNo() {
        return tranSeqNo;
    }

    public void setTranSeqNo(String tranSeqNo) {
        this.tranSeqNo = tranSeqNo == null ? null : tranSeqNo.trim();
    }

    public String getUrlContext() {
        return urlContext;
    }

    public void setUrlContext(String urlContext) {
        this.urlContext = urlContext == null ? null : urlContext.trim();
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode == null ? null : tranCode.trim();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}