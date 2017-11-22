package com.xbeer.dao;

import com.xbeer.event.MicroStateMachine;
import com.xbeer.exception.BaseException;

public interface IMicroStateMachineDao {
  
  public MicroStateMachine getMachineById(String id) throws BaseException;
  
  public int save(MicroStateMachine machine) throws BaseException;
  
  
  
  
}
