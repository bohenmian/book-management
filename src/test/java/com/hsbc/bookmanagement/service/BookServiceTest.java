package com.hsbc.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.fixture.CreateBookFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {


    @InjectMocks
    private BookService service;

    @Test
    void should_create_book_and_return_the_book_id_given_the_book_information() {
        CreateBookRequest request = CreateBookFixture.bookRequest();
        Long result = service.create(request);
        assertThat(result).isEqualTo(1L);
    }
}