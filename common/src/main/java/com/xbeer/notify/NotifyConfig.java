package com.xbeer.notify;

public interface NotifyConfig {
  public boolean registerReceiver(INotifyReceiver receiver);
  public boolean registerSender(INotifySender sender);
  public void init();
  public boolean send(String topic,String content);
}
