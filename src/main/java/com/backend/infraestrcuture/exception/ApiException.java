package com.backend.infraestrcuture.exception;

import java.time.LocalDateTime;

public class ApiException {

  private final String message;
  private final LocalDateTime timestamp;

  public ApiException(String message) {
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
