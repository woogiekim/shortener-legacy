package com.shorten.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestRandomAlphanumericGenerator {

  @DisplayName("RandomAlphanumericGenerator 학습테스트")
  @Test
  void generate() {
    final String shortenUrl = new RandomAlphanumericGenerator().generate("https://naver.com");

    assertThat(shortenUrl).isNotNull();
    assertThat(shortenUrl.length()).isEqualTo(ShortenUrlGenerator.SHORTEN_URL_LENGTH);
  }
}