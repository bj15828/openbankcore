package com.xbeer.controller.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

public class ControllerValidator {  
  private static Validator validator = Validation.buildDefaultValidatorFactory()  
          .getValidator();  
    
  
  
  
  public static <T> ValidateResult validate(T obj){  
    ValidateResult result = new ValidateResult();
      Map<String,StringBuffer> errorMap = null;  
      Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);  
      if(set != null && set.size() >0 ){  
          errorMap = new HashMap<String,StringBuffer>(); 
         
          String property = null;  
          for(ConstraintViolation<T> cv : set){  
              //这里循环获取错误信息，可以自定义格式  
              property = cv.getPropertyPath().toString();  
              if(errorMap.get(property) != null){  
                  errorMap.get(property).append("," + cv.getMessage());  
              }else{  
                  StringBuffer sb = new StringBuffer();  
                  sb.append(cv.getMessage());  
                  errorMap.put(property, sb);  
              }  
              break;//一次只返回一个检查信息
          } 
          result.setHasPassed(false);
          result.setData(errorMap);
          
      }  
      return result;  
  }  

   
}  