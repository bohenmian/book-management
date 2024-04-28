package com.hsbc.bookmanagement.enums;

public enum ErrorCode {
    INCORRECT_ISBN("INCORRECT_ISBN_NUMBER", "Incorrect isbn number, please check"),
    BOOK_NOT_FOUND("BOOK_NOT_FOUND", "The book is not found");

    String code;
    String message;

    ErrorCode() {
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
