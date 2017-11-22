package com.xbeer.domain;

public class Rid {

  long term;
  long index;
  
  public Rid(){
    
    term = 1;
    index = 1;
    
  }

  public long getTerm() {
    return term;
  }

  public void setTerm(long term) {
    this.term = term;
  }

  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }
  public long getIndexAndIncr(){
    index = index + 1;
    return index;
  }
  public long getTermAndIncr(){
    term = term + 1;
    return term;
  }
  
  
}
