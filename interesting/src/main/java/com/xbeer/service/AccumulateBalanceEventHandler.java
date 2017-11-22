package com.xbeer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xbeer.constants.MessageConstants;
import com.xbeer.dao.BalanceCompositionAccumulateDao;
import com.xbeer.event.BaseEvent;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.mybatis.model.BalanceCompositionAccumulate;
import com.xbeer.util.DateUtil;
import com.xbeer.util.IDGenerator;


@Service
public class AccumulateBalanceEventHandler {
    
  private final  Logger logger = LoggerFactory.getLogger(AccumulateBalanceEventHandler.class);

  @Autowired
  BalanceCompositionAccumulateDao balanceCompositionAccumulateDao;
  
 
  
  @Transactional
  public Message handler(BaseEvent e){
    
   
    e.setTranSeqNo(IDGenerator.newTransactionSeq());
    
    String acctId = "11";
    String balaCompositionId = getBalaCompId(e.getTranCode());
    
    //取得事件对应的帐号，交易，找到交易对应的余额组成。累积对应的余额组成。
    BalanceCompositionAccumulate bca = balanceCompositionAccumulateDao.selectByAccount(acctId);
    
    if(null == bca)//如果没有累积数据，则增加一条
    {
      bca = new BalanceCompositionAccumulate();
      
      bca.setAcctId(acctId);
      bca.setActionDate(DateUtil.today());
      bca.setBalaCompId(balaCompositionId);
      bca.setDayCount(0);
      bca.setEventId(e.getEventId());
      bca.setInterestStartDate(DateUtil.today());
      bca.setInterestNumber(0);
      
      
      
    }else{//否则，判断是否是当天
      if(DateUtil.isToday(bca.getInterestStartDate())){
        //如果是当天，则对发生额进行累积
         //借记交易，累积借方金额balance_deposit
        //贷记交易，累积贷方金额balance_withdraw
        
        
        
        
        
      }
      
    }
    
    logger.info("bca:{}",bca.getInterestStartDate());
    
   //save account action
   
   
   
   
   
   //put event
   
   
   
   
   
   
   
    
    
    return MessageFactory.newSuccessMessage(MessageConstants.MessageText.TRANSFER_SUCCESS);
    
    
  }


/**
 * 根据交易码找出对应的余额组成。
 * 需要建立交易码与余额组成的关系表
 * */
  private String getBalaCompId(String tranCode) {
    
    return "1";
  }
  
}
