package com.hsbc.bookmanagement.exception;

import com.hsbc.bookmanagement.enums.ErrorCode;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(ErrorCode code) {
        super(code.getMessage());
    }
}
