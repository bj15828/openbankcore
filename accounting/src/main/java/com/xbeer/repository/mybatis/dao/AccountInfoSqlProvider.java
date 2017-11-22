package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountInfo;
import org.apache.ibatis.jdbc.SQL;

public class AccountInfoSqlProvider {

    public String insertSelective(AccountInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_account_info");
        
        if (record.getAcctId() != null) {
            sql.VALUES("acct_id", "#{acctId,jdbcType=VARCHAR}");
        }
        
        if (record.getStats() != null) {
            sql.VALUES("stats", "#{stats,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBusiType() != null) {
            sql.VALUES("busi_type", "#{busiType,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterOrPrimary() != null) {
            sql.VALUES("master_or_primary", "#{masterOrPrimary,jdbcType=INTEGER}");
        }
        
        if (record.getIsCalculateInterest() != null) {
            sql.VALUES("is_calculate_interest", "#{isCalculateInterest,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AccountInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("t_account_info");
        
        if (record.getStats() != null) {
            sql.SET("stats = #{stats,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBusiType() != null) {
            sql.SET("busi_type = #{busiType,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterOrPrimary() != null) {
            sql.SET("master_or_primary = #{masterOrPrimary,jdbcType=INTEGER}");
        }
        
        if (record.getIsCalculateInterest() != null) {
            sql.SET("is_calculate_interest = #{isCalculateInterest,jdbcType=INTEGER}");
        }
        
        sql.WHERE("acct_id = #{acctId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}