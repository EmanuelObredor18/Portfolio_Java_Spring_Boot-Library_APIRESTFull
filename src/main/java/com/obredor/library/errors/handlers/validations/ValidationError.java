package com.obredor.library.errors.handlers.validations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.obredor.library.errors.response.ErrorResponse;

@ControllerAdvice
public class ValidationError extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      @NonNull MethodArgumentNotValidException ex,
      @NonNull HttpHeaders headers,
      @NonNull HttpStatusCode status,
      @NonNull WebRequest request) {

    Map<String, Object> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), messageSource.getMessage("validation.required.field", null, LocaleContextHolder.getLocale())));
    
    // messageSource.getMessage("validation.required.field", null, null)

    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid entries detected", "Some fields are invalid. Please check the following entries", errors);
    
    return ResponseEntity.status(status).body(errorResponse);
  }

}
