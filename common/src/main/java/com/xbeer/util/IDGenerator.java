package com.xbeer.util;

public class IDGenerator {

  
    static IDWorker tranWork = new IDWorker(1,1);
    static IDWorker actionWork = new IDWorker(2,1);
    static IDWorker eventWork = new IDWorker(3,1);
    
    public static long newTransactionSeq(){
      return tranWork.nextId();
    }
    
    public static long newActionId(){
      return actionWork.nextId();
    }
    
    public static long newEventId(){
      return eventWork.nextId();
    }
    
    
    
  
  
}
