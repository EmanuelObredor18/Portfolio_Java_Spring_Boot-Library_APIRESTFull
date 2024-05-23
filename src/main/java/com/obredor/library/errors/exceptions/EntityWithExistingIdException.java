package com.obredor.library.errors.exceptions;

public class EntityWithExistingIdException extends RuntimeException {
  public EntityWithExistingIdException() {
    super("An entity with this ID already exists");
  }
}
