package com.xbeer.event;

import com.xbeer.constants.EventConstants.EventType;
import com.xbeer.helper.EventHelper;

public class TransferEvent extends BaseEvent{

  public TransferEvent(long eventId,EventType type) {
    super(eventId, EventHelper.ACCOUNT_TRANSFER_TOPIC, type);
    
     
    
  }

}
