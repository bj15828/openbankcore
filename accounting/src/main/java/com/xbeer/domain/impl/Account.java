package com.xbeer.domain.impl;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import com.xbeer.annotation.TransactionOps;
import com.xbeer.domain.AccountPara.AccountState;
import com.xbeer.domain.IAccount;
import com.xbeer.domain.IObjectTransaction;
import com.xbeer.domain.Rid;
import com.xbeer.event.MicroStateMachine;
import com.xbeer.exception.BaseException;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.util.DecimalUtil;

public class Account implements IAccount,IObjectTransaction {

  ReentrantLock lock;

  Rid rid;
  
  double balance;
  
  double frozenAmount ;//冻结金额
  
  String id ;
  
  Date createTime;
  
  Date lastModifyTime;
  
  Date lastFlushTime;//last flush to store time
  
  Date loadTime ;//load from Store
  
  

  public Account() {

    lock = new ReentrantLock();
    rid = new Rid();

  }

  public int lock() {
    lock.lock();
    return 1;
  }

  public int unlock() {
    lock.unlock();
    return 1;
  }

  public int rollback(MicroStateMachine machine) {
   
   
     
   
   
    return 1;
  }

  public int commit(MicroStateMachine machine) {
    
    
    return 1;
  }

  private void copy(Account account){
    
    
    this.lock = account.lock;
    this.rid = account.rid;
    this.balance = account.balance;
    
  }
  
  public Message newAccount(MicroStateMachine machine) throws BaseException {
    
    
    return null;
  }

  public Message increaseAmount(double amount, MicroStateMachine machine) throws BaseException {
   
    
    return null;
  }

  public Message decreaseAmount(double amount, MicroStateMachine machine) throws BaseException {
    // TODO Auto-generated method stub
    return null;
  }

  public Message frozenAmount(double amount, MicroStateMachine machine) throws BaseException {

    machine.setBeforeState(this);
    this.frozenAmount = this.frozenAmount + amount;
    machine.setAfterState(this);
    
    return MessageFactory.newSuccessMessage("frozen amount sucess!");
  }

  @TransactionOps
  public Message unfrozenAmount(double amount, MicroStateMachine machine) throws BaseException {

    machine.setBeforeState(this);
    
    this.frozenAmount = DecimalUtil.sub(this.frozenAmount, amount);
    
    machine.setAfterState(this);
    
    return MessageFactory.newSuccessMessage("unfrozen amount sucess!");
    
  }

  public Message changeState(AccountState state, MicroStateMachine machine) throws BaseException {
    // TODO Auto-generated method stub
    return null;
  }

}
