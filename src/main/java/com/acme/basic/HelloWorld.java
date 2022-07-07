package com.acme.basic;
import org.apache.log4j.Logger;
public class HelloWorld {

  void sayHello() {
    log.debug("Hello World!");
  }

  void notCovered() {
    log.debug("This method is not covered by unit tests");
  }

}
