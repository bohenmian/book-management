package com.hsbc.bookmanagement.exception;

public class IncorrectISBNFormatException extends RuntimeException {
    public IncorrectISBNFormatException() {
    }

    public IncorrectISBNFormatException(String message) {
        super(message);
    }
}
