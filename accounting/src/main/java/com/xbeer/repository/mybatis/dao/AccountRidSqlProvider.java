package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountRid;
import org.apache.ibatis.jdbc.SQL;

public class AccountRidSqlProvider {

    public String insertSelective(AccountRid record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_account_rid");
        
        if (record.getAcctId() != null) {
            sql.VALUES("acct_id", "#{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getRid() != null) {
            sql.VALUES("rid", "#{rid,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AccountRid record) {
        SQL sql = new SQL();
        sql.UPDATE("t_account_rid");
        
        if (record.getRid() != null) {
            sql.SET("rid = #{rid,jdbcType=BIGINT}");
        }
        
        sql.WHERE("acct_id = #{acctId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}