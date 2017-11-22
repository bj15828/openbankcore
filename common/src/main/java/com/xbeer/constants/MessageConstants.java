package com.xbeer.constants;

public class MessageConstants {
  
    
  
    public static enum MessageCode {
      
      SUCCESS(MessageText.SUCCESS,"0000"),
      INERNAL_ERROR(MessageText.INERNAL_ERROR,"E100000"),
      ACCOUNT_HAS_NOT_ENOUGH_MONEY(MessageText.ACCOUNT_HAS_NOT_ENOUGH_MONEY,"E100001"),//
      ACCOUNT_NOT_EXISTS(MessageText.ACCOUNT_NOT_EXISTS,"E100002"),
      CONTROLLER_VALIDATE_ERROR(MessageText.CONTROLLER_VALIDATE_ERROR,"E100003"),
      NOT_NULL(MessageText.NOT_NULL,"E100004"),
      E10002(MessageText.SOCKET_TIME_OUT,"E100002"),
      E10003(MessageText.ROMATE_CALL_ERROR,"E100001");
     
      String message;
      String code ;
      
      MessageCode(String msg,String code){
        this.message = msg;
        this.code = code;
      }
      public String getCode(){
        return this.code;
      }
      public String getMessage(){
        return message;
      }
      
    };
  
    
    
    
    
    
    /**
     * 交易类型
     * */
    public static class MessageText {
      public static final String INERNAL_ERROR = "发生内部错误:[%s]";
      public static final String CONTROLLER_VALIDATE_ERROR = "数据校验失败[%s]";
      public static final String SUCCESS= "操作成功";
      public static final String NOT_NULL = "[%s]不能为空";
      public static final String TRANSFER_SUCCESS = "转账成功";
      public static final String ACCOUNT_HAS_NOT_ENOUGH_MONEY = "帐号[%s]金额不足";
      
      public static final String ACCOUNT_NOT_EXISTS ="帐号[%s]不存在";
      public static final String DB_OP_ERROR = "数据库操作失败";
      public static final String SOCKET_TIME_OUT ="SOCKET连接超时";
      public static final String ROMATE_CALL_ERROR ="远程调用失败";
     
    }
    
    
    
  
}
