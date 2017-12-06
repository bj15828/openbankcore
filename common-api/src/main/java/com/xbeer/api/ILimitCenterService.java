package com.xbeer.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xbeer.api.dto.LimitQueryCommand;
import com.xbeer.command.CommandResponse;
import com.xbeer.exception.BaseException;

@Component

@FeignClient(value = "limitcenter", url = "http://inst1:7070")
// 没有url会报错
// feign.FeignException: status 404 reading ILimitService#transfer(String)

public interface ILimitCenterService {




  
  @RequestMapping(method = RequestMethod.POST, value = "/limit/query")
  public CommandResponse limitQuery(@RequestBody LimitQueryCommand cmd

  ) throws BaseException;



}
