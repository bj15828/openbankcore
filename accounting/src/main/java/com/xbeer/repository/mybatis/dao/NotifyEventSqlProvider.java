package com.xbeer.repository.mybatis.dao;

import com.xbeer.repository.mybatis.NotifyEvent;
import org.apache.ibatis.jdbc.SQL;

public class NotifyEventSqlProvider {

    public String insertSelective(NotifyEvent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_notify_event");
        
        if (record.getEventId() != null) {
            sql.VALUES("event_id", "#{eventId,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getClazz() != null) {
            sql.VALUES("clazz", "#{clazz,jdbcType=VARCHAR}");
        }
        
        if (record.getStats() != null) {
            sql.VALUES("stats", "#{stats,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NotifyEvent record) {
        SQL sql = new SQL();
        sql.UPDATE("t_notify_event");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getClazz() != null) {
            sql.SET("clazz = #{clazz,jdbcType=VARCHAR}");
        }
        
        if (record.getStats() != null) {
            sql.SET("stats = #{stats,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("event_id = #{eventId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}