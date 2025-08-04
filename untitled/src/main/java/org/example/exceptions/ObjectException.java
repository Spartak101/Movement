package org.example.exceptions;

public class ObjectException extends RuntimeException{
    public ObjectException() {
        super();
    }

    public ObjectException(String message) {
        super(message);
    }

    public ObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectException(Throwable cause) {
        super(cause);
    }
}
