package com.xbeer.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@ImportResource({  "classpath:spring.xml" })

@MapperScan("com.xbeer.repository")
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients("com.xbeer.api")

public class RabbitTest {

  
  
  public enum Keys{topic1,topic2};
 
  
  
  
  public static void main(String [] args){
    
   /* ApplicationContext ac = new FileSystemXmlApplicationContext("resource/spring.xml");
     Service s  =  (Service) ac.getBean("service");
     s.test1();*/
    
    
    String e = "sss";
    
    
    SpringApplication.run(RabbitTest.class, args);
    
 
    
    
  }
  
}
