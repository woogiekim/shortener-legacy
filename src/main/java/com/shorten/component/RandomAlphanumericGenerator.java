package com.shorten.component;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphanumericGenerator implements ShortenUrlGenerator {

  @Override
  public String generate(final String longUrl) {

    return RandomStringUtils.randomAlphanumeric(SHORTEN_URL_LENGTH);
  }
}
