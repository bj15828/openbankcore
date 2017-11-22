package com.xbeer.notify.rabbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.notify.INotifyReceiver;
import com.xbeer.notify.INotifySender;
import com.xbeer.notify.NotifyConfig;
import com.xbeer.util.StringUtil;


public class RabbitMQConfig implements NotifyConfig{

  private final  Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);

  
  
  public final static String ExchangeName = "Rabbit_Exchange";

  private String[] queues;
  private String[] topics;

  private Map<String, Queue> queueMap;

  private TopicExchange topicExchange = new TopicExchange(RabbitMQConfig.ExchangeName);

  @Autowired
  private ConnectionFactory connectionFactory;
  
  @Autowired
  private RabbitTemplate template;
  
  RabbitAdmin rabbitAdmin;
  
  List<SimpleMessageListenerContainer> containers = new ArrayList();
  
  


  private Map<String, String> binding;
  

  public RabbitMQConfig() {
    
}

  public RabbitMQConfig(String queues, String topics) {
      this.setQueues(queues);
      this.setTopics(topics);
  }

  public void setQueues(String strQueues) {

    if (StringUtil.isEmpty(strQueues))
      return;

    queues = StringUtil.split(strQueues, ",");

  }

  public void setTopics(String strTopics) {


    if (StringUtil.isEmpty(strTopics))
      return;

    topics = StringUtil.split(strTopics, ",");

  }
  
 public void setBinding(Map<String, String > binding){
    
    this.binding = binding;
    
  }

  public void init() {

    
     rabbitAdmin = new RabbitAdmin(this.connectionFactory); 
    
    queueMap = new ConcurrentHashMap();
    for (String queueName : queues) {
      Queue q = new Queue(queueName, false);
      queueMap.put(queueName,q );
      rabbitAdmin.declareQueue(q);
        logger.info("create rabbit queue:{}",queueName);
        
        
        
    }
    
    rabbitAdmin.declareExchange(this.topicExchange);  
    
    binding.forEach( (k,v) -> {
      
      bindSender(k, v);
      
    });


  }

  public boolean bindSender(String queue, String topic) {

    Queue q = queueMap.get(queue);
    if (null == q)
      return false;
    
    rabbitAdmin.declareBinding(BindingBuilder.bind(q).to(topicExchange).with(topic));
    
    logger.info("bind sender queue:[{}] topic:[{}]",q.getName(),topic);


    return true;

  }
  
  
  public boolean bindReciever(String queue,  INotifyReceiver receiver) {

    Queue q = queueMap.get(queue);
    if (null == q)
      return false;
    
    
    MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(receiver, "callback");

    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queue);
    container.setMessageListener(listenerAdapter);
    logger.info("bind reciever queue:[{}] conn:[{}]",queue,connectionFactory);
   container.start();
   containers.add(container);
  
    
   
    
    return true;

  }
  
 

  @Override
  public boolean registerReceiver(INotifyReceiver receiver) {
    
    String [] bindQueues = receiver.getBindQueues();
    
    for(String queue : bindQueues){
        this.bindReciever(queue, receiver);
    }
    
    return true;
  }

  @Override
  public boolean registerSender(INotifySender sender) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean send(String topic, String content) {
    template.convertAndSend(RabbitMQConfig.ExchangeName, topic, content);
    return false;
  }
  



}
