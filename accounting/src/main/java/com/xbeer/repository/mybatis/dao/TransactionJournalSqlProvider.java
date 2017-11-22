package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.TransactionJournal;
import org.apache.ibatis.jdbc.SQL;

public class TransactionJournalSqlProvider {

    public String insertSelective(TransactionJournal record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_transaction_journal");
        
        if (record.getSeqNo() != null) {
            sql.VALUES("seq_no", "#{seqNo,jdbcType=BIGINT}");
        }
        
        if (record.getTranId() != null) {
            sql.VALUES("tran_id", "#{tranId,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiId() != null) {
            sql.VALUES("busi_id", "#{busiId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTranType() != null) {
            sql.VALUES("tran_type", "#{tranType,jdbcType=INTEGER}");
        }
        
        if (record.getBranch() != null) {
            sql.VALUES("branch", "#{branch,jdbcType=VARCHAR}");
        }
        
        if (record.getTellerId() != null) {
            sql.VALUES("teller_id", "#{tellerId,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiType() != null) {
            sql.VALUES("busi_type", "#{busiType,jdbcType=VARCHAR}");
        }
        
        if (record.getChannelType() != null) {
            sql.VALUES("channel_type", "#{channelType,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TransactionJournal record) {
        SQL sql = new SQL();
        sql.UPDATE("t_transaction_journal");
        
        if (record.getTranId() != null) {
            sql.SET("tran_id = #{tranId,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiId() != null) {
            sql.SET("busi_id = #{busiId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTranType() != null) {
            sql.SET("tran_type = #{tranType,jdbcType=INTEGER}");
        }
        
        if (record.getBranch() != null) {
            sql.SET("branch = #{branch,jdbcType=VARCHAR}");
        }
        
        if (record.getTellerId() != null) {
            sql.SET("teller_id = #{tellerId,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiType() != null) {
            sql.SET("busi_type = #{busiType,jdbcType=VARCHAR}");
        }
        
        if (record.getChannelType() != null) {
            sql.SET("channel_type = #{channelType,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{uuid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("seq_no = #{seqNo,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}