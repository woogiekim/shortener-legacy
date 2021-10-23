package com.shorten.domain;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
public class OriginUrl {

  private final String url;

  private OriginUrl(final String url) {
    this.url = url;
  }

  public static OriginUrl of(final String url) {
    verifyOriginUrl(url);

    return new OriginUrl(url);
  }

  private static void verifyOriginUrl(final String url) {
    if (StringUtils.isBlank(url)) {
      throw new IllegalArgumentException("기존 주소 정보는 빈 값일 수 없습니다.");
    }
  }

  @Override
  public String toString() {
    return this.url;
  }
}
