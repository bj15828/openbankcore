package com.xbeer.repository.daoadapter;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Primary;

import com.xbeer.repository.mybatis.AccountBalance;
import com.xbeer.repository.mybatis.dao.AccountBalanceMapper;


@Primary
public interface AccountBalanceDaoAdapter extends AccountBalanceMapper  {
  @Select({
    "select",
    "acct_id, balance, frozen_amount, last_modi_time",
    "from t_account_balance",
    "where acct_id = #{acctId,jdbcType=VARCHAR} for update"
})
@Results({
    @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR, id=true),
    @Result(column="balance", property="balance", jdbcType=JdbcType.DOUBLE),
    @Result(column="frozen_amount", property="frozenAmount", jdbcType=JdbcType.DOUBLE),
    @Result(column="last_modi_time", property="lastModiTime", jdbcType=JdbcType.TIMESTAMP)
})  AccountBalance selectByPrimaryKeyForUpdate(String acctId);

}
