package com.shorten.domain.entity;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@EqualsAndHashCode
public class RedirectUrl {

  private final URI uri;

  protected RedirectUrl(final String url) {
    Assert.isTrue(isNotBlank(url), "기존 주소 정보는 빈 값일 수 없습니다.");

    this.uri = toUri(url);
  }

  private URI toUri(final String url) {
    try {
      return new URL(url).toURI();
    } catch (URISyntaxException | MalformedURLException e) {
      throw new IllegalArgumentException("url 형식이 아닙니다.", e);
    }
  }

  public static RedirectUrl of(final String url) {
    return new RedirectUrl(url);
  }

  @Override
  public String toString() {
    return this.uri.toString();
  }
}
