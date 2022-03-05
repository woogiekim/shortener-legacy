package com.shorten.component;

import static com.shorten.domain.entity.ShortenPath.LENGTH;

import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenPath;
import com.shorten.domain.entity.ShortenUrl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomAlphanumericGenerator implements ShortenUrlGenerator {

  @Override
  public ShortenUrl generate(final RedirectUrl redirectUrl) {
    final ShortenPath shortenPath = ShortenPath.of(RandomStringUtils.randomAlphanumeric(LENGTH));

    return ShortenUrl.of(redirectUrl, shortenPath);
  }
}
