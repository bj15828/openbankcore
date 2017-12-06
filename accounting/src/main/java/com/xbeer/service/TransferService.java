package com.xbeer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.constants.MessageConstants;
import com.xbeer.constants.MessageConstants.MessageCode;
import com.xbeer.event.BaseEvent;
import com.xbeer.event.TransferEvent;
import com.xbeer.exception.BaseException;
import com.xbeer.helper.TransactionHelper;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.model.Account;
import com.xbeer.notify.NotifyManager;
import com.xbeer.repository.AccountRepository;
import com.xbeer.repository.EventRepository;
import com.xbeer.repository.TransactionRepository;
import com.xbeer.repository.mybatis.TransactionJournal;
import com.xbeer.util.IDGenerator;
import com.xbeer.util.JsonUtil;
import com.xbeer.util.ObjectUtil;


@Service
public class TransferService {

  private final Logger logger = LoggerFactory.getLogger(TransferService.class);



  @Autowired
  AccountRepository accountRepository;

  @Autowired
  TransactionRepository transRepository;

  @Autowired
  EventRepository eventRepository;

  /**
   * 消息回调接口
   */
  public Message transferCallBack(String tranSeqNo) {



    return null;
  }



  @Transactional
  public Message transfer(String acct_from, String acct_to, double amount, BaseRequestCommand cmd)
      throws BaseException {



    // 账户状态检查

    Account fromAcct = accountRepository.getAccount(acct_from,
        AccountRepository.AccountParam.ONLY_BALANCE, AccountRepository.AccountParam.ONLY_RID);
    if (ObjectUtil.isNull(fromAcct)) {
      return MessageFactory.newMessage(MessageCode.ACCOUNT_NOT_EXISTS, acct_from);

    }

    Account toAcct = accountRepository.getAccount(acct_to,
        AccountRepository.AccountParam.ONLY_BALANCE, AccountRepository.AccountParam.ONLY_RID);

    if (ObjectUtil.isNull(toAcct)) {

      return MessageFactory.newMessage(MessageCode.ACCOUNT_NOT_EXISTS, acct_to);

    }
    TransactionJournal tranRecord = TransactionHelper.fromCommand(cmd);
    cmd.setTranSeqNo(tranRecord.getSeqNo());



    TransferEvent e = (TransferEvent) new TransferEvent(IDGenerator.newEventId()).fromCommand(cmd);



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



    // save acct
    try {
      accountRepository.saveAccount(fromAcct);
      accountRepository.saveAccount(toAcct);
    } catch (Exception e1) {

      logger.error(e1.getLocalizedMessage());
      throw new BaseException(e1);
    }

    // save transaction



    try {
      Message transMsg = transRepository.saveTrans(tranRecord);

      if (!transMsg.isOk()) {

        throw new BaseException(MessageFactory
            .newMessage(MessageConstants.MessageCode.INERNAL_ERROR, "记录数据流水失败").getMsg());
        // 通过错误对帐号更改的冲正
      }
    } catch (Exception e2) {
      logger.error(e2.getLocalizedMessage());
      throw new BaseException(e2);
    }

    // save event
    try {



      Message saveMsg = eventRepository.saveEvent(e);
      if (!saveMsg.isOk()) {

        throw new BaseException(
            MessageFactory.newMessage(MessageConstants.MessageCode.INERNAL_ERROR, "事件写入").getMsg());
        // 通过错误对帐号更改的冲正
      }

    } catch (Exception e3) {

      logger.error(e3.getLocalizedMessage());
      throw new BaseException(e3);

    }

    // put event
    // 使用transJournal的流水作为事务的ID，callback时以该ID查询数据库是否存在，若为事务性Notify
    NotifyManager.send("account.transfer", JsonUtil.object2Json(e), tranRecord.getSeqNo());

    return MessageFactory.newSuccessMessage(MessageConstants.MessageText.TRANSFER_SUCCESS);


  }

}
