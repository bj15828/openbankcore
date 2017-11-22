package com.xbeer.util;

public class StringUtil {
  public static String[] split(String in ,String regex){
    
    
    
    return in.split(regex);
  }
  
  
  public static boolean equals(String a,String b){
    
    return a.equals(b) ? true: false;
  }
  
  public static boolean isEmpty(String in){
    
    return null == in || in.equals("") ? true : false;
  }
  
}
