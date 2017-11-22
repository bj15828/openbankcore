package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.TransactionJournal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TransactionJournalMapper {
    @Delete({
        "delete from t_transaction_journal",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long seqNo);

    @Insert({
        "insert into t_transaction_journal (seq_no, tran_id, ",
        "busi_id, create_time, ",
        "tran_type, branch, ",
        "teller_id, busi_type, ",
        "channel_type, detail, ",
        "uuid)",
        "values (#{seqNo,jdbcType=BIGINT}, #{tranId,jdbcType=VARCHAR}, ",
        "#{busiId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{tranType,jdbcType=INTEGER}, #{branch,jdbcType=VARCHAR}, ",
        "#{tellerId,jdbcType=VARCHAR}, #{busiType,jdbcType=VARCHAR}, ",
        "#{channelType,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{uuid,jdbcType=VARCHAR})"
    })
    int insert(TransactionJournal record);

    @InsertProvider(type=TransactionJournalSqlProvider.class, method="insertSelective")
    int insertSelective(TransactionJournal record);

    @Select({
        "select",
        "seq_no, tran_id, busi_id, create_time, tran_type, branch, teller_id, busi_type, ",
        "channel_type, detail, uuid",
        "from t_transaction_journal",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="seq_no", property="seqNo", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tran_id", property="tranId", jdbcType=JdbcType.VARCHAR),
        @Result(column="busi_id", property="busiId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="tran_type", property="tranType", jdbcType=JdbcType.INTEGER),
        @Result(column="branch", property="branch", jdbcType=JdbcType.VARCHAR),
        @Result(column="teller_id", property="tellerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="busi_type", property="busiType", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_type", property="channelType", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)
    })
    TransactionJournal selectByPrimaryKey(Long seqNo);

    @UpdateProvider(type=TransactionJournalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransactionJournal record);

    @Update({
        "update t_transaction_journal",
        "set tran_id = #{tranId,jdbcType=VARCHAR},",
          "busi_id = #{busiId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "tran_type = #{tranType,jdbcType=INTEGER},",
          "branch = #{branch,jdbcType=VARCHAR},",
          "teller_id = #{tellerId,jdbcType=VARCHAR},",
          "busi_type = #{busiType,jdbcType=VARCHAR},",
          "channel_type = #{channelType,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "uuid = #{uuid,jdbcType=VARCHAR}",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TransactionJournal record);
}