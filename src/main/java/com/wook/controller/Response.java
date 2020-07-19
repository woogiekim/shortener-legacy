package com.wook.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Response<T> {

  @Default
  private int code = HttpStatus.OK.value();

  @Default
  private String message = HttpStatus.OK.name();

  private T body;

  public static <T> Response<T> ok(T body) {
    return Response
        .<T>builder()
        .body(body)
        .build();
  }
}
