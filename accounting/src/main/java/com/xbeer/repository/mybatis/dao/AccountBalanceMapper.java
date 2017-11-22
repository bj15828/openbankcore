package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountBalance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AccountBalanceMapper {
    @Delete({
        "delete from t_account_balance",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String acctId);

    @Insert({
        "insert into t_account_balance (acct_id, balance, ",
        "frozen_amount, last_modi_time)",
        "values (#{acctId,jdbcType=VARCHAR}, #{balance,jdbcType=DOUBLE}, ",
        "#{frozenAmount,jdbcType=DOUBLE}, #{lastModiTime,jdbcType=TIMESTAMP})"
    })
    int insert(AccountBalance record);

    @InsertProvider(type=AccountBalanceSqlProvider.class, method="insertSelective")
    int insertSelective(AccountBalance record);

    @Select({
        "select",
        "acct_id, balance, frozen_amount, last_modi_time",
        "from t_account_balance",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DOUBLE),
        @Result(column="frozen_amount", property="frozenAmount", jdbcType=JdbcType.DOUBLE),
        @Result(column="last_modi_time", property="lastModiTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AccountBalance selectByPrimaryKey(String acctId);

    @UpdateProvider(type=AccountBalanceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccountBalance record);

    @Update({
        "update t_account_balance",
        "set balance = #{balance,jdbcType=DOUBLE},",
          "frozen_amount = #{frozenAmount,jdbcType=DOUBLE},",
          "last_modi_time = #{lastModiTime,jdbcType=TIMESTAMP}",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccountBalance record);
}