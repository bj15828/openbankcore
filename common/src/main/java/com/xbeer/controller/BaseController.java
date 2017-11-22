package com.xbeer.controller;

import org.springframework.beans.BeanUtils;

import com.xbeer.message.Message;
import com.xbeer.net.CommandRequestBody;
import com.xbeer.net.CommandRequestHeader;
import com.xbeer.net.CommandResponse;
import com.xbeer.net.CommandResponseHeader;

public class BaseController {
    public CommandResponse newCommandReturn(CommandRequestHeader header,Message result,CommandRequestBody body){
      
      CommandResponseHeader retHeader =  new CommandResponseHeader();
      
      BeanUtils.copyProperties(header, retHeader);
      
      retHeader.setRet_code(result.getCode());
      retHeader.setRet_msg(result.getMsg());
      
      CommandResponse cmdRet = new CommandResponse();
      cmdRet.setHeader(retHeader);
      
      
      
      cmdRet.setBody(body);
      
      return cmdRet;
    }
}
