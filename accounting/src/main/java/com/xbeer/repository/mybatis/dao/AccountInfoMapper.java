package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AccountInfoMapper {
    @Delete({
        "delete from t_account_info",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String acctId);

    @Insert({
        "insert into t_account_info (acct_id, stats, ",
        "create_time, busi_type, ",
        "product_id, master_or_primary, ",
        "is_calculate_interest)",
        "values (#{acctId,jdbcType=VARCHAR}, #{stats,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{busiType,jdbcType=INTEGER}, ",
        "#{productId,jdbcType=VARCHAR}, #{masterOrPrimary,jdbcType=INTEGER}, ",
        "#{isCalculateInterest,jdbcType=INTEGER})"
    })
    int insert(AccountInfo record);

    @InsertProvider(type=AccountInfoSqlProvider.class, method="insertSelective")
    int insertSelective(AccountInfo record);

    @Select({
        "select",
        "acct_id, stats, create_time, busi_type, product_id, master_or_primary, is_calculate_interest",
        "from t_account_info",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="stats", property="stats", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="busi_type", property="busiType", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_or_primary", property="masterOrPrimary", jdbcType=JdbcType.INTEGER),
        @Result(column="is_calculate_interest", property="isCalculateInterest", jdbcType=JdbcType.INTEGER)
    })
    AccountInfo selectByPrimaryKey(String acctId);

    @UpdateProvider(type=AccountInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccountInfo record);

    @Update({
        "update t_account_info",
        "set stats = #{stats,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "busi_type = #{busiType,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "master_or_primary = #{masterOrPrimary,jdbcType=INTEGER},",
          "is_calculate_interest = #{isCalculateInterest,jdbcType=INTEGER}",
        "where acct_id = #{acctId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccountInfo record);
}