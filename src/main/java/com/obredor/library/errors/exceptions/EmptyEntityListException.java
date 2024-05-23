package com.obredor.library.errors.exceptions;

import lombok.Getter;

@Getter
public class EmptyEntityListException extends RuntimeException {

  public EmptyEntityListException() {
    super("Empty list of entities");
  }

  public EmptyEntityListException(String message) {
    super(message);
  }
}
