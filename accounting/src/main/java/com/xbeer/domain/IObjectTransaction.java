package com.xbeer.domain;

import com.xbeer.event.MicroStateMachine;

public interface IObjectTransaction {
  
  
  public int lock();
  public int unlock();
  public int rollback(MicroStateMachine machine);
  public int commit(MicroStateMachine machine);
  
  
  
}
