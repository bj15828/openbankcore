package com.xbeer.controller.validate;

import java.util.Map;

import com.xbeer.constants.MessageConstants.MessageCode;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;

public class ValidateResult {
  boolean hasPassed = true;

  Map<String, StringBuffer> data;

  public Message getValidateMessage() {
    for (Map.Entry<String, StringBuffer> m : data.entrySet()) {

     return  MessageFactory.newMessage(MessageCode.CONTROLLER_VALIDATE_ERROR, new StringBuffer(m.getKey().toString()).append(m.getValue()).toString());
    }
    return null;
  }

  public boolean isHasPassed() {
    return hasPassed;
  }

  public void setHasPassed(boolean hasPassed) {
    this.hasPassed = hasPassed;
  }

  public Map<String, StringBuffer> getData() {
    return data;
  }

  public void setData(Map<String, StringBuffer> data) {
    this.data = data;
  }


}
