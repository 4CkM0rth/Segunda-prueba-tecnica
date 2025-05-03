package com.backend.infraestrcuture.exception;

public class ApiException extends RuntimeException {
  public ApiException(String message) {
    super(message);
  }
}
