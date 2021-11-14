package com.shorten.component;

import com.shorten.domain.entity.RedirectUrl;
import com.shorten.domain.entity.ShortenUrl;

public interface ShortenUrlGenerator {

  int SHORTEN_URL_LENGTH = 8;

  ShortenUrl generate(final RedirectUrl redirectUrl);
}
