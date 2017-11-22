package com.xbeer.message;

import com.xbeer.constants.MessageConstants;
import com.xbeer.constants.MessageConstants.MessageCode;

public class MessageFactory {



  public static Message newMessage(MessageCode code) {

    return new Message(code.getCode(), code.getMessage());


  }

  /**
   * 最大允许三个输入参数的format
   */
  public static Message newMessage(MessageCode code, String... args) {

    String str = code.getMessage();
    if (1 == args.length)
      str = String.format(code.getMessage(), args[0]);
    else if (2 == args.length)
      str = String.format(code.getMessage(), args[0], args[1]);
    else if (3 == args.length)
      str =  String.format(code.getMessage(), args[0], args[1], args[3]);

    return new Message(code.getCode(), str);


  }


  public static Message newSuccessMessage(String msg) {

    return new Message(MessageConstants.MessageCode.SUCCESS.getCode(), msg);

  }



}
