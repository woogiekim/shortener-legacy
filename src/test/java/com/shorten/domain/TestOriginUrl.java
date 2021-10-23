package com.shorten.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TestOriginUrl {

  private static final String DISPLAY_NAME = "[{arguments}] {displayName}";

  @Test
  void 기존주소를_생성_할_수_있는가() {
    //given
    final String url = "http://naver.com";

    //when
    final OriginUrl originUrl = OriginUrl.of(url);

    //then
    assertThat(originUrl).isEqualTo(OriginUrl.of(url));
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @NullAndEmptySource
  void 빈값이나_null을_넣으면_예외가_발생하는가(String url) {
    assertThatIllegalArgumentException().isThrownBy(() -> OriginUrl.of(url));
  }

  @Test
  void 공백을_넣으면_예외가_발생하는가() {
    //given
    final String url = " ";

    //when then
    assertThatIllegalArgumentException().isThrownBy(() -> OriginUrl.of(url));
  }
}