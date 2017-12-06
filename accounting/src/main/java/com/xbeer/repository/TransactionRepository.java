package com.xbeer.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xbeer.constants.MessageConstants;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.repository.daoadapter.TransactionJournalDaoAdapter;
import com.xbeer.repository.mybatis.TransactionJournal;

@Repository

public class TransactionRepository {
  private final Logger logger = LoggerFactory.getLogger(TransactionRepository.class);


  @Autowired
  TransactionJournalDaoAdapter tranDao;

  public Message saveTrans(TransactionJournal tj){
    
    
    tranDao.insert(tj);
    
    return MessageFactory.newSuccessMessage(MessageConstants.MessageText.SUCCESS);
    
  }
  

  


}
