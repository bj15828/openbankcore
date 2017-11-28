package com.xbeer.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xbeer.repository.daoadapter.TransactionJournalDaoAdapter;

@Repository

public class TransactionRepository {
  private final Logger logger = LoggerFactory.getLogger(TransactionRepository.class);


  @Autowired
  TransactionJournalDaoAdapter tranDao;


  

  


}
