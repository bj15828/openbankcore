package com.xbeer.domain;

import com.xbeer.event.MicroStateMachine;
import com.xbeer.exception.BaseException;
import com.xbeer.message.Message;

/**
 * 对于Aggregage的操作是要求有序的，因此，每次记录的状态中，需要带有操作的顺序好
 * */
public interface IAccount  {
  
  
  
  public Message newAccount(MicroStateMachine machine) throws BaseException;
  
  public Message increaseAmount(double amount, MicroStateMachine machine) throws BaseException;

  public Message decreaseAmount(double amount, MicroStateMachine machine) throws BaseException;

  public Message frozenAmount(double amount, MicroStateMachine machine) throws BaseException;

  public Message unfrozenAmount(double amount, MicroStateMachine machine) throws BaseException;

  public Message changeState(AccountPara.AccountState state ,MicroStateMachine machine) throws BaseException;
  
  
  
}
