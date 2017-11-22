package com.xbeer.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.xbeer.command.LimitQueryCommand;
import com.xbeer.constants.MessageConstants;
import com.xbeer.exception.BaseException;
import com.xbeer.message.MessageFactory;
import com.xbeer.net.CommandResponse;

@RestController

public class TranLimitController extends BaseController {

  @ResponseBody
  @RequestMapping(value = "/limitquery", method = RequestMethod.POST)

  // 可以使用RequestBody 转换成对象

  public CommandResponse transfer(@RequestBody String cmdStr

  ) throws BaseException {
    CommandResponse res = null;
try{
    LimitQueryCommand cmd = new Gson().fromJson(cmdStr, LimitQueryCommand.class);
     res = this.newCommandReturn(cmd.getHeader(),
        MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS), null);
} catch(Exception e){
  e.printStackTrace();
}
return res;

  }

}
