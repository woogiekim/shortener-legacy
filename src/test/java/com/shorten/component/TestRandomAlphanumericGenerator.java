package com.shorten.component;

import static org.assertj.core.api.Assertions.assertThat;

import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestRandomAlphanumericGenerator {

  @DisplayName("RandomAlphanumericGenerator 학습테스트")
  @Test
  void generate() {
    final ShortenUrl shortenUrl = new RandomAlphanumericGenerator().generate(RedirectUrl.of("https://naver.com"));

    assertThat(shortenUrl).isNotNull();
    assertThat(shortenUrl.toUriString().length())
        .isEqualTo(("http://127.0.0.1/" + ShortenUrlGenerator.SHORTEN_URL_LENGTH).length());
  }
}