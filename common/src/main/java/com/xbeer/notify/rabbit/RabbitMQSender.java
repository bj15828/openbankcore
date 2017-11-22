package com.xbeer.notify.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.notify.INotifySender;
import com.xbeer.notify.NotifyManager;
import com.xbeer.util.StringUtil;



public class RabbitMQSender implements INotifySender {
  
  private final  Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

  
 
  
  
  
  @Autowired
  private final RabbitTemplate rabbitTemplate = null;
  
  @Autowired
  NotifyManager notifyManager ;
  
 
  public RabbitMQSender(String notifyType){
    
    
  }
  
  @Override
  public boolean send(String topic, String content) {
    logger.info("topic :[{}],content:[{}]",topic,content);
    rabbitTemplate.convertAndSend(RabbitMQConfig.ExchangeName, topic, content);
    return true;
  }

  @Override
  public boolean isSelf(String type) {
   
    return StringUtil.equals(NotifyManager.NotifyType_RabbitMQ,type);
  }
  
  public void init(){
    notifyManager.registerSender(this,true);
    
  }

  
  
}
