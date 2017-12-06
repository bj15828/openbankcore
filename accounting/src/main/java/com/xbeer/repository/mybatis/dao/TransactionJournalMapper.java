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
        "insert into t_transaction_journal (seq_no, consmr_id, ",
        "consmr_seq_no, org_consmr_id, ",
        "org_consmr_seq_no, tran_code, ",
        "txn_dt, txn_time, ",
        "create_time, tran_type, ",
        "channel_no, detail, ",
        "uuid, stats)",
        "values (#{seqNo,jdbcType=BIGINT}, #{consmrId,jdbcType=VARCHAR}, ",
        "#{consmrSeqNo,jdbcType=VARCHAR}, #{orgConsmrId,jdbcType=VARCHAR}, ",
        "#{orgConsmrSeqNo,jdbcType=VARCHAR}, #{tranCode,jdbcType=VARCHAR}, ",
        "#{txnDt,jdbcType=VARCHAR}, #{txnTime,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{tranType,jdbcType=INTEGER}, ",
        "#{channelNo,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{uuid,jdbcType=VARCHAR}, #{stats,jdbcType=INTEGER})"
    })
    int insert(TransactionJournal record);

    @InsertProvider(type=TransactionJournalSqlProvider.class, method="insertSelective")
    int insertSelective(TransactionJournal record);

    @Select({
        "select",
        "seq_no, consmr_id, consmr_seq_no, org_consmr_id, org_consmr_seq_no, tran_code, ",
        "txn_dt, txn_time, create_time, tran_type, channel_no, detail, uuid, stats",
        "from t_transaction_journal",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="seq_no", property="seqNo", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="consmr_id", property="consmrId", jdbcType=JdbcType.VARCHAR),
        @Result(column="consmr_seq_no", property="consmrSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_consmr_id", property="orgConsmrId", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_consmr_seq_no", property="orgConsmrSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="tran_code", property="tranCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="txn_dt", property="txnDt", jdbcType=JdbcType.VARCHAR),
        @Result(column="txn_time", property="txnTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="tran_type", property="tranType", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_no", property="channelNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="stats", property="stats", jdbcType=JdbcType.INTEGER)
    })
    TransactionJournal selectByPrimaryKey(Long seqNo);

    @UpdateProvider(type=TransactionJournalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransactionJournal record);

    @Update({
        "update t_transaction_journal",
        "set consmr_id = #{consmrId,jdbcType=VARCHAR},",
          "consmr_seq_no = #{consmrSeqNo,jdbcType=VARCHAR},",
          "org_consmr_id = #{orgConsmrId,jdbcType=VARCHAR},",
          "org_consmr_seq_no = #{orgConsmrSeqNo,jdbcType=VARCHAR},",
          "tran_code = #{tranCode,jdbcType=VARCHAR},",
          "txn_dt = #{txnDt,jdbcType=VARCHAR},",
          "txn_time = #{txnTime,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "tran_type = #{tranType,jdbcType=INTEGER},",
          "channel_no = #{channelNo,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "uuid = #{uuid,jdbcType=VARCHAR},",
          "stats = #{stats,jdbcType=INTEGER}",
        "where seq_no = #{seqNo,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TransactionJournal record);
}