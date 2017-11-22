package com.xbeer.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.service.AccumulateBalanceEventHandler;

/**
 * 
 * 利息累计监听帐号变动事件
 * */

public class InterestNotifyReceiver implements INotifyReceiver {

  private final  Logger logger = LoggerFactory.getLogger(InterestNotifyReceiver.class);

  @Autowired  
  NotifyManager notifyManager;
  
  @Autowired  
  AccumulateBalanceEventHandler eventHandler;
  
  String name ;
  public InterestNotifyReceiver(String name){
    this.name = name; 
    
  }
  
  @Override
  public void callback(String message) {
    logger.info("receiver event:[{}]",message);
    
    //收到消息要先记录下来再进行处理，防止处理过程中出现错误，丢失消息
    
    
    
    
    //处理消息,处理消息有可能错误。一旦有错误，则可能引起spring的错误org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException
    //一旦有错误，RabbitMQ会不断重发
    //需要增加错误处理机制
    
    eventHandler.handler(null);
    
    //更新已记录的事件的状态为：已处理
    
  }
  public void init(){
    
    notifyManager.registerReceiver(this);
  }

  @Override
  public String getName() {
    
    return null;
  }

  @Override
  public String[] getBindQueues() {
    
    return new String[]{"account"};
  }

}
