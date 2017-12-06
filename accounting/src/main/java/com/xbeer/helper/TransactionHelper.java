package com.xbeer.helper;

import org.assertj.core.util.DateUtil;

import com.xbeer.command.BaseRequestCommand;
import com.xbeer.repository.mybatis.TransactionJournal;
import com.xbeer.util.IDGenerator;

public class TransactionHelper {

  
  public static TransactionJournal fromCommand(BaseRequestCommand cmd){
    TransactionJournal tranRecord = new TransactionJournal();
    
    tranRecord.setSeqNo(IDGenerator.newTransactionSeq());
    tranRecord.setChannelNo(cmd.getHeader().getChnl_tp());
    tranRecord.setConsmrId(cmd.getHeader().getConsmr_id());
    tranRecord.setConsmrSeqNo(cmd.getHeader().getConsmr_seq_no());
    tranRecord.setCreateTime(DateUtil.now());
    tranRecord.setDetail(cmd.toJSON());
    
    tranRecord.setOrgConsmrId(cmd.getHeader().getOrg_consmr_id());
    tranRecord.setOrgConsmrSeqNo(cmd.getHeader().getOrg_consmr_seq_no());
    
    tranRecord.setTranCode(cmd.getHeader().getSvr_cd());
    tranRecord.setTranType(1);
    tranRecord.setTxnDt(cmd.getHeader().getTxn_dt());
    tranRecord.setTxnTime(cmd.getHeader().getTxn_time());
    
   
    
    tranRecord.setUuid(cmd.getHeader().getUuid());
    
    
    
    
    
    
    return tranRecord;
  }
}
