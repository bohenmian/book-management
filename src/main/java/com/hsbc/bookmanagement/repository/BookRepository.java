package com.hsbc.bookmanagement.repository;

import com.hsbc.bookmanagement.repository.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
