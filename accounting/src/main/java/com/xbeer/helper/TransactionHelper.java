package com.xbeer.helper;

import com.xbeer.net.BaseRequestCommand;
import com.xbeer.repository.mybatis.TransactionJournal;
import com.xbeer.util.IDGenerator;

public class TransactionHelper {

  
  public static TransactionJournal fromCommand(BaseRequestCommand cmd){
    TransactionJournal tranRecord = new TransactionJournal();
    
    tranRecord.setSeqNo(IDGenerator.newTransactionSeq());
   
    
    
    
    
    
    return tranRecord;
  }
}
