package com.xbeer.mybatis.dao;

import com.xbeer.mybatis.model.BalanceCompositionAccumulate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BalanceCompositionAccumulateMapper {
    @Delete({
        "delete from t_balance_composition_accumulate",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long seqNo);

    @Insert({
        "insert into t_balance_composition_accumulate (seq_no, acct_id, ",
        "bala_comp_id, action_date, ",
        "balance_deposit, balance_withdraw, ",
        "interest_start_date, interest_end_date, ",
        "day_count, interest_number, ",
        "event_id)",
        "values (#{seqNo,jdbcType=BIGINT}, #{acctId,jdbcType=VARCHAR}, ",
        "#{balaCompId,jdbcType=VARCHAR}, #{actionDate,jdbcType=DATE}, ",
        "#{balanceDeposit,jdbcType=DOUBLE}, #{balanceWithdraw,jdbcType=DOUBLE}, ",
        "#{interestStartDate,jdbcType=DATE}, #{interestEndDate,jdbcType=DATE}, ",
        "#{dayCount,jdbcType=INTEGER}, #{interestNumber,jdbcType=INTEGER}, ",
        "#{eventId,jdbcType=BIGINT})"
    })
    int insert(BalanceCompositionAccumulate record);

    @InsertProvider(type=BalanceCompositionAccumulateSqlProvider.class, method="insertSelective")
    int insertSelective(BalanceCompositionAccumulate record);

    @Select({
        "select",
        "seq_no, acct_id, bala_comp_id, action_date, balance_deposit, balance_withdraw, ",
        "interest_start_date, interest_end_date, day_count, interest_number, event_id",
        "from t_balance_composition_accumulate",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
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
        @Result(column="interest_number", property="interestNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="event_id", property="eventId", jdbcType=JdbcType.BIGINT)
    })
    BalanceCompositionAccumulate selectByPrimaryKey(Long seqNo);

    @UpdateProvider(type=BalanceCompositionAccumulateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BalanceCompositionAccumulate record);

    @Update({
        "update t_balance_composition_accumulate",
        "set acct_id = #{acctId,jdbcType=VARCHAR},",
          "bala_comp_id = #{balaCompId,jdbcType=VARCHAR},",
          "action_date = #{actionDate,jdbcType=DATE},",
          "balance_deposit = #{balanceDeposit,jdbcType=DOUBLE},",
          "balance_withdraw = #{balanceWithdraw,jdbcType=DOUBLE},",
          "interest_start_date = #{interestStartDate,jdbcType=DATE},",
          "interest_end_date = #{interestEndDate,jdbcType=DATE},",
          "day_count = #{dayCount,jdbcType=INTEGER},",
          "interest_number = #{interestNumber,jdbcType=INTEGER},",
          "event_id = #{eventId,jdbcType=BIGINT}",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BalanceCompositionAccumulate record);
}