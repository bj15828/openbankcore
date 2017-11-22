package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.AccountActionJournal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AccountActionJournalMapper {
    @Delete({
        "delete from t_account_action_journal",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long seqNo);

    @Insert({
        "insert into t_account_action_journal (seq_no, acct_id, ",
        "create_time, action, ",
        "amount, before_balance, ",
        "after_balance, tran_uuid, ",
        "tran_seq_no, url_context, ",
        "tran_code, rid)",
        "values (#{seqNo,jdbcType=BIGINT}, #{acctId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{action,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=DOUBLE}, #{beforeBalance,jdbcType=DOUBLE}, ",
        "#{afterBalance,jdbcType=DOUBLE}, #{tranUuid,jdbcType=VARCHAR}, ",
        "#{tranSeqNo,jdbcType=VARCHAR}, #{urlContext,jdbcType=VARCHAR}, ",
        "#{tranCode,jdbcType=VARCHAR}, #{rid,jdbcType=BIGINT})"
    })
    int insert(AccountActionJournal record);

    @InsertProvider(type=AccountActionJournalSqlProvider.class, method="insertSelective")
    int insertSelective(AccountActionJournal record);

    @Select({
        "select",
        "seq_no, acct_id, create_time, action, amount, before_balance, after_balance, ",
        "tran_uuid, tran_seq_no, url_context, tran_code, rid",
        "from t_account_action_journal",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="seq_no", property="seqNo", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="acct_id", property="acctId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="action", property="action", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="before_balance", property="beforeBalance", jdbcType=JdbcType.DOUBLE),
        @Result(column="after_balance", property="afterBalance", jdbcType=JdbcType.DOUBLE),
        @Result(column="tran_uuid", property="tranUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="tran_seq_no", property="tranSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_context", property="urlContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="tran_code", property="tranCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="rid", property="rid", jdbcType=JdbcType.BIGINT)
    })
    AccountActionJournal selectByPrimaryKey(Long seqNo);

    @UpdateProvider(type=AccountActionJournalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccountActionJournal record);

    @Update({
        "update t_account_action_journal",
        "set acct_id = #{acctId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "action = #{action,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=DOUBLE},",
          "before_balance = #{beforeBalance,jdbcType=DOUBLE},",
          "after_balance = #{afterBalance,jdbcType=DOUBLE},",
          "tran_uuid = #{tranUuid,jdbcType=VARCHAR},",
          "tran_seq_no = #{tranSeqNo,jdbcType=VARCHAR},",
          "url_context = #{urlContext,jdbcType=VARCHAR},",
          "tran_code = #{tranCode,jdbcType=VARCHAR},",
          "rid = #{rid,jdbcType=BIGINT}",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AccountActionJournal record);
}