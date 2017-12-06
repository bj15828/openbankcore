package com.xbeer.notify.rabbit;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.exception.BaseException;
import com.xbeer.notify.INotifySender;
import com.xbeer.notify.NotifyManager;
import com.xbeer.util.StringUtil;



public class RabbitMQSender implements INotifySender, RabbitTemplate.ConfirmCallback {

  private final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);



  @Autowired
  private final RabbitTemplate rabbitTemplate = null;

  @Autowired
  NotifyManager notifyManager;

  Consumer cb;


  public RabbitMQSender(String notifyType) {



  }



  @Override
  public boolean send(String topic, String content, long id) throws BaseException {

    logger.info("topic :[{}],content:[{}]", topic, content);
    CorrelationData correlationId = new CorrelationData(id + "");
    try{
    rabbitTemplate.convertAndSend(RabbitMQConfig.ExchangeName, topic, content, correlationId);
    }catch(AmqpException e){
      throw new BaseException(e);
    }


    return true;



  }

  @Override
  public boolean isSelf(String type) {

    return StringUtil.equals(NotifyManager.NotifyType_RabbitMQ, type);
  }

  public void init() {
    notifyManager.registerSender(this, true);

  }

  @Override
  public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    
    logger.info("rabbit call back {}",correlationData);
    if (ack) {
      if (null != cb) {
        cb.accept(correlationData);
      }
    } else
      logger.error("{}", cause);

  }



  @Override
  public void setCallback(Consumer cb) {
    this.cb = cb;
    rabbitTemplate.setConfirmCallback(this);

   


  }



}
