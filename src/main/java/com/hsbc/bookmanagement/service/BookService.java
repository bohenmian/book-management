package com.hsbc.bookmanagement.service;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.controller.request.UpdateBookRequest;
import com.hsbc.bookmanagement.enums.ErrorCode;
import com.hsbc.bookmanagement.exception.BookNotFoundException;
import com.hsbc.bookmanagement.exception.IncorrectISBNFormatException;
import com.hsbc.bookmanagement.repository.BookRepository;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
import org.apache.commons.validator.routines.ISBNValidator;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Long create(CreateBookRequest request) {
        validateISBN(request.getIsbn());
        BookEntity book = new BookEntity(request.getTitle(), request.getAuthor(), request.getPublicationYear(), request.getIsbn());
        BookEntity saved = repository.save(book);
        return saved.getId();
    }

    public BookEntity findById(Long bookId) {
        return repository.findById(bookId).orElse(null);
    }

    public void update(Long bookId, UpdateBookRequest request) {
        validateISBN(request.getIsbn());
        BookEntity entity = findById(bookId);
        if (entity == null) {
            throw new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND);
        }
        BookEntity updated = new BookEntity(
                request.getTitle() == null ? entity.getTitle() : request.getTitle(),
                request.getAuthor() == null ? entity.getAuthor() : request.getAuthor(),
                request.getPublicationYear() == null ? entity.getPublicationYear() : request.getPublicationYear(),
                request.getIsbn() == null ? entity.getIsbn() : request.getIsbn()
        );
        repository.save(updated);
    }

    private void validateISBN(String request) {
        boolean isValid = ISBNValidator.getInstance().isValid(request);
        if (!isValid) {
            throw new IncorrectISBNFormatException(ErrorCode.INCORRECT_ISBN);
        }
    }

    public void delete(Long bookId) {

    }
}
