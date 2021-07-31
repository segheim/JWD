package com.epam.jwd;

public class TetrahedronException extends Exception{
    public TetrahedronException() {
    }

    public TetrahedronException(String message) {
        super(message);
    }

    public TetrahedronException(String message, Throwable cause) {
        super(message, cause);
    }

    public TetrahedronException(Throwable cause) {
        super(cause);
    }
}
