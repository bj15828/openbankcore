package com.xbeer.helper;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.constants.EventConstants.EventType;
import com.xbeer.event.BaseEvent;
import com.xbeer.event.TransferEvent;
import com.xbeer.util.DateUtil;
import com.xbeer.util.IDGenerator;

public class EventHelper {
  
  public static String ACCOUNT_TRANSFER_TOPIC = "account.transfer";
  
  public static <T> T newEventFromCommand(BaseRequestCommand cmd,EventType type){
    
    BaseEvent e = null;
    switch(type){
      case TRANSFER_EVENT :{
        e = new TransferEvent(IDGenerator.newEventId());
      }
      
      
    }
    
    e.setCreateDate(DateUtil.today());
    e.setOrgCmd(cmd);
    e.setTranCode(cmd.getTranCode());
    e.setTranSeqNo(cmd.getTranSeqNo());
    e.setUrlContext(cmd.getUrlContext());

    e.setUuid(cmd.getHeader().getUuid());
    return (T) e;
  }
  
  
  
}
