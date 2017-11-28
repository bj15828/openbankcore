package com.xbeer.repository.daoadapter;

import org.springframework.context.annotation.Primary;

import com.xbeer.repository.mybatis.dao.TransactionJournalMapper;


@Primary
public interface TransactionJournalDaoAdapter extends TransactionJournalMapper    {

  

}
