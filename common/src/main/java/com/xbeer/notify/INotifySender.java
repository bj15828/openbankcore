package com.xbeer.notify;

import java.util.function.Consumer;

public interface INotifySender {
  /**
   * @param topic
   * @param content
   * */
     
  
      public boolean isSelf(String type);
      public void setCallback(Consumer cb);
      boolean send(String topic, String content, long id);
   
}
