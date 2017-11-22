package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.BalanceCompositionAccumulate;
import org.apache.ibatis.jdbc.SQL;

public class BalanceCompositionAccumulateSqlProvider {

    public String insertSelective(BalanceCompositionAccumulate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_balance_composition_accumulate");
        
        if (record.getSeqNo() != null) {
            sql.VALUES("seq_no", "#{seqNo,jdbcType=BIGINT}");
        }
        
        if (record.getAcctId() != null) {
            sql.VALUES("acct_id", "#{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getBalaCompId() != null) {
            sql.VALUES("bala_comp_id", "#{balaCompId,jdbcType=VARCHAR}");
        }
        
        if (record.getActionDate() != null) {
            sql.VALUES("action_date", "#{actionDate,jdbcType=DATE}");
        }
        
        if (record.getBalanceDeposit() != null) {
            sql.VALUES("balance_deposit", "#{balanceDeposit,jdbcType=DOUBLE}");
        }
        
        if (record.getBalanceWithdraw() != null) {
            sql.VALUES("balance_withdraw", "#{balanceWithdraw,jdbcType=DOUBLE}");
        }
        
        if (record.getInterestStartDate() != null) {
            sql.VALUES("interest_start_date", "#{interestStartDate,jdbcType=DATE}");
        }
        
        if (record.getInterestEndDate() != null) {
            sql.VALUES("interest_end_date", "#{interestEndDate,jdbcType=DATE}");
        }
        
        if (record.getDayCount() != null) {
            sql.VALUES("day_count", "#{dayCount,jdbcType=INTEGER}");
        }
        
        if (record.getInterestNumber() != null) {
            sql.VALUES("interest_number", "#{interestNumber,jdbcType=INTEGER}");
        }
        
        if (record.getEventId() != null) {
            sql.VALUES("event_id", "#{eventId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BalanceCompositionAccumulate record) {
        SQL sql = new SQL();
        sql.UPDATE("t_balance_composition_accumulate");
        
        if (record.getAcctId() != null) {
            sql.SET("acct_id = #{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getBalaCompId() != null) {
            sql.SET("bala_comp_id = #{balaCompId,jdbcType=VARCHAR}");
        }
        
        if (record.getActionDate() != null) {
            sql.SET("action_date = #{actionDate,jdbcType=DATE}");
        }
        
        if (record.getBalanceDeposit() != null) {
            sql.SET("balance_deposit = #{balanceDeposit,jdbcType=DOUBLE}");
        }
        
        if (record.getBalanceWithdraw() != null) {
            sql.SET("balance_withdraw = #{balanceWithdraw,jdbcType=DOUBLE}");
        }
        
        if (record.getInterestStartDate() != null) {
            sql.SET("interest_start_date = #{interestStartDate,jdbcType=DATE}");
        }
        
        if (record.getInterestEndDate() != null) {
            sql.SET("interest_end_date = #{interestEndDate,jdbcType=DATE}");
        }
        
        if (record.getDayCount() != null) {
            sql.SET("day_count = #{dayCount,jdbcType=INTEGER}");
        }
        
        if (record.getInterestNumber() != null) {
            sql.SET("interest_number = #{interestNumber,jdbcType=INTEGER}");
        }
        
        if (record.getEventId() != null) {
            sql.SET("event_id = #{eventId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("seq_no = #{seqNo,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}