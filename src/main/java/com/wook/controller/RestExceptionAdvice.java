package com.wook.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {

  @ExceptionHandler(Exception.class)
  public ErrorResponse error(Exception e) {
    return ErrorResponse
        .builder()
        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(e.getMessage())
        .build();
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  private static class ErrorResponse {

    private int code;
    private String message;
  }
}
