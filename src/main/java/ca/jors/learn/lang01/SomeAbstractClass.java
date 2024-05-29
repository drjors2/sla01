package ca.jors.learn.lang01;

import lombok.Data;

@Data
public abstract class SomeAbstractClass {

  private static final String SECRET = "secret";

  private String s = "Nos";

  public String getMoreS() {
    return s + "-3";
  }
  public String mySecret(){
    return SECRET;
  }
}
