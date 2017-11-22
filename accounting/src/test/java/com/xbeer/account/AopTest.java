package com.xbeer.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({  "classpath:spring.xml" })
@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.xbeer")

public class AopTest {

  @Autowired  
  private static ApplicationContext context;
  
  
 
  
  public static void main(String [] args){
    
   /* ApplicationContext ac = new FileSystemXmlApplicationContext("resource/spring.xml");
     Service s  =  (Service) ac.getBean("service");
     s.test1();*/
    
    
    SpringApplication.run(AopTest.class, args);
    
 
    
    
    
  }
  
}
