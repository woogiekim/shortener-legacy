package com.shorten.controller.dto;

import com.shorten.domain.entity.Shortener;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ShortenDto {

  @Getter
  public static class ShortenedUrlRequest {

    private String originalUrl;
  }


  @Getter
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ShortenedUrlResponse {

    private final String originalUrl;

    private final String shortenUrl;

    public static ShortenedUrlResponse of(final Shortener shortener) {
      return new ShortenedUrlResponse(shortener.toStringOriginUrl(), shortener.toStringShortenUrl());
    }
  }
}
