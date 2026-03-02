package com.example.employee_api.exception;

import java.time.LocalDateTime;

public class Error {
    private String message;
    private int status;
    private LocalDateTime timestamp;

    public Error(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
