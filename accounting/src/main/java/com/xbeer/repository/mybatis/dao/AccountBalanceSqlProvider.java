package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountBalance;
import org.apache.ibatis.jdbc.SQL;

public class AccountBalanceSqlProvider {

    public String insertSelective(AccountBalance record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_account_balance");
        
        if (record.getAcctId() != null) {
            sql.VALUES("acct_id", "#{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getBalance() != null) {
            sql.VALUES("balance", "#{balance,jdbcType=DOUBLE}");
        }
        
        if (record.getFrozenAmount() != null) {
            sql.VALUES("frozen_amount", "#{frozenAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getLastModiTime() != null) {
            sql.VALUES("last_modi_time", "#{lastModiTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AccountBalance record) {
        SQL sql = new SQL();
        sql.UPDATE("t_account_balance");
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{balance,jdbcType=DOUBLE}");
        }
        
        if (record.getFrozenAmount() != null) {
            sql.SET("frozen_amount = #{frozenAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getLastModiTime() != null) {
            sql.SET("last_modi_time = #{lastModiTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("acct_id = #{acctId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}