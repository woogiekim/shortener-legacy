package com.shorten.controller;

import com.shorten.component.RandomAlphanumericGenerator;
import com.shorten.dto.ShortenedUrlResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerController {

  @GetMapping("/shorten")
  public Response<ShortenedUrlResponse> shorten(@RequestParam String url) {

    // generate shortened url
    final String shortenedUrl = new RandomAlphanumericGenerator().generate(url);

    final ShortenedUrlResponse shortenedUrlResponse = ShortenedUrlResponse.of(url, shortenedUrl);

    return Response.ok(shortenedUrlResponse);
  }

}
