package com.xbeer.exception;

public class ErrorCode {
 
    public static final String SERVER_ERROR = "1000001";



    public static final String ILLEGAL_PARAMS = "1000002";
    
    
    
    String code;
    String message;
    public String getCode() {
      return code;
    }
    public void setCode(String code) {
      this.code = code;
    }
    public String getMessage() {
      return message;
    }
    public void setMessage(String message) {
      this.message = message;
    }
    
    
  
}
