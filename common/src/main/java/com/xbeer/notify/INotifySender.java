package com.xbeer.notify;

import java.util.Map;

public interface INotifySender {
  /**
   * @param topic
   * @param content
   * */
      public boolean send(String topic,String content);
  
      public boolean isSelf(String type);
   
}
