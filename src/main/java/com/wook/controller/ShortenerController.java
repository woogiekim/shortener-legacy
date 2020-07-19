package com.wook.controller;

import com.wook.shortener.Base62Generator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerController {

  @GetMapping("/shorten")
  public Response<ShortenedUrlResponse> shorten(@RequestParam String url) {

    // generate shortened url
    final String shortenedUrl = Base62Generator.generateKey(url);

    final ShortenedUrlResponse shortenedUrlResponse = ShortenedUrlResponse
        .builder()
        .url(url)
        .shortenedUrl(shortenedUrl)
        .build();

    return Response.ok(shortenedUrlResponse);
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  private static class ShortenedUrlResponse {

    private String url;
    private String shortenedUrl;
  }
}
