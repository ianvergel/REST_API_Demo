package com.spring.spring_rest.exception;

/**
 * Exception thrown when a requested student cannot be found.
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2690100046087976236L;

    /**
     * Construct a new exception with specified message and cause.
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a new exception with specified message.
     * @param message the detail message
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Construct a new exception with specified cause.
     * @param cause the cause of the exception
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
