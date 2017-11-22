package com.xbeer.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com")
@ImportResource({  "classpath:spring.xml" })

@MapperScan("com.xbeer")
@EnableDiscoveryClient
@EnableEurekaClient

public class LimitCenterMain {


 
  
  public static void main(String [] args){
    
 
    
   
    
    
    SpringApplication.run(LimitCenterMain.class, args);
    
 
    
    
  }

  
}
