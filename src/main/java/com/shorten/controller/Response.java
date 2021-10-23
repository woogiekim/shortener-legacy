package com.shorten.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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

  @JsonInclude(Include.NON_NULL)
  private final T body;

  public static <T> Response<T> of(final HttpStatus status, final T body) {
    return new Response<>(status, status.value(), status.getReasonPhrase(), body);
  }

  public static <T> Response<T> ok(final T body) {
    return of(HttpStatus.OK, body);
  }

  public static <T> Response<T> error(final HttpStatus status, final String message) {
    return new Response<>(status, status.value(), message, null);
  }
}
