package com.hsbc.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.fixture.CreateBookFixture;
import com.hsbc.bookmanagement.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void should_create_book_and_return_the_book_id_given_the_book_information() {
        CreateBookRequest request = CreateBookFixture.bookRequest();
        given(repository.save(any())).willReturn(1L);
        Long result = service.create(request);
        assertThat(result).isEqualTo(1L);
    }
}