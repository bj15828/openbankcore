package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountActionJournal;
import org.apache.ibatis.jdbc.SQL;

public class AccountActionJournalSqlProvider {

    public String insertSelective(AccountActionJournal record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_account_action_journal");
        
        if (record.getSeqNo() != null) {
            sql.VALUES("seq_no", "#{seqNo,jdbcType=BIGINT}");
        }
        
        if (record.getAcctId() != null) {
            sql.VALUES("acct_id", "#{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAction() != null) {
            sql.VALUES("action", "#{action,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=DOUBLE}");
        }
        
        if (record.getBeforeBalance() != null) {
            sql.VALUES("before_balance", "#{beforeBalance,jdbcType=DOUBLE}");
        }
        
        if (record.getAfterBalance() != null) {
            sql.VALUES("after_balance", "#{afterBalance,jdbcType=DOUBLE}");
        }
        
        if (record.getTranUuid() != null) {
            sql.VALUES("tran_uuid", "#{tranUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getTranSeqNo() != null) {
            sql.VALUES("tran_seq_no", "#{tranSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUrlContext() != null) {
            sql.VALUES("url_context", "#{urlContext,jdbcType=VARCHAR}");
        }
        
        if (record.getTranCode() != null) {
            sql.VALUES("tran_code", "#{tranCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRid() != null) {
            sql.VALUES("rid", "#{rid,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AccountActionJournal record) {
        SQL sql = new SQL();
        sql.UPDATE("t_account_action_journal");
        
        if (record.getAcctId() != null) {
            sql.SET("acct_id = #{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAction() != null) {
            sql.SET("action = #{action,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=DOUBLE}");
        }
        
        if (record.getBeforeBalance() != null) {
            sql.SET("before_balance = #{beforeBalance,jdbcType=DOUBLE}");
        }
        
        if (record.getAfterBalance() != null) {
            sql.SET("after_balance = #{afterBalance,jdbcType=DOUBLE}");
        }
        
        if (record.getTranUuid() != null) {
            sql.SET("tran_uuid = #{tranUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getTranSeqNo() != null) {
            sql.SET("tran_seq_no = #{tranSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUrlContext() != null) {
            sql.SET("url_context = #{urlContext,jdbcType=VARCHAR}");
        }
        
        if (record.getTranCode() != null) {
            sql.SET("tran_code = #{tranCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRid() != null) {
            sql.SET("rid = #{rid,jdbcType=BIGINT}");
        }
        
        sql.WHERE("seq_no = #{seqNo,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}