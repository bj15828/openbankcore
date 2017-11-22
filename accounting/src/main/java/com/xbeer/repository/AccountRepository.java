package com.xbeer.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbeer.constants.MessageConstants;
import com.xbeer.helper.AccountHelper;
import com.xbeer.message.Message;
import com.xbeer.message.MessageFactory;
import com.xbeer.model.Account;
import com.xbeer.repository.daoadapter.AccountActionJournalDaoAdapter;
import com.xbeer.repository.daoadapter.AccountBalanceDaoAdapter;
import com.xbeer.repository.daoadapter.AccountInfoDaoAdapter;
import com.xbeer.repository.daoadapter.AccountRidDaoAdapter;
import com.xbeer.repository.mybatis.AccountBalance;
import com.xbeer.repository.mybatis.AccountInfo;
import com.xbeer.repository.mybatis.AccountRid;
import com.xbeer.util.ObjectUtil;

@Component

public class AccountRepository {
  private final Logger logger = LoggerFactory.getLogger(AccountRepository.class);


  public static enum AccountParam {
    ALL, ONLY_BALANCE, ONLY_INFO, ONLY_RID
  }

  @Autowired
  AccountBalanceDaoAdapter accountBalanceDao;

  @Autowired
  AccountInfoDaoAdapter accountInfoDao;

  @Autowired
  AccountActionJournalDaoAdapter accountActionJouranlDao;

  @Autowired
  AccountRidDaoAdapter ridDao;

  @Autowired
  AccountActionJournalDaoAdapter accountActionJournalDao;

  /**
   * 从存储中读取account模型 如果type为空，则表示读取所有信息帐号信息
   * 
   * @param acctId 帐号ID
   * @param type balance,info,rid,以后可增加
   * 
   */
  public Account getAccount(String acctId, AccountParam... types) {
    Account a = null;

    if (ObjectUtil.isNull(types) || AccountParam.ALL == types[0]) {
      AccountBalance acctBalance = accountBalanceDao.selectByPrimaryKeyForUpdate(acctId);

      if (ObjectUtil.isNull(acctBalance))
        return a;

      a = AccountHelper.newAccount().withBalance(acctBalance);

      AccountInfo acctInfo = accountInfoDao.selectByPrimaryKey(acctId);
      AccountRid rid = ridDao.selectByPrimaryKey(acctId);

      a.withInfo(acctInfo).withRid(rid);



    } else {

      for (AccountParam type : types) {
        if (AccountParam.ONLY_BALANCE == type) {


          AccountBalance acctBalance = accountBalanceDao.selectByPrimaryKeyForUpdate(acctId);

          if (!ObjectUtil.isNull(acctBalance)) {
            if (ObjectUtil.isNull(a))
              a = AccountHelper.newAccount();
            a.withBalance(acctBalance);
          }


        }
        if (AccountParam.ONLY_INFO == type) {


          AccountInfo acctInfo = accountInfoDao.selectByPrimaryKey(acctId);

          if (!ObjectUtil.isNull(acctInfo)) {

            if (ObjectUtil.isNull(a))
              a = AccountHelper.newAccount();
            a.withInfo(acctInfo);
          }


        }
        if (AccountParam.ONLY_RID == type) {


          AccountRid rid = ridDao.selectByPrimaryKey(acctId);



          if (ObjectUtil.isNull(rid)) {
            rid = new AccountRid();
            rid.setRid(1L);
            rid.setAcctId(acctId);
          }
          if (ObjectUtil.isNull(a))
            a = AccountHelper.newAccount();
          
          a.withRid(rid);

        }
      }


    }



    return a;
  }

  public Message saveAccount(Account acct) {

    if (ObjectUtil.isNull(acct))
      return MessageFactory.newMessage(MessageConstants.MessageCode.NOT_NULL, "acct");

    if (!ObjectUtil.isNull(acct.getAcctInfo())) {
      accountInfoDao.updateByPrimaryKey(acct.getAcctInfo());

    }
    if (!ObjectUtil.isNull(acct.getAcctBalance())) {
      accountBalanceDao.updateByPrimaryKey(acct.getAcctBalance());

    }
    if (!ObjectUtil.isNull(acct.getRid())) {
      ridDao.insertOrIncr(acct.getRid());

    }
    if (!ObjectUtil.isNull(acct.getTmpJournal())) {
      accountActionJournalDao.insert(acct.getTmpJournal());

    }


    return MessageFactory.newMessage(MessageConstants.MessageCode.SUCCESS);
  }



}
