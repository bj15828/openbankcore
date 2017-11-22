package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.BalanceComposition;
import org.apache.ibatis.jdbc.SQL;

public class BalanceCompositionSqlProvider {

    public String insertSelective(BalanceComposition record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_balance_composition");
        
        if (record.getBalaCompId() != null) {
            sql.VALUES("bala_comp_id", "#{balaCompId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getValueDate() != null) {
            sql.VALUES("value_date", "#{valueDate,jdbcType=DATE}");
        }
        
        if (record.getInterestRateId() != null) {
            sql.VALUES("interest_rate_id", "#{interestRateId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsCalcCompound() != null) {
            sql.VALUES("is_calc_compound", "#{isCalcCompound,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BalanceComposition record) {
        SQL sql = new SQL();
        sql.UPDATE("t_balance_composition");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getValueDate() != null) {
            sql.SET("value_date = #{valueDate,jdbcType=DATE}");
        }
        
        if (record.getInterestRateId() != null) {
            sql.SET("interest_rate_id = #{interestRateId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsCalcCompound() != null) {
            sql.SET("is_calc_compound = #{isCalcCompound,jdbcType=INTEGER}");
        }
        
        sql.WHERE("bala_comp_id = #{balaCompId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}