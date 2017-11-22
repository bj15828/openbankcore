package com.xbeer.repository.daoadapter;

import org.springframework.context.annotation.Primary;

import com.xbeer.repository.mybatis.dao.AccountInfoMapper;


@Primary
public interface AccountInfoDaoAdapter extends AccountInfoMapper  {

}
