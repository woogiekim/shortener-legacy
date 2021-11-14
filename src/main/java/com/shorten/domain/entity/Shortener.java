package com.shorten.domain.entity;

import java.net.URI;
import java.util.Objects;
import lombok.Getter;

public class Shortener {

  @Getter
  private final OriginUrl originUrl;

  private final ShortenUrl shortenUrl;

  protected Shortener(final OriginUrl originUrl, final ShortenUrl shortenUrl) {
    verifyShortener(originUrl, shortenUrl);

    this.originUrl = originUrl;
    this.shortenUrl = shortenUrl;
  }

  private void verifyShortener(final OriginUrl originUrl, final ShortenUrl shortenUrl) {
    if (Objects.isNull(originUrl)) {
      throw new IllegalArgumentException("기본주소 정보가 없습니다.");
    }

    if (Objects.isNull(shortenUrl)) {
      throw new IllegalArgumentException("짧은주소 정보가 없습니다.");
    }
  }

  public static Shortener of(final OriginUrl originUrl, final ShortenUrl shortenUrl) {
    return new Shortener(originUrl, shortenUrl);
  }

  public boolean isSameShortenUrl(final ShortenUrl shortenUrl) {
    return Objects.equals(this.shortenUrl, shortenUrl);
  }

  public URI toOriginUri() {
    return this.originUrl.getUri();
  }

  public String toStringOriginUrl() {
    return this.originUrl.toString();
  }

  public String toStringShortenUrl() {
    return this.shortenUrl.toUriString();
  }
}
