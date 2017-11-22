package com.xbeer.net;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

public abstract class BaseRequestCommand {


  @NotNull(message="header 不能为空")
  @Valid
 public  CommandRequestHeader header;
 
  
  private String tranCode;//内部交易码
  
  private long tranSeqNo;//内部流水号
  
  
  private String urlContext;//请求路径
  
  
  
  
  
  
  




  public String getUrlContext() {
    return urlContext;
  }

  public void setUrlContext(String urlContext) {
    this.urlContext = urlContext;
  }

  public long getTranSeqNo() {
    return tranSeqNo;
  }

  public void setTranSeqNo(long tranSeqNo) {
    this.tranSeqNo = tranSeqNo;
  }

  public String getTranCode() {
    return tranCode;
  }

  public void setTranCode(String tranCode) {
    this.tranCode = tranCode;
  }

  public CommandRequestHeader getHeader() {
    return header;
  }

  public void setHeader(CommandRequestHeader header) {
    this.header = header;
  }
  
  
  public abstract  CommandRequestBody getBody();
  



}
