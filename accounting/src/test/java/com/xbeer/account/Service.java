package com.xbeer.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xbeer.annotation.TransactionOps;
import com.xbeer.repository.mybatis.AccountBalance;
import com.xbeer.repository.mybatis.dao.AccountBalanceMapper;

@Component
public class Service {
  
  private int v  = 0;
  
  @Autowired
  
  AccountBalanceMapper accountMapper;
  
  @Transactional 
  @TransactionOps
  public void test1(){
    
    v = 1;
    System.out.println("Service.test1()");;
    
    AccountBalance record = new AccountBalance();
    
    record.setAcctId("11");
    
    //accountMapper.insert(record);
    
  }
  public int getV(){
    return v;
  }
  
}
