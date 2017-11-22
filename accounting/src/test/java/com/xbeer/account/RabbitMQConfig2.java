package com.xbeer.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xbeer.account.Receiver;
import com.xbeer.notify.INotifyReceiver;
import com.xbeer.util.StringUtil;


public class RabbitMQConfig2 {

  public final static String accountQueue = "account";
  public final static String logQueue = "log";
  public final static String notifyQueue = "notify";


  public final static String ExchangeName = "Rabbit_Exchange";


  final static String queueName = "spring-boot";
  final static String queueName1 = "spring-boot1";



  @Bean
  Queue queue() {
    return new Queue(queueName, false);
  }

  @Bean
  Queue queue1() {
    return new Queue(queueName1, false);
  }

  @Bean
  Queue queueAccount() {
    return new Queue(RabbitMQConfig2.accountQueue, false);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange(RabbitMQConfig2.ExchangeName);
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {

    return BindingBuilder.bind(queue).to(exchange).with("topic1.*");
  }

  @Bean
  Binding bindingAccount(Queue queueAccount, TopicExchange exchange) {

    return BindingBuilder.bind(queueAccount).to(exchange).with("account.*");
  }

  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueName);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  SimpleMessageListenerContainer container1(ConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter1) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueName1);
    container.setMessageListener(listenerAdapter1);
    return container;
  }

  @Bean
  SimpleMessageListenerContainer containerAccount(ConnectionFactory connectionFactory,
      MessageListenerAdapter accountListener) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(RabbitMQConfig2.accountQueue);
    container.setMessageListener(accountListener);
    return container;
  }


  @Bean
  MessageListenerAdapter listenerAdapter(Receiver receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

  @Bean

  MessageListenerAdapter listenerAdapter1(Receiver receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

  @Bean

  MessageListenerAdapter accountListener(INotifyReceiver receiver) {
    return new MessageListenerAdapter(receiver, "callback");
  }

  private String[] queues;
  private String[] topics;
  
  private List<Queue> queueList;
  

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

  public void init() {
     
    queueList = new ArrayList();
    for(String queueName : queues){
        queueList.add(new Queue(queueName,false));
      
      
    }
    

  }



}
