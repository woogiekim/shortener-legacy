package com.shorten.domain.entity;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
public class ShortenPath {

  private final String path;

  protected ShortenPath(final String path) {
    this.path = path;
  }

  public static ShortenPath of(final String path) {
    verifyShortenerPath(path);

    return new ShortenPath(path);
  }

  private static void verifyShortenerPath(final String path) {
    if (StringUtils.isBlank(path)) {
      throw new IllegalArgumentException("짧은 주소 패스 정보가 없습니다.");
    }
  }

  @Override
  public String toString() {
    return this.path;
  }
}
