package com.xbeer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xbeer.api.ILimitCenterService;
import com.xbeer.api.dto.LimitQueryCommand;
import com.xbeer.command.CommandResponse;
import com.xbeer.constants.MessageConstants;
import com.xbeer.exception.BaseException;
import com.xbeer.message.MessageFactory;

@RestController

public class TranLimitController extends BaseController implements ILimitCenterService {

  private final Logger logger = LoggerFactory.getLogger(TranLimitController.class);


  
  @ResponseBody
  @RequestMapping(value = "/limit/query", method = RequestMethod.POST)

  // 可以使用RequestBody 转换成对象

  public CommandResponse limitQuery(@RequestBody LimitQueryCommand cmd

  ) throws BaseException {
    CommandResponse res = null;
    
    logger.info("recieve:{}",cmd);
try{
   // LimitQueryCommand cmd = new Gson().fromJson(cmdStr, LimitQueryCommand.class);
     res = this.newCommandReturn(cmd.getHeader(),
        MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS), null);
} catch(Exception e){
  
  
  logger.error(e.getLocalizedMessage());
  throw new BaseException(e).setReq(cmd);
}
return res;

  }

}
