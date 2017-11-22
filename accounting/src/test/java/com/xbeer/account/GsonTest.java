package com.xbeer.account;

import com.xbeer.util.JsonUtil;

public class GsonTest {


  public static void main(String[] args) {

    String a = "a";

    A a1 = new A();
   // a1.setA("ccc");
    A a2 = ((A) JsonUtil.json2Object(JsonUtil.object2Json(a1), A.class));
    // a2.setA("ddd");
    System.out.println(a2.getA());
    

  }


}
