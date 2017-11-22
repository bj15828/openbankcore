package com.xbeer.param;

public class ParamContants {


  /**
   * 交易类型
   * */
  public enum TranType {

    FINANCIAL_TRAN(1), QUERY_TRAN(2), MANAGEMENT_TRAN(3), SPECIAL_TRAN(4);
    int code;

    TranType(int i) {code = i;}
    
    public int getCode(){
      return code;
    }
  }
  
  
  


}
