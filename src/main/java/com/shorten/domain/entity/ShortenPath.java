package com.shorten.domain.entity;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.length;
import static org.apache.commons.lang3.StringUtils.trim;

import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

@EqualsAndHashCode
public class ShortenPath {

  public static final int LENGTH = 8;

  private final String path;

  protected ShortenPath(final String path) {
    this.path = path;
  }

  public static ShortenPath of(final String path) {
    Assert.isTrue(isNotBlank(path), "짧은 주소 패스 정보가 없습니다.");
    Assert.isTrue(length(trim(path)) == LENGTH, format("잛은 주소 패스는 %s자리 여야 합니다.", LENGTH));

    return new ShortenPath(path);
  }

  @Override
  public String toString() {
    return this.path;
  }
}
