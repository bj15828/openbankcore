package com.xbeer.helper;

import com.xbeer.repository.mybatis.AccountRid;

public class RidHelper {
    public static AccountRid inrRid(AccountRid rid){
      
      if(rid.getRid() <0 )rid.setRid(0L);
      rid.setRid(rid.getRid()+1);
      
      return rid;
          
    }
}
