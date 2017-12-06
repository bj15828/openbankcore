package com.xbeer.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.constants.MessageConstants;

public class TransferCommand extends BaseRequestCommand {


  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  @Valid
  TransferBody body;




  public TransferBody getBody() {
    return body;
  }


  public void setBody(TransferBody body) {
    this.body = body;
  }


 
  
  


}
