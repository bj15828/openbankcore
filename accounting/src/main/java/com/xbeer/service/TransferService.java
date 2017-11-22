package com.xbeer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xbeer.constants.MessageConstants;
import com.xbeer.constants.EventConstants.EventType;
import com.xbeer.constants.MessageConstants.MessageCode;
import com.xbeer.event.TransferEvent;
import com.xbeer.exception.BaseException;
import com.xbeer.helper.RidHelper;
import com.xbeer.helper.TransactionHelper;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.model.Account;
import com.xbeer.net.BaseRequestCommand;
import com.xbeer.notify.NotifyManager;
import com.xbeer.repository.AccountRepository;
import com.xbeer.repository.daoadapter.AccountActionJournalDaoAdapter;
import com.xbeer.repository.daoadapter.AccountBalanceDaoAdapter;
import com.xbeer.repository.daoadapter.AccountRidDaoAdapter;
import com.xbeer.repository.mybatis.AccountActionJournal;
import com.xbeer.repository.mybatis.AccountRid;
import com.xbeer.repository.mybatis.TransactionJournal;
import com.xbeer.repository.mybatis.dao.TransactionJournalMapper;
import com.xbeer.util.DateUtil;
import com.xbeer.util.DecimalUtil;
import com.xbeer.util.IDGenerator;
import com.xbeer.util.ObjectUtil;


@Service
public class TransferService {

  private final Logger logger = LoggerFactory.getLogger(TransferService.class);



  @Autowired
  AccountRepository accountRepository;

  @Autowired
  TransactionJournalMapper transDao;

  @Transactional
  public Message transfer(String acct_from, String acct_to, double amount, BaseRequestCommand cmd)
      throws BaseException {
    NotifyManager.send("account.a", "asdfasf");

    // 账户状态检查

    Account fromAcct = accountRepository.getAccount(acct_from,
        AccountRepository.AccountParam.ONLY_BALANCE, AccountRepository.AccountParam.ONLY_RID);
    if (ObjectUtil.isNull(fromAcct)) {
      return MessageFactory.newMessage(MessageCode.ACCOUNT_NOT_EXISTS, acct_from);

    }
    logger.info("debug4");
    Account toAcct = accountRepository.getAccount(acct_to,
        AccountRepository.AccountParam.ONLY_BALANCE, AccountRepository.AccountParam.ONLY_RID);

    if (ObjectUtil.isNull(toAcct)) {

      return MessageFactory.newMessage(MessageCode.ACCOUNT_NOT_EXISTS, acct_to);

    }
    logger.info("debug13");
    TransferEvent e = new TransferEvent(IDGenerator.newEventId(), EventType.TRANSFER_EVENT);
    e.setCreateDate(DateUtil.today());
    e.setOrgCmd(cmd);
    e.setTranCode(cmd.getTranCode());
    e.setTranSeqNo(cmd.getTranSeqNo());
    e.setUrlContext(cmd.getUrlContext());

    e.setUuid(cmd.getHeader().getUuid());
    logger.info("debug2");
    // 金额是否够
    Message resultMsg = null;
    try {
      resultMsg = fromAcct.transferTo(e, toAcct, amount);
    } catch (Exception e1) {

      e1.printStackTrace();
    }

    if (!resultMsg.isOk()) {//


      return resultMsg;
    }

    logger.info("debug1");

    // save acct
    try {
      accountRepository.saveAccount(fromAcct);
      accountRepository.saveAccount(toAcct);
    } catch (Exception e1) {

      e1.printStackTrace();
      throw new BaseException(e1);
    }

    // save transaction

    TransactionJournal tranRecord = TransactionHelper.fromCommand(cmd);


    // transDao.insert(tranRecord);


    //// save account action and Rid

    /**
     * 设置状态机
     */



    // put event



    return MessageFactory.newSuccessMessage(MessageConstants.MessageText.TRANSFER_SUCCESS);


  }

}