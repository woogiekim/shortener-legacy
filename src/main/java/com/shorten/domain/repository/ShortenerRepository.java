package com.shorten.domain.repository;

import com.shorten.domain.entity.OriginUrl;
import com.shorten.domain.entity.ShortenUrl;
import com.shorten.domain.entity.Shortener;
import com.shorten.exception.NotFoundOriginUrlException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class ShortenerRepository {

  private static final Set<Shortener> SHORTENERS = new HashSet<>();

  public void add(final Shortener shortener) {
    SHORTENERS.add(shortener);
  }

  public OriginUrl getOriginal(final ShortenUrl shortenUrl) {
    return SHORTENERS.stream()
                     .filter(shortener -> shortener.isSameShortenUrl(shortenUrl))
                     .map(Shortener::getOriginUrl)
                     .findFirst()
                     .orElseThrow(NotFoundOriginUrlException::new);
  }
}
