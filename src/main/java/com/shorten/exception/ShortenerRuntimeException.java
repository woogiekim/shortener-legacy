package com.shorten.exception;

public class ShortenerRuntimeException extends RuntimeException {

  public ShortenerRuntimeException() {
  }

  public ShortenerRuntimeException(final String message) {
    super(message);
  }

  public ShortenerRuntimeException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ShortenerRuntimeException(final Throwable cause) {
    super(cause);
  }

  public ShortenerRuntimeException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
