package com.hsbc.bookmanagement.fixture;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;

public class CreateBookFixture {
    public static CreateBookRequest bookRequest() {
        return new CreateBookRequest("Distributed System", "John", "2024", "962-215-001-2");
    }
}
