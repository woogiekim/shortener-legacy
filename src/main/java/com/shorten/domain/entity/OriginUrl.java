package com.shorten.domain.entity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@EqualsAndHashCode
public class OriginUrl {

  private final URI uri;

  protected OriginUrl(final String url) {
    verifyOriginUrl(url);

    this.uri = toUri(url);
  }

  private void verifyOriginUrl(final String url) {
    if (StringUtils.isBlank(url)) {
      throw new IllegalArgumentException("기존 주소 정보는 빈 값일 수 없습니다.");
    }
  }

  private URI toUri(final String url) {
    try {
      return new URL(url).toURI();
    } catch (URISyntaxException | MalformedURLException e) {
      throw new IllegalArgumentException("url 형식이 아닙니다.", e);
    }
  }

  public static OriginUrl of(final String url) {
    return new OriginUrl(url);
  }

  @Override
  public String toString() {
    return this.uri.toString();
  }
}
