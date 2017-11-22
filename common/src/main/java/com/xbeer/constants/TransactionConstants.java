package com.xbeer.constants;
/**
 * 
 * 
 * @author yxp
 *
 */
public class TransactionConstants {

  /***
   * 
   * 交易类型，金融交易，查询交易，管理交易，特殊交易。金融交易方向：借贷
   * @author yxp
   *
   */
  public static enum TransactionType{
      
      Financial ,Query,Manager,Special 
      
  }
  
  
  
  /**
   * 
   * 内部交易码指系统内部互调时使用的编码
   * 按照模块进行编码，两位字母表示所属的模块大类，内部使用5位编码方式从10000开始：
   * account : ac 账户相关
   * interest: it  利息相关
   * 
   * 
   * @author yxp
   *
   */
  
  public static enum TransactionCode{
    
    AC_ChannelTransfer("ac10000","渠道转账交易");
    
    
    
    String code;
    String name;
    
    
    TransactionCode(String code ,String name){
      this.code = code; 
      this.name = name;
      
    }
    
    public String getCode(){
      
      return this.code;
    }
    
    public boolean equals(TransactionCode tran){
      
      return this.code.equals(tran.getCode());
    }
    public boolean equals(String code){
      
      return this.code.equals(code);
    }
  }
  
  
  
  
  
}
