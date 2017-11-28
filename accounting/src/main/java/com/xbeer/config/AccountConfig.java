package com.xbeer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xbeer.notify.NotifyManager;
import com.xbeer.service.TransferService;


public class AccountConfig {

  private final Logger logger = LoggerFactory.getLogger(AccountConfig.class);

  public void init() {


    NotifyManager.setCallback(x -> {

      logger.info("call back id :{}", x);

    });

    logger.info("set rabbit callback");
  }

}
