package com.xbeer.notify;

public interface INotifyReceiver {
  public void callback(String message);
  public String getName();
  public String[] getBindQueues();
}
