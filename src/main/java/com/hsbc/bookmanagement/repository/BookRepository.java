package com.hsbc.bookmanagement.repository;

import com.hsbc.bookmanagement.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
