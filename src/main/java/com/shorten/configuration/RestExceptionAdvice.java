package com.shorten.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionAdvice {

  @InitBinder
  public void setAllowedFields(final WebDataBinder dataBinder) {
    dataBinder.initDirectFieldAccess();
  }

  @ExceptionHandler(Exception.class)
  public Response error(final Exception e) {
    return Response.error(HttpStatus.INTERNAL_SERVER_ERROR, "오류가 발생했습니다. 관리자에게 문의해주세요.");
  }

  @ExceptionHandler(RuntimeException.class)
  public Response error(final RuntimeException e) {
    return Response.error(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  @Getter
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Response {

    @JsonIgnore
    private final HttpStatus status;

    private final int code;

    private final String message;

    public static Response error(final HttpStatus status, final String message) {
      return new Response(status, status.value(), message);
    }
  }
}
