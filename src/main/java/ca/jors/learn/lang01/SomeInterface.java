package ca.jors.learn.lang01;

public interface SomeInterface {
   String LEVELS = "Maybe";

  default String getName() {
    return "Daniel";
  }
  default  String getLEVELS() {
      return LEVELS;
  }
}
