package com.obredor.library.errors.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  private final HttpStatus httpStatus;
  private final String errorMessage;
  private final String details;
  private Object errorSource;
  private final LocalDateTime currentDate = LocalDateTime.now();
}
