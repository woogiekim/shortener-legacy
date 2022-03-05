package com.shorten.domain.entity;

import static com.shorten.support.TestConstant.DISPLAY_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class OriginUrlTest {

  @Test
  void OriginUrl_생성_성공() {
    //given
    final String url = "http://naver.com";

    //when
    final OriginUrl originUrl = OriginUrl.of(url);

    //then
    assertThat(originUrl.getUri()).isEqualTo(URI.create("http://naver.com"));
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @NullAndEmptySource
  void OriginUrl_생성_실패__빈값이나_null을_넣으면_예외발생(String url) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> OriginUrl.of(url))
        .withMessage("기존 주소 정보는 빈 값일 수 없습니다.");
  }

  @Test
  void OriginUrl_생성_실패__공백을_넣으면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> OriginUrl.of(" "))
        .withMessage("기존 주소 정보는 빈 값일 수 없습니다.");
  }

  @Test
  void OriginUrl_생성_실패__url형식이_아니면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> OriginUrl.of("url 형식이 아님"))
        .withMessage("url 형식이 아닙니다.");
  }
}