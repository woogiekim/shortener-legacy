package com.shorten.domain.entity;

import static com.shorten.support.TestConstant.DISPLAY_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RedirectUrlTest {

  @Test
  void RedirectUrl_생성_성공() {
    //given
    final String url = "https://naver.com";

    //when
    final RedirectUrl redirectUrl = RedirectUrl.of(url);

    //then
    assertThat(redirectUrl.toString()).isEqualTo(url);
    assertThat(redirectUrl.getUri()).isEqualTo(URI.create(url));
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @NullAndEmptySource
  void RedirectUrl_생성_실패__빈값이나_null을_넣으면_예외발생(String url) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> RedirectUrl.of(url))
        .withMessage("기존 주소 정보는 빈 값일 수 없습니다.");
  }

  @Test
  void RedirectUrl_생성_실패__공백을_넣으면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> RedirectUrl.of(" "))
        .withMessage("기존 주소 정보는 빈 값일 수 없습니다.");
  }

  @Test
  void RedirectUrl_생성_실패__url형식이_아니면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> RedirectUrl.of("url 형식이 아님"))
        .withMessage("url 형식이 아닙니다.");
  }
}