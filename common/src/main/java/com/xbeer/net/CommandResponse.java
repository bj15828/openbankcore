package com.xbeer.net;

public class CommandResponse {

    CommandResponseHeader header;
    
    CommandRequestBody body;

    public CommandResponseHeader getHeader() {
      return header;
    }

    public void setHeader(CommandResponseHeader header) {
      this.header = header;
    }

    public CommandRequestBody getBody() {
      return body;
    }

    public void setBody(CommandRequestBody body) {
      this.body = body;
    }
    
    
  
  
}
