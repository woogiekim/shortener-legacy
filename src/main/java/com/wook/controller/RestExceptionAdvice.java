package com.wook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {

  @ExceptionHandler(Exception.class)
  public Response<Object> error(final Exception e) {
    return Response.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
  }
}
