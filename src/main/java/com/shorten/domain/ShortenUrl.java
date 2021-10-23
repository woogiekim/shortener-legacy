package com.shorten.domain;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import org.springframework.web.util.UriComponentsBuilder;

@EqualsAndHashCode
public class ShortenUrl {

  private final String url;

  private ShortenUrl(final String url) {
    this.url = url;
  }

  public static ShortenUrl of(final String redirectUrl, final OriginUrl originUrl) {
    verifyShortenUrl(originUrl);

    return new ShortenUrl(getShortenUrl(redirectUrl, originUrl.toString()));
  }

  private static void verifyShortenUrl(final OriginUrl originUrl) {
    if (Objects.isNull(originUrl)) {
      throw new IllegalArgumentException("기존 주소 정보가 없습니다.");
    }
  }

  private static String getShortenUrl(final String redirectUrl, final String url) {
    return UriComponentsBuilder.fromHttpUrl(redirectUrl)
                               .path(url)
                               .toUriString();
  }

  @Override
  public String toString() {
    return this.url;
  }
}
