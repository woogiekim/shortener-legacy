package com.shorten.service;

import com.shorten.domain.entity.OriginUrl;
import com.shorten.domain.entity.ShortenPath;
import com.shorten.domain.entity.Shortener;

public interface ShortenerService {

  Shortener shorten(final OriginUrl originUrl);

  Shortener getShortener(final ShortenPath shortenPath);
}
