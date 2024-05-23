package com.obredor.library.errors.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.obredor.library.errors.exceptions.EmptyEntityListException;
import com.obredor.library.errors.exceptions.EntityNotFoundException;
import com.obredor.library.errors.response.ErrorResponse;

@ControllerAdvice
public class EntityExceptionsHandler {

  @ExceptionHandler(EmptyEntityListException.class)
  public ResponseEntity<ErrorResponse> handleEmptyListException() {

    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, new EmptyEntityListException().getMessage(),
        "It is necessary to have saved entries before making the request");

    return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFoundException() {
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, new EntityNotFoundException().getMessage(), "Entity not found in database");

    return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
  }
}
