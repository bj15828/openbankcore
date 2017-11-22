package com.xbeer.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */


@SpringBootApplication(scanBasePackages = "com")

@MapperScan("com.xbeer")
@ImportResource({  "classpath:spring.xml" })


public class Main 
{
    public static void main( String[] args )
    {

      SpringApplication.run(Main.class, args);
    }
    
    @Bean  
    public TomcatEmbeddedServletContainerFactory servletContainer(){  
        TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();  
        container.setPort(8088);  

        return container;  
    }  
}
