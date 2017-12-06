package com.xbeer.event;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.constants.EventConstants.EventType;
import com.xbeer.helper.EventHelper;
import com.xbeer.util.DateUtil;
import com.xbeer.util.IDGenerator;

public class TransferEvent extends BaseEvent {



  public TransferEvent(long eventId) {
    super(eventId, EventHelper.ACCOUNT_TRANSFER_TOPIC, EventType.TRANSFER_EVENT);



  }

  @Override
  public BaseEvent fromCommand(BaseRequestCommand cmd) {



    setCreateDate(DateUtil.today());
    setOrgCmd(cmd);
    setTranCode(cmd.getTranCode());
    setTranSeqNo(cmd.getTranSeqNo());
    setUrlContext(cmd.getUrlContext());

    setUuid(cmd.getHeader().getUuid());
    setBody(cmd.toJSON());

    return this;
  }

}
