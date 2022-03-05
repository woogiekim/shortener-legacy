package com.shorten.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ShortenUrlTest {

  @Test
  void ShortenUrl_생성_성공() {
    //given
    final RedirectUrl redirectUrl = RedirectUrl.of("http://127.0.0.1:8080");
    final ShortenPath shortenPath = ShortenPath.of("abcdefgh");

    //when
    final ShortenUrl shortenUrl = ShortenUrl.of(redirectUrl, shortenPath);

    //then
    assertThat(shortenUrl.toUriString()).isEqualTo("http://127.0.0.1:8080/abcdefgh");
  }

  @Test
  void ShortenUrl_생성_실패__RedirectUrl이_null_이면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> ShortenUrl.of(null, ShortenPath.of("abcdefgh")))
        .withMessage("리다이렉트 주소 정보가 없습니다.");
  }

  @Test
  void ShortenUrl_생성_실패__ShortenPath가_null_이면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> ShortenUrl.of(RedirectUrl.of("http://127.0.0.1:8080"), null))
        .withMessage("짧은 주소 패스 정보가 없습니다.");
  }
}