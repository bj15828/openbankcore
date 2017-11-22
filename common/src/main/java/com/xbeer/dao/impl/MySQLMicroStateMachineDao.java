package com.xbeer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xbeer.dao.IMicroStateMachineDao;
import com.xbeer.event.MicroStateMachine;
import com.xbeer.exception.BaseException;
import com.xbeer.util.JsonUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * MySql数据库实现
 * */
public class MySQLMicroStateMachineDao implements IMicroStateMachineDao {

  
  Logger logger = LoggerFactory.getLogger(MySQLMicroStateMachineDao.class);
 
  HikariDataSource ds;
  
  String selectById ="select * from statemachine where id ='?'";
  String insertSql =
      "INSERT INTO account(id,data,create_time) VALUES(?,?,?) ";

  
  
  public MySQLMicroStateMachineDao(){
    
    
    String url =
        "jdbc:mysql://localhost:" + 3306 + "/" + "account" + "?useUnicode=true&characterEncoding=UTF-8";

    logger.info("Initializing MySql  url={}",  url);

    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername("root");
    config.setPassword("");
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    ds = new HikariDataSource(config);
    
  }
  
  public MicroStateMachine getMachineById(String id) throws BaseException {
    
    
    

    Connection c;
    try {
      c = ds.getConnection();
    } catch (SQLException e1) {

      throw new BaseException(e1);
    }
    
    try  {

      PreparedStatement preparedStatement = c.prepareStatement(selectById);
     

      preparedStatement.setString(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {

        String str = resultSet.getString(2);

        return (MicroStateMachine) JsonUtil.json2Object(str, MicroStateMachine.class);
      }
      return null;
    } catch (SQLException e) {
      throw new BaseException(e);
    } finally {
      try {
        c.close();
      } catch (SQLException e) {
       
        e.printStackTrace();
      }
    }

   
  }

  public int save(MicroStateMachine machine) throws BaseException {
  

    Connection c;
    try {
      c = ds.getConnection();
    } catch (SQLException e1) {

      throw new BaseException(e1);
    }

    try {


      c.setAutoCommit(false);

      PreparedStatement preparedStatement = c.prepareStatement(insertSql);
      preparedStatement.setLong(1, machine.getId());
      preparedStatement.setString(2, machine.toString());
     
     


      int i = preparedStatement.executeUpdate();

      c.commit();
      if (i < 1) {
        throw new SQLException("sss");

      }

    } catch (SQLException e) {

      if (null != c) {
        try {
          c.rollback();

        } catch (SQLException e1) {
          
          e.printStackTrace();
          throw new BaseException(e);
        }
      }

    } finally {

      try {
        c.close();
      } catch (SQLException e) {
       
        e.printStackTrace();
      }

    }
    
    return 1;

    
    
  }
  
    
  
}
