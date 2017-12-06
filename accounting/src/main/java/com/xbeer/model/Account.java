package com.xbeer.model;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xbeer.constants.ActionConstants;
import com.xbeer.constants.MessageConstants;
import com.xbeer.event.BaseEvent;
import com.xbeer.event.NewAccountEvent;
import com.xbeer.event.TransferEvent;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.repository.mybatis.AccountActionJournal;
import com.xbeer.repository.mybatis.AccountBalance;
import com.xbeer.repository.mybatis.AccountInfo;
import com.xbeer.repository.mybatis.AccountRid;
import com.xbeer.util.DateUtil;
import com.xbeer.util.DecimalUtil;
import com.xbeer.util.IDGenerator;


@Component
public class Account {
  
  private final Logger logger = LoggerFactory.getLogger(Account.class);

  
  public static int WITHWRAW = 1;

  AccountBalance acctBalance;
  
  AccountInfo acctInfo;
  AccountRid rid;

  ReentrantLock lock = new ReentrantLock();// lock the rid


  AccountActionJournal tmpJournal;
  
  


  public Message transferTo(TransferEvent e, Account b, double money) {



    double diff = DecimalUtil.sub(this.acctBalance.getBalance(), money);

    if (diff < 0) {
      // 金额不够

      return MessageFactory.newMessage(MessageConstants.MessageCode.ACCOUNT_HAS_NOT_ENOUGH_MONEY,
          acctBalance.getAcctId());


    }
    
    //increase and decrease
    this.decreaseBalance(e, money);
    
    b.increaseBalance(e, money);
    
   


    return MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS);



  }


  public Message newAccount(NewAccountEvent e) {
    return null;
  }



  public Message increaseBalance(TransferEvent e, double money) {

    tmpJournal = newAccountActionJournal(e,money);
    tmpJournal.setAction(ActionConstants.Types.DEPOSIT.getCode());
  
    

    this.acctBalance.setBalance(DecimalUtil.add(this.acctBalance.getBalance(), money));

    tmpJournal.setAfterBalance(this.acctBalance.getBalance());
    
    //set last modi time
    Date lastModiTime  = DateUtil.today();
   
    this.getAcctBalance().setLastModiTime(lastModiTime);
    
    // 增加锁
    this.inrRid();

    return MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS);
  }

  public Message decreaseBalance(TransferEvent e, double money) {

    tmpJournal = newAccountActionJournal(e,money);
    tmpJournal.setAction(ActionConstants.Types.WITH_DRAW.getCode());
    

    this.acctBalance.setBalance(DecimalUtil.sub(this.acctBalance.getBalance(), money));
    tmpJournal.setAfterBalance(this.acctBalance.getBalance());
    
    //set last modi time
    Date lastModiTime  = DateUtil.today();
   
    this.getAcctBalance().setLastModiTime(lastModiTime);
    
    // 增加锁
    this.inrRid();

    return MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS);
  }


  private AccountActionJournal newAccountActionJournal(BaseEvent e,double money) {

    AccountActionJournal tmpJournal = new AccountActionJournal();


    tmpJournal.setAcctId(this.acctBalance.getAcctId());
    tmpJournal.setBeforeBalance(this.getAcctBalance().getBalance());
    tmpJournal.setAmount(money);

    tmpJournal.setCreateTime(DateUtil.today());
    tmpJournal.setRid(this.rid.getRid());
    tmpJournal.setSeqNo(IDGenerator.newActionId());
    tmpJournal.setTranCode(e.getTranCode());
    tmpJournal.setTranSeqNo(e.getTranSeqNo());
    tmpJournal.setTranUuid(e.getUuid());
    tmpJournal.setUrlContext(e.getUrlContext());

    return tmpJournal;
  }



  public void inrRid() {

    
    rid.setRid(rid.getRid() + 1);


  }



  public AccountBalance getAcctBalance() {
    return acctBalance;
  }









  public AccountInfo getAcctInfo() {
    return acctInfo;
  }






  public AccountRid getRid() {
    return rid;
  }




  public AccountActionJournal getTmpJournal() {
    return tmpJournal;
  }

  public Account withBalance(AccountBalance ban) {

    this.acctBalance = ban;
    return this;
  }

  public Account withInfo(AccountInfo info) {

    this.acctInfo = info;
    return this;
  }

  public Account withRid(AccountRid rid1) {

    this.rid = rid1;
    return this;
  }




}
