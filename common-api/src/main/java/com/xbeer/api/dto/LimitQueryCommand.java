package com.xbeer.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.constants.MessageConstants;

public class LimitQueryCommand extends BaseRequestCommand {


  @NotNull(message = MessageConstants.MessageText.NOT_NULL)
  @Valid
  LimitQueryBody body;




  public LimitQueryBody getBody() {
    return body;
  }


  public void setBody(LimitQueryBody body) {
    this.body = body;
  }


  

  
  


}
