package com.harsha.backend.exception;

public class RecipeNotFoundException extends RuntimeException {
  public RecipeNotFoundException(String msg) {
    super(msg);
  }
}
