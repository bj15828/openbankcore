package com.xbeer.event;

import java.util.Date;

import com.xbeer.util.DateUtil;
import com.xbeer.util.JsonUtil;
import com.xbeer.util.TimeUtil;

/**
 * 每个Action引起的的对象状态更新，都应该备记录下来
 * 
 */
public class MicroStateMachine<T> {


  long id;

  String beforeState;
  
  String afterState;

  Date beforeCreateTime;
  Date afterCreateTime;
  
  

  public MicroStateMachine() {

   
  }

  /**
   * @param id : state id
   * @param original class  
   * */
  public MicroStateMachine(long id,String clazz) {
    this.id = id;
   
  }

  


  public Date getBeforeCreateTime() {
    return beforeCreateTime;
  }

  public void setBeforeCreateTime(Date beforeCreateTime) {
    this.beforeCreateTime = beforeCreateTime;
  }

  public Date getAfterCreateTime() {
    return afterCreateTime;
  }

  public void setAfterCreateTime(Date afterCreateTime) {
    this.afterCreateTime = afterCreateTime;
  }

  public void setBeforeState(String beforeState) {
    this.beforeState = beforeState;
  }

  public void setAfterState(String afterState) {
    this.afterState = afterState;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBeforeState() {
    return beforeState;
  }

  public void setBeforeState(Object beforeState) {
    this.beforeState = JsonUtil.object2Json(this);
    this.beforeCreateTime = DateUtil.today();
  }

  public String getAfterState() {
    return afterState;
  }

  public void setAfterState(Object afterState) {
    this.afterState = JsonUtil.object2Json(this);
    this.afterCreateTime = DateUtil.today();
  }



  public String toString() {

    return JsonUtil.object2Json(this);

  }

}
