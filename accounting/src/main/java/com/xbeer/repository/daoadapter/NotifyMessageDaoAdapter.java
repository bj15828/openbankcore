package com.xbeer.repository.daoadapter;

import org.springframework.context.annotation.Primary;

import com.xbeer.repository.mybatis.dao.NotifyEventMapper;


@Primary
public interface NotifyMessageDaoAdapter extends NotifyEventMapper  {

  

}
