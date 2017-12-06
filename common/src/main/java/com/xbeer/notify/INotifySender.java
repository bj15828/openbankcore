package com.xbeer.notify;

import java.util.function.Consumer;

import com.xbeer.exception.BaseException;

public interface INotifySender {
  /**
   * @param topic
   * @param content
   * */
     
  
      public boolean isSelf(String type);
      public void setCallback(Consumer cb);
      boolean send(String topic, String content, long id) throws BaseException;
   
}
