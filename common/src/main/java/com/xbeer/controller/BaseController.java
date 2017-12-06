package com.xbeer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xbeer.command.CommandRequestBody;
import com.xbeer.command.CommandRequestHeader;
import com.xbeer.command.CommandResponse;
import com.xbeer.command.CommandResponseHeader;
import com.xbeer.message.Message;

public class BaseController {


  @Autowired
  private HttpServletRequest request;

  public CommandResponse newCommandReturn(CommandRequestHeader header, Message result,
      CommandRequestBody body) {

    CommandResponseHeader retHeader = new CommandResponseHeader();

    BeanUtils.copyProperties(header, retHeader);

    retHeader.setRet_code(result.getCode());
    retHeader.setRet_msg(result.getMsg());

    CommandResponse cmdRet = new CommandResponse();
    cmdRet.setHeader(retHeader);



    cmdRet.setBody(body);

    return cmdRet;
  }

  public String getCurUrlPath() {

    StringBuilder url = new StringBuilder("");

    url.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort())
    .append(request.getServletPath());

    if (request.getQueryString() != null) {

      url.append("?").append(request.getQueryString());

    }
    return url.toString();


  }
}
