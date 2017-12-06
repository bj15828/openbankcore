package com.xbeer.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xbeer.constants.MessageConstants;
import com.xbeer.event.BaseEvent;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.repository.daoadapter.NotifyMessageDaoAdapter;
import com.xbeer.repository.mybatis.NotifyEvent;
import com.xbeer.util.DateUtil;
import com.xbeer.util.JsonUtil;

@Repository

public class EventRepository {
  private final Logger logger = LoggerFactory.getLogger(EventRepository.class);


  @Autowired
  NotifyMessageDaoAdapter msgDao;

  public Message saveEvent(BaseEvent event){
    
    NotifyEvent e = new NotifyEvent();
    e.setClazz(event.getClass()+"");
    e.setEventId(event.getEventId());
    e.setContent(JsonUtil.object2Json(event));
    e.setCreateTime(DateUtil.today());
    e.setStats(BaseEvent.Stats.SENT_NOT_BACK.code());
    
    msgDao.insert(e);
    
    
    return MessageFactory.newSuccessMessage(MessageConstants.MessageText.SUCCESS);
    
  }
  

  


}
