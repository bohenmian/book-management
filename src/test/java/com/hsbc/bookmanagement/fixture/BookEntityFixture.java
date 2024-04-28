package com.hsbc.bookmanagement.fixture;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;

import com.hsbc.bookmanagement.repository.entity.BookEntity;

public class BookEntityFixture {
    public static BookEntity bookEntityFixture() {
        BookEntity entity = mock(BookEntity.class);
        lenient().when(entity.getId()).thenReturn(1L);
        lenient().when(entity.getAuthor()).thenReturn("dummy author");
        return entity;
    }
}
