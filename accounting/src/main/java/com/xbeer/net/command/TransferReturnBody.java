package com.xbeer.net.command;

import com.xbeer.net.CommandRequestBody;

public class TransferReturnBody extends CommandRequestBody{
      
      String code;
      String msg;
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
