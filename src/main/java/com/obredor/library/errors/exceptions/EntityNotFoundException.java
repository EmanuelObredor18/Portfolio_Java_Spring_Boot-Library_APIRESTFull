package com.obredor.library.errors.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException() {
    super("Entity not found");
  }

  public EntityNotFoundException(String message) {
    super(message);
  }

}
