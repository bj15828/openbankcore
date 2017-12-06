package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.NotifyEvent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NotifyEventMapper {
    @Delete({
        "delete from t_notify_event",
        "where event_id = #{eventId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long eventId);

    @Insert({
        "insert into t_notify_event (event_id, content, ",
        "clazz, stats, create_time)",
        "values (#{eventId,jdbcType=BIGINT}, #{content,jdbcType=VARCHAR}, ",
        "#{clazz,jdbcType=VARCHAR}, #{stats,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(NotifyEvent record);

    @InsertProvider(type=NotifyEventSqlProvider.class, method="insertSelective")
    int insertSelective(NotifyEvent record);

    @Select({
        "select",
        "event_id, content, clazz, stats, create_time",
        "from t_notify_event",
        "where event_id = #{eventId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="event_id", property="eventId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="clazz", property="clazz", jdbcType=JdbcType.VARCHAR),
        @Result(column="stats", property="stats", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    NotifyEvent selectByPrimaryKey(Long eventId);

    @UpdateProvider(type=NotifyEventSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NotifyEvent record);

    @Update({
        "update t_notify_event",
        "set content = #{content,jdbcType=VARCHAR},",
          "clazz = #{clazz,jdbcType=VARCHAR},",
          "stats = #{stats,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where event_id = #{eventId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NotifyEvent record);
}