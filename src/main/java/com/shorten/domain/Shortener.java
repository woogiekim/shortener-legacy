package com.shorten.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Shortener {

  private final OriginUrl originUrl;

  private final ShortenUrl shortenUrl;

  private Shortener(final OriginUrl originUrl, final ShortenUrl shortenUrl) {
    this.originUrl = originUrl;
    this.shortenUrl = shortenUrl;
  }

  public static Shortener of(final OriginUrl originUrl, final String redirectUrl) {
    verifyShortener(originUrl, redirectUrl);

    return new Shortener(originUrl, ShortenUrl.of(redirectUrl, originUrl));
  }

  private static void verifyShortener(final OriginUrl originUrl, final String redirectUrl) {
    if (Objects.isNull(originUrl)) {
      throw new IllegalArgumentException("기본주소 정보가 없습니다.");
    }

    if (StringUtils.isBlank(redirectUrl)) {
      throw new IllegalArgumentException("리다이렉트할 주소가 없습니다.");
    }
  }

  public String getOriginUrl() {
    return originUrl.toString();
  }

  public String getShortenUrl() {
    return shortenUrl.toString();
  }
}
