package com.xbeer.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;



@ImportResource({  "classpath:spring.xml" })
@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.demo.dao")
public class Main {
  
  
  public static void main(String [] args){
    
    SpringApplication.run(Main.class, args);
    
  }
}
