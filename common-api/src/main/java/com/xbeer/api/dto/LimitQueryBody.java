package com.xbeer.api.dto;

import javax.validation.constraints.NotNull;

import com.xbeer.constants.MessageConstants;
import com.xbeer.net.CommandRequestBody;

public class LimitQueryBody extends CommandRequestBody {

  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  String acct_from;
  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  String acct_to;
  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  String busi_type;
  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  String amount;// 金额
  
  
  
  
  
  
  
  
  public String getAcct_from() {
    return acct_from;
  }
  public void setAcct_from(String acct_from) {
    this.acct_from = acct_from;
  }
  public String getAcct_to() {
    return acct_to;
  }
  public void setAcct_to(String acct_to) {
    this.acct_to = acct_to;
  }
  public String getBusi_type() {
    return busi_type;
  }
  public void setBusi_type(String busi_type) {
    this.busi_type = busi_type;
  }
  public String getAmount() {
    return amount;
  }
  public void setAmount(String amount) {
    this.amount = amount;
  }

  
  
  

}