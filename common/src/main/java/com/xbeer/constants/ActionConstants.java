package com.xbeer.constants;

public class ActionConstants {

    public static enum Types{
        
      WITH_DRAW(1),DEPOSIT(2),FROZONE(3),UN_FROZONE(4);
      
      
       int type;
       Types(int i){
        this.type  = i ;
      }
      public int getCode(){
        return type;
      }
      
    }
  
  
}
