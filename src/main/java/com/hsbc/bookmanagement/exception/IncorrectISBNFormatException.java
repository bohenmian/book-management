package com.hsbc.bookmanagement.exception;

import com.hsbc.bookmanagement.enums.ErrorCode;

public class IncorrectISBNFormatException extends RuntimeException {
    public IncorrectISBNFormatException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
