package com.xbeer.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.xbeer.exception.BaseException;
import com.xbeer.notify.rabbit.RabbitMQConfig;
import com.xbeer.util.ObjectUtil;
import com.xbeer.util.StringUtil;

/**
 * 消息发送管理 通过spring配置文件，指定默认的发送方式
 * 
 */

@Component

public class NotifyManager {


  public static String NotifyType_RabbitMQ = "rabbitmq";
  public static String NotifyType_Kafka = "kafka";
  public static String NotifyType_RocketMQ = "rocketmq";
  /*
   * @Autowired(required=true)
   * 
   * @Qualifier("notifySender")
   */
  List<INotifySender> senders;// 注入多个INotifySender，可能有RabbitMQ，也有可能是kafka

  String defaultNotify;


  NotifyConfig config;


  static INotifySender defaultSender;

  public NotifyManager() {

    this.senders = new ArrayList();
  }


  public NotifyManager(Map<String, Object> args) {
    if (args == null) {
      return;
    }

    String defaultConfig = (String) args.get("default");
    defaultNotify = defaultConfig;
    if (StringUtil.equals(defaultConfig, NotifyType_RabbitMQ)) {

      RabbitMQConfig rabbitConfig =
          new RabbitMQConfig((String) args.get("queues"), (String) args.get("topics"));
      Map<String, String> binding = (Map<String, String>) args.get("binding");
      rabbitConfig.setBinding(binding);

      config = rabbitConfig;
      config.init();

    }
  }

  private INotifySender get(String type) {

    for (INotifySender sender : this.senders) {
      if (sender.isSelf(type)) {
        return sender;
      }
    }
    return null;
  }

  public void setNotifys(List<INotifySender> senders) {
    this.senders = senders;
  }


  public void setDefaultConfig(NotifyConfig defaultConfig) {


    this.config = defaultConfig;

  }

  public static boolean setCallback(Consumer<?> cb) {

   /* if (ObjectUtil.isNull(defaultSender)) {
      return false;
    }
*/
     defaultSender.setCallback(cb);

    return true;
  }

  public static boolean send(String topic, String content, long msgId) throws BaseException {
    if (null == defaultSender) {
      return false;
    }
    
    defaultSender.send(topic, content, msgId);
    return true;
  }

  public void registerReceiver(INotifyReceiver receiver) {

    config.registerReceiver(receiver);
  }

  public void registerSender(INotifySender sender, boolean isDefault) {
    if (isDefault) {
      this.defaultSender = sender;
    }
    senders.add(sender);

  }



 
}
