package com.xbeer.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.util.StringUtil;


public class NotifyRecieverImpl implements INotifyReceiver{

  private final  Logger logger = LoggerFactory.getLogger(NotifyRecieverImpl.class);

  
  @Autowired
  NotifyManager notifyManager ;
  String [] bindQueus;
  String name;
  
 
  public NotifyRecieverImpl(String name){
     
    this.name = name;
  }
  
  public void init(){
    
    notifyManager.registerReceiver(this);
  }
  
  
  
  
  /**
   * <!-- key is Queue,value is Topic -->
   * */
  
  public void setQueueBind(String  queues){
    
    
    bindQueus = StringUtil.split(queues, ",");
   
    
  }
  
  
  
  @Override
  public void callback(String message) {
    
    logger.info("receive message:{}",message);
    
    
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getBindQueues() {
    // TODO Auto-generated method stub
    return this.bindQueus;
  }

}
