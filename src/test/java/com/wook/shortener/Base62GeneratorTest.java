package com.wook.shortener;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Base62GeneratorTest {

  @Test
  void generateKey() {
    System.out.println(Base62Generator.generateKey("http://test.com"));
  }
}