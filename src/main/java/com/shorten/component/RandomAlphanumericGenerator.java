package com.shorten.component;

import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenPath;
import com.shorten.domain.entity.ShortenUrl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomAlphanumericGenerator implements ShortenUrlGenerator {

  @Override
  public ShortenUrl generate(final RedirectUrl redirectUrl) {
    final ShortenPath shortenPath = ShortenPath.of(RandomStringUtils.randomAlphanumeric(SHORTEN_URL_LENGTH));

    return ShortenUrl.of(redirectUrl, shortenPath);
  }
}
