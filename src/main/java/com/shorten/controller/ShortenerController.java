package com.shorten.controller;

import com.shorten.controller.dto.ShortenDto.ShortenedUrlRequest;
import com.shorten.controller.dto.ShortenDto.ShortenedUrlResponse;
import com.shorten.domain.entity.OriginUrl;
import com.shorten.domain.entity.ShortenPath;
import com.shorten.domain.entity.Shortener;
import com.shorten.service.ShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShortenerController {

  private final ShortenerService shortenerService;

  @PostMapping("/shortener")
  public ResponseEntity<ShortenedUrlResponse> shorten(@RequestBody final ShortenedUrlRequest request) {
    final Shortener shortener = shortenerService.shorten(OriginUrl.of(request.getOriginalUrl()));

    return ResponseEntity.ok(ShortenedUrlResponse.of(shortener));
  }

  @GetMapping("/{shortenPath}")
  public ResponseEntity<Object> redirect(@PathVariable final ShortenPath shortenPath) {
    System.out.println(shortenPath);
    final Shortener shortener = shortenerService.getShortener(shortenPath);

    return ResponseEntity.status(HttpStatus.FOUND)
                         .location(shortener.toOriginUri())
                         .build();
  }
}
