package com.shorten.domain.entity;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

@EqualsAndHashCode
public class ShortenPath {

  private final String path;

  protected ShortenPath(final String path) {
    this.path = path;
  }

  public static ShortenPath of(final String path) {
    Assert.isTrue(isNotBlank(path), "짧은 주소 패스 정보가 없습니다.");

    return new ShortenPath(path);
  }

  @Override
  public String toString() {
    return this.path;
  }
}
