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
        
        if (record.getConsmrId() != null) {
            sql.VALUES("consmr_id", "#{consmrId,jdbcType=VARCHAR}");
        }
        
        if (record.getConsmrSeqNo() != null) {
            sql.VALUES("consmr_seq_no", "#{consmrSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgConsmrId() != null) {
            sql.VALUES("org_consmr_id", "#{orgConsmrId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgConsmrSeqNo() != null) {
            sql.VALUES("org_consmr_seq_no", "#{orgConsmrSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTranCode() != null) {
            sql.VALUES("tran_code", "#{tranCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnDt() != null) {
            sql.VALUES("txn_dt", "#{txnDt,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnTime() != null) {
            sql.VALUES("txn_time", "#{txnTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTranType() != null) {
            sql.VALUES("tran_type", "#{tranType,jdbcType=INTEGER}");
        }
        
        if (record.getChannelNo() != null) {
            sql.VALUES("channel_no", "#{channelNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getStats() != null) {
            sql.VALUES("stats", "#{stats,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TransactionJournal record) {
        SQL sql = new SQL();
        sql.UPDATE("t_transaction_journal");
        
        if (record.getConsmrId() != null) {
            sql.SET("consmr_id = #{consmrId,jdbcType=VARCHAR}");
        }
        
        if (record.getConsmrSeqNo() != null) {
            sql.SET("consmr_seq_no = #{consmrSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgConsmrId() != null) {
            sql.SET("org_consmr_id = #{orgConsmrId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgConsmrSeqNo() != null) {
            sql.SET("org_consmr_seq_no = #{orgConsmrSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTranCode() != null) {
            sql.SET("tran_code = #{tranCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnDt() != null) {
            sql.SET("txn_dt = #{txnDt,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnTime() != null) {
            sql.SET("txn_time = #{txnTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTranType() != null) {
            sql.SET("tran_type = #{tranType,jdbcType=INTEGER}");
        }
        
        if (record.getChannelNo() != null) {
            sql.SET("channel_no = #{channelNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getStats() != null) {
            sql.SET("stats = #{stats,jdbcType=INTEGER}");
        }
        
        sql.WHERE("seq_no = #{seqNo,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}