package com.shorten.domain.entity;

import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

@EqualsAndHashCode
public class ShortenUrl {

  private final RedirectUrl redirectUrl;
  private final ShortenPath shortenPath;

  private ShortenUrl(final RedirectUrl redirectUrl, final ShortenPath shortenPath) {
    Assert.notNull(redirectUrl, "리다이렉트 주소 정보가 없습니다.");
    Assert.notNull(shortenPath, "짧은 주소 패스 정보가 없습니다.");

    this.redirectUrl = redirectUrl;
    this.shortenPath = shortenPath;
  }

  public static ShortenUrl of(final RedirectUrl redirectUrl, final ShortenPath shortenPath) {
    return new ShortenUrl(redirectUrl, shortenPath);
  }

  public String toUriString() {
    return String.join("/", this.redirectUrl.toString(), this.shortenPath.toString());
  }
}
