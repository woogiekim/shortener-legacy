package com.shorten.domain.entity;

import static com.shorten.domain.entity.ShortenPath.LENGTH;
import static com.shorten.support.TestConstant.DISPLAY_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ShortenPathTest {

  @Test
  void ShortenPath_생성_성공() {
    //given
    final String path = "abcdefgh";

    //when
    final ShortenPath shortenPath = ShortenPath.of(path);

    //then
    assertThat(shortenPath.toString()).isEqualTo(path);
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @NullAndEmptySource
  void ShortenPath_생성_실패__빈값이나_null을_넣으면_예외발생(String path) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> ShortenPath.of(path))
        .withMessage("짧은 주소 패스 정보가 없습니다.");
  }

  @Test
  void ShortenPath_생성_실패__path가_8자리를_초과하면_예외발생() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> ShortenPath.of("1234567"))
        .withMessage("잛은 주소 패스는 %s자리 여야 합니다.", LENGTH);
  }
}