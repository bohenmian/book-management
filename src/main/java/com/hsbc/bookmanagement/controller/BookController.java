package com.hsbc.bookmanagement.controller;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.controller.request.UpdateBookRequest;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
import com.hsbc.bookmanagement.service.BookService;
import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Valid CreateBookRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<BookEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/book")
    public BookEntity findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}/book")
    public void update(@PathVariable(name = "id") Long id, @RequestBody UpdateBookRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("{id}/book")
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }
}
