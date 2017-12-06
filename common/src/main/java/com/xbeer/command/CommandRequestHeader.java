package com.xbeer.command;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CommandRequestHeader {


  @NotNull(message="不能为空")
  @Length(min = 1, max = 20, message = "长度必须为1-20")
    String svr_cd ;//服务代码
    String svr_scn;//服务场景
  
    @NotNull(message="不能为空")
    @Length(min = 1, max = 10, message = "长度必须为1-10")
    String consmr_id;//请求系统ID
    

    @NotNull(message="不能为空")
    @Length(min = 1, max = 32, message = "长度必须为1-32")
    String consmr_seq_no;//请求系统流水号
    String txn_dt;//交易日期
    String txn_time;//交易时间
    
    String chnl_tp;//渠道编号
    
    
    String org_consmr_id;//原系统编号
    String org_consmr_seq_no;//原系统流水号
    
    
    
    
    @NotNull(message="不能为空")
    @Length(min = 32, max = 32, message = "长度必须为32")
    String uuid;//唯一流水号

    
    
    
    
    public String getSvr_cd() {
      return svr_cd;
    }

    public void setSvr_cd(String svr_cd) {
      this.svr_cd = svr_cd;
    }

    public String getSvr_scn() {
      return svr_scn;
    }

    public void setSvr_scn(String svr_scn) {
      this.svr_scn = svr_scn;
    }

    public String getConsmr_id() {
      return consmr_id;
    }

    public void setConsmr_id(String consmr_id) {
      this.consmr_id = consmr_id;
    }

    public String getConsmr_seq_no() {
      return consmr_seq_no;
    }

    public void setConsmr_seq_no(String consmr_seq_no) {
      this.consmr_seq_no = consmr_seq_no;
    }

    public String getTxn_dt() {
      return txn_dt;
    }

    public void setTxn_dt(String txn_dt) {
      this.txn_dt = txn_dt;
    }

    public String getTxn_time() {
      return txn_time;
    }

    public void setTxn_time(String txn_time) {
      this.txn_time = txn_time;
    }

    public String getChnl_tp() {
      return chnl_tp;
    }

    public void setChnl_tp(String chnl_tp) {
      this.chnl_tp = chnl_tp;
    }

    public String getOrg_consmr_id() {
      return org_consmr_id;
    }

    public void setOrg_consmr_id(String org_consmr_id) {
      this.org_consmr_id = org_consmr_id;
    }

    public String getOrg_consmr_seq_no() {
      return org_consmr_seq_no;
    }

    public void setOrg_consmr_seq_no(String org_consmr_seq_no) {
      this.org_consmr_seq_no = org_consmr_seq_no;
    }

    public String getUuid() {
      return uuid;
    }

    public void setUuid(String uuid) {
      this.uuid = uuid;
    }
    
    
    
    
    
    
}
