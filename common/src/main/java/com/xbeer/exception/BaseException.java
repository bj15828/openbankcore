package com.xbeer.exception;

import com.xbeer.net.BaseRequestCommand;

public class BaseException extends Exception {

  BaseRequestCommand t;

  public BaseException(Exception e) {



  }

  public BaseException(Exception e, BaseRequestCommand c) {
    this.t = c;


  }

  public void setReq(BaseRequestCommand cmd) {
    this.t = cmd;

  }

  public BaseRequestCommand getReq() {
    return this.t;
  }
}
