package com.xbeer.aop;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xbeer.constants.MessageConstants.MessageCode;
import com.xbeer.exception.BaseException;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.net.CommandResponse;
import com.xbeer.net.CommandResponseHeader;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
  private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

  @ExceptionHandler(value = BaseException.class)
  @ResponseBody
  
  public Object baseErrorHandler(HttpServletRequest req, BaseException e) throws Exception {


    CommandResponse cmdRet = new CommandResponse();
    CommandResponseHeader retHeader = new CommandResponseHeader();
    
    Message msg =  MessageFactory.newMessage(MessageCode.INERNAL_ERROR,e.getMessage());
    
    BeanUtils.copyProperties(e.getReq().getHeader(), retHeader);
    
    retHeader.setRet_code(msg.getCode());
    retHeader.setRet_msg(msg.getMsg());
    cmdRet.setHeader(retHeader);
    cmdRet.setBody(e.getReq().getBody());

    
    
    return cmdRet;
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Object defaultErrorHandler(Object transferCmd,HttpServletRequest req, Exception e,Object o ) throws Exception {
    
    logger.info("object class type: {} ",o.getClass());
    logger.info("e class type: {} ",e.getClass());
    logger.info("t class type: {} ",transferCmd.getClass());
    CommandResponse cmdRet = new CommandResponse();
    CommandResponseHeader retHeader = new CommandResponseHeader();
    
    Message msg =  MessageFactory.newMessage(MessageCode.INERNAL_ERROR,e.getMessage());
    retHeader.setRet_code(msg.getCode());
    retHeader.setRet_msg(msg.getMsg());
 
    cmdRet.setHeader(retHeader);
    return cmdRet;
  }
}
