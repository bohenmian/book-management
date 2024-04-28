package com.hsbc.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.exception.IncorrectISBNFormatException;
import com.hsbc.bookmanagement.fixture.CreateBookFixture;
import com.hsbc.bookmanagement.repository.BookRepository;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
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
        BookEntity entity = mock(BookEntity.class);
        given(entity.getId()).willReturn(1L);
        given(repository.save(any())).willReturn(entity);
        Long result = service.create(request);
        assertThat(result).isEqualTo(1L);
    }

    @Test
    void should_throw_incorrect_isbn_number_exception_given_the_wrong_isbn_number() {
        CreateBookRequest request = new CreateBookRequest("Distributed System", "John", "2024", "dummy isbn");
        assertThatThrownBy(() -> service.create(request))
                .isInstanceOf(IncorrectISBNFormatException.class)
                .hasMessageContaining("incorrect isbn error");
    }
}