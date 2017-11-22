package com.xbeer.net.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.xbeer.constants.MessageConstants;
import com.xbeer.net.BaseRequestCommand;

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
