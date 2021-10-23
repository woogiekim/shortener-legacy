package com.shorten.controller;

import com.shorten.domain.dto.ShortenedUrlResponse;
import com.shorten.shortener.Base62Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerController {

  @GetMapping("/shorten")
  public Response<ShortenedUrlResponse> shorten(@RequestParam String url) {

    // generate shortened url
    final String shortenedUrl = Base62Generator.generateKey(url);

    final ShortenedUrlResponse shortenedUrlResponse = ShortenedUrlResponse.of(url, shortenedUrl);

    return Response.ok(shortenedUrlResponse);
  }

}
