package com.shorten.component;

import static com.shorten.domain.entity.ShortenPath.LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAlphanumericGeneratorTest {

  @Test
  void RandomAlphanumericGenerator_학습테스트() {
    final ShortenUrl shortenUrl = new RandomAlphanumericGenerator().generate(RedirectUrl.of("http://127.0.0.1:8080"));

    assertThat(shortenUrl).isNotNull();
    assertThat(shortenUrl.toUriString().length())
        .isEqualTo("http://127.0.0.1:8080/".length() + LENGTH);
  }
}