package com.xbeer.repository.mybatis;

import java.util.Date;

public class AccountInfo {
    private String acctId;

    private Integer stats;

    private Date createTime;

    private Integer busiType;

    private String productId;

    private Integer masterOrPrimary;

    private Integer isCalculateInterest;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBusiType() {
        return busiType;
    }

    public void setBusiType(Integer busiType) {
        this.busiType = busiType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getMasterOrPrimary() {
        return masterOrPrimary;
    }

    public void setMasterOrPrimary(Integer masterOrPrimary) {
        this.masterOrPrimary = masterOrPrimary;
    }

    public Integer getIsCalculateInterest() {
        return isCalculateInterest;
    }

    public void setIsCalculateInterest(Integer isCalculateInterest) {
        this.isCalculateInterest = isCalculateInterest;
    }
}