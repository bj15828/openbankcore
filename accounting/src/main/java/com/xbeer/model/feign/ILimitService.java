package com.xbeer.model.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xbeer.net.BaseRequestCommand;
import com.xbeer.net.CommandResponse;

@Component
@FeignClient(value ="limitcenter" ,url = "http://inst1:7070")
//没有url会报错
//feign.FeignException: status 404 reading ILimitService#transfer(String)
public interface ILimitService {

  //这里的接口必须与远程接口一致
	@RequestMapping(method = RequestMethod.POST, value = "/limitquery")
	public CommandResponse transfer(@RequestBody String cmd

	    );
	
}
