package com.acme.basic;

public class HelloWorld {

  void sayHello() {
    log.debug("Hello World!");
  }

  void notCovered() {
    log.debug("This method is not covered by unit tests");
  }

}
