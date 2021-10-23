package com.shorten.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class ShortenedUrlResponse {

  private final String originalUrl;

  private final String shortenUrl;
}
