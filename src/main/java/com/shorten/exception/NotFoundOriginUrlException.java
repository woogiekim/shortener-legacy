package com.shorten.exception;

public class NotFoundOriginUrlException extends ShortenerRuntimeException {

  private static final String MESSAGE = "원본주소를 찾을 수 없습니다. 삭제되었거나 없는 원본 주소입니다.";

  public NotFoundOriginUrlException() {
    super(MESSAGE);
  }

  public NotFoundOriginUrlException(final Throwable cause) {
    super(MESSAGE, cause);
  }
}
