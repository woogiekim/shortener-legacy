package com.wook.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response<T> {

  @JsonIgnore
  private final HttpStatus status;

  private final int code;

  private final String message;

  private final T body;

  public static <T> Response<T> of(final HttpStatus status, final T body) {
    return new Response<>(status, status.value(), status.getReasonPhrase(), body);
  }

  public static <T> Response<T> ok(final T body) {
    return of(HttpStatus.OK, body);
  }
}
