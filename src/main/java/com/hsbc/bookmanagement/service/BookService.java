package com.hsbc.bookmanagement.service;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Long create(CreateBookRequest request) {
        return 1L;
    }
}
