package com.xbeer.net.command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.xbeer.constants.MessageConstants;
import com.xbeer.net.BaseRequestCommand;

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
