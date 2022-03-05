package com.shorten.support;

import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

public final class TestConstant {

  private TestConstant() {
  }

  public static final String DISPLAY_NAME = "[" + ARGUMENTS_PLACEHOLDER + "] " + DISPLAY_NAME_PLACEHOLDER;
}
