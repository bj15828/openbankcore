package com.xbeer.message;

import com.xbeer.constants.MessageConstants.MessageCode;

public class Message {
  
  String code;
  String msg;
  
  public Message(String code,String msg){
    
    this.code = code;
    this.msg = msg;
    
  }
 
  public boolean isOk(){
    
   return  code.equals( MessageCode.SUCCESS.getCode() ) ? true : false;
  }
  
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  
  
}
