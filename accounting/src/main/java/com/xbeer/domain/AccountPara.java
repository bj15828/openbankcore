package com.xbeer.domain;

public class AccountPara {

  /**
   * 
   * 帐号对应的客户是属于内部还是外部
   * */
  public static enum AccountCustomerType{
    
    INNER_CUSTOMER,OUTTER_CUSTOMER
    
  } 
  
  /**
   * 帐号借贷记控制
   * 初始化ALLOW_ALL
   * */
  public static enum AccountDRControlFlag{
    
    ONLY_CREDIT,ONLY_DEBIT,ALLOW_ALL,FORBIT_ALL
    
  }
  
  /**
   * 账户状态
   * */
  public static enum AccountState{
      
    NORMAL ,LOCK,FROZEN,
    
  }
  
  
}
