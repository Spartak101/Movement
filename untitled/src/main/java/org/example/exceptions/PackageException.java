package org.example.exceptions;

public class PackageException extends RuntimeException{
    public PackageException() {
        super();
    }

    public PackageException(String message) {
        super(message);
    }

    public PackageException(String message, Throwable cause) {
        super(message, cause);
    }

    public PackageException(Throwable cause) {
        super(cause);
    }
}
