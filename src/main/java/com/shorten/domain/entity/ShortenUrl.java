package com.shorten.domain.entity;

import java.net.URI;
import java.util.Objects;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ShortenUrl {

  private final RedirectUrl redirectUrl;
  private final ShortenPath shortenPath;

  private ShortenUrl(final RedirectUrl redirectUrl, final ShortenPath shortenPath) {
    verifyShortenUrl(redirectUrl, shortenPath);

    this.redirectUrl = redirectUrl;
    this.shortenPath = shortenPath;
  }

  public static ShortenUrl of(final RedirectUrl redirectUrl, final ShortenPath shortenPath) {
    return new ShortenUrl(redirectUrl, shortenPath);
  }

  private static void verifyShortenUrl(final RedirectUrl redirectUrl, final ShortenPath shortenPath) {
    if (Objects.isNull(redirectUrl)) {
      throw new IllegalArgumentException("리다이렉트 주소 정보가 없습니다.");
    }

    if (Objects.isNull(shortenPath)) {
      throw new IllegalArgumentException("짧은 주소 패스 정보가 없습니다.");
    }
  }

  public String toUriString() {
    return String.join("/", this.redirectUrl.toString(), this.shortenPath.toString());
  }

  public URI toRedirectUri() {
    return this.redirectUrl.getUri();
  }
}
