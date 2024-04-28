package com.hsbc.bookmanagement.service;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.enums.ErrorCode;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
import com.hsbc.bookmanagement.exception.IncorrectISBNFormatException;
import com.hsbc.bookmanagement.repository.BookRepository;
import org.apache.commons.validator.routines.ISBNValidator;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Long create(CreateBookRequest request) {
        boolean isValid = ISBNValidator.getInstance().isValid(request.getIsbn());
        if (!isValid) {
            throw new IncorrectISBNFormatException(ErrorCode.INCORRECT_ISBN);
        }
        BookEntity book = new BookEntity(request.getTitle(), request.getAuthor(), request.getPublicationYear(), request.getIsbn());
        BookEntity saved = repository.save(book);
        return saved.getId();
    }
}
