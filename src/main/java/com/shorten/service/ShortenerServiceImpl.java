package com.shorten.service;

import com.shorten.component.ShortenUrlGenerator;
import com.shorten.domain.entity.OriginUrl;
import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenPath;
import com.shorten.domain.entity.ShortenUrl;
import com.shorten.domain.entity.Shortener;
import com.shorten.domain.repository.ShortenerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShortenerServiceImpl implements ShortenerService {

  @Value("${config.shorten.redirect-url}")
  private String redirectUrl;

  private final ShortenUrlGenerator shortenUrlGenerator;
  private final ShortenerRepository shorteners;

  @Override
  public Shortener shorten(final OriginUrl originUrl) {
    final ShortenUrl shortenUrl = shortenUrlGenerator.generate(RedirectUrl.of(redirectUrl));

    final Shortener shortener = Shortener.of(originUrl, shortenUrl);
    shorteners.add(shortener);

    return shortener;
  }

  @Override
  public Shortener getShortener(final ShortenPath shortenPath) {
    final ShortenUrl shortenUrl = ShortenUrl.of(RedirectUrl.of(redirectUrl), shortenPath);
    final OriginUrl original = shorteners.getOriginal(shortenUrl);

    return Shortener.of(original, shortenUrl);
  }
}
