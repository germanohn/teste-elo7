package com.elo7.probes.exception;

public class MovementException extends RuntimeException {

    public MovementException(String message) {
        super(message);
    }

    public MovementException(Throwable cause) {
        super(cause);
    }

    public MovementException(String message, Throwable cause) {
        super(message, cause);
    }
}
