package com.shorten.component;

public interface ShortenUrlGenerator {

  int SHORTEN_URL_LENGTH = 8;

  String generate(String longUrl);
}
