package com.xbeer.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.xbeer.notify.NotifyManager;

@Component
public class RabbitSender implements CommandLineRunner {
  private static Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;
  private final ConfigurableApplicationContext context;

  public RabbitSender(Receiver receiver, RabbitTemplate rabbitTemplate,
      ConfigurableApplicationContext context) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
    this.context = context;
  }

  @Override
  public void run(String... args) throws Exception {
    /*
     * System.out.println("Sending message..."); //rabbitTemplate.convertAndSend(, routingKey,
     * object, correlationData); rabbitTemplate.convertAndSend("Rabbit_Exchange","account.1",
     * "Hello from RabbitMQ!"); receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
     * //context.close();
     * 
     */

  }


}
