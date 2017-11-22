package com.xbeer.account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component 
@Aspect  
public class ApiAspect {
 
  
  @Pointcut("@annotation(com.xbeer.annotation.TransactionOps)")// 定义注解类型的切点，只要方法上有该注解，都会匹配  
  @Order(1)  
  public void annotationPoint(){  
        
  } 
  
  @Before("annotationPoint()")  
  public void doBeforeAdvice(JoinPoint joinPoint){  
    
    
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    System.out.println(((Service)joinPoint.getTarget()).getV());
    
    System.out.println("before1");
  
  }
  @After("annotationPoint()")  
  public void doAfter(JoinPoint joinPoint){  
    
    
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    System.out.println(((Service)joinPoint.getTarget()).getV());
    
    System.out.println("after1");
  
  }
  


  
  
}
