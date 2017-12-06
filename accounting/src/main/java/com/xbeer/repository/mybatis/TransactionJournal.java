package com.xbeer.repository.mybatis;

import java.util.Date;

public class TransactionJournal {
    private Long seqNo;

    private String consmrId;

    private String consmrSeqNo;

    private String orgConsmrId;

    private String orgConsmrSeqNo;

    private String tranCode;

    private String txnDt;

    private String txnTime;

    private Date createTime;

    private Integer tranType;

    private String channelNo;

    private String detail;

    private String uuid;

    private Integer stats;

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getConsmrId() {
        return consmrId;
    }

    public void setConsmrId(String consmrId) {
        this.consmrId = consmrId == null ? null : consmrId.trim();
    }

    public String getConsmrSeqNo() {
        return consmrSeqNo;
    }

    public void setConsmrSeqNo(String consmrSeqNo) {
        this.consmrSeqNo = consmrSeqNo == null ? null : consmrSeqNo.trim();
    }

    public String getOrgConsmrId() {
        return orgConsmrId;
    }

    public void setOrgConsmrId(String orgConsmrId) {
        this.orgConsmrId = orgConsmrId == null ? null : orgConsmrId.trim();
    }

    public String getOrgConsmrSeqNo() {
        return orgConsmrSeqNo;
    }

    public void setOrgConsmrSeqNo(String orgConsmrSeqNo) {
        this.orgConsmrSeqNo = orgConsmrSeqNo == null ? null : orgConsmrSeqNo.trim();
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode == null ? null : tranCode.trim();
    }

    public String getTxnDt() {
        return txnDt;
    }

    public void setTxnDt(String txnDt) {
        this.txnDt = txnDt == null ? null : txnDt.trim();
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime == null ? null : txnTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTranType() {
        return tranType;
    }

    public void setTranType(Integer tranType) {
        this.tranType = tranType;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }
}