package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountRid;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AccountRidMapper {
    @Delete({
        "delete from t_account_rid",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String acctId);

    @Insert({
        "insert into t_account_rid (acct_id, rid)",
        "values (#{acctId,jdbcType=VARCHAR}, #{rid,jdbcType=BIGINT})"
    })
    int insert(AccountRid record);

    @InsertProvider(type=AccountRidSqlProvider.class, method="insertSelective")
    int insertSelective(AccountRid record);

    @Select({
        "select",
        "acct_id, rid",
        "from t_account_rid",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="rid", property="rid", jdbcType=JdbcType.BIGINT)
    })
    AccountRid selectByPrimaryKey(String acctId);

    @UpdateProvider(type=AccountRidSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccountRid record);

    @Update({
        "update t_account_rid",
        "set rid = #{rid,jdbcType=BIGINT}",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccountRid record);
}