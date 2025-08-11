package org.example.exceptions;

public class FuelException extends RuntimeException{

    public FuelException(String message) {
        super(message);
    }

    public FuelException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuelException(Throwable cause) {
        super(cause);
    }
}
