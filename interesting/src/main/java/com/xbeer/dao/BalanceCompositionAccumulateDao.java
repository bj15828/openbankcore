package com.xbeer.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Primary;

import com.xbeer.mybatis.dao.BalanceCompositionAccumulateMapper;
import com.xbeer.mybatis.model.BalanceCompositionAccumulate;

@Primary
public interface BalanceCompositionAccumulateDao extends BalanceCompositionAccumulateMapper{
    
  @Select({
    "select",
    "seq_no, acct_id, bala_comp_id, action_date, balance_deposit, balance_withdraw, ",
    "interest_start_date, interest_end_date, day_count, interest_number",
    "from t_balance_composition_accumulate",
    "where acct_id = #{account,jdbcType=VARCHAR} order by interest_start_date desc limit 1"
})
@Results({
    @Result(column="seq_no", property="seqNo", jdbcType=JdbcType.BIGINT, id=true),
    @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR),
    @Result(column="bala_comp_id", property="balaCompId", jdbcType=JdbcType.VARCHAR),
    @Result(column="action_date", property="actionDate", jdbcType=JdbcType.DATE),
    @Result(column="balance_deposit", property="balanceDeposit", jdbcType=JdbcType.DOUBLE),
    @Result(column="balance_withdraw", property="balanceWithdraw", jdbcType=JdbcType.DOUBLE),
    @Result(column="interest_start_date", property="interestStartDate", jdbcType=JdbcType.DATE),
    @Result(column="interest_end_date", property="interestEndDate", jdbcType=JdbcType.DATE),
    @Result(column="day_count", property="dayCount", jdbcType=JdbcType.INTEGER),
    @Result(column="interest_number", property="interestNumber", jdbcType=JdbcType.INTEGER)
})
BalanceCompositionAccumulate selectByAccount(String  account);
  
}
