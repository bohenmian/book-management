package com.hsbc.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.exception.IncorrectISBNFormatException;
import com.hsbc.bookmanagement.fixture.BookEntityFixture;
import com.hsbc.bookmanagement.fixture.CreateBookFixture;
import com.hsbc.bookmanagement.repository.BookRepository;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
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

    @Nested
    class WhenCreateBook {
        @Test
        void should_create_book_and_return_the_book_id_given_the_book_information() {
            CreateBookRequest request = CreateBookFixture.bookRequest();
            BookEntity entity = BookEntityFixture.bookEntityFixture();
            given(repository.save(any())).willReturn(entity);
            Long result = service.create(request);
            assertThat(result).isEqualTo(1L);
        }

        @Test
        void should_throw_incorrect_isbn_number_exception_given_the_wrong_isbn_number() {
            CreateBookRequest request = new CreateBookRequest("Distributed System", "John", "2024", "dummy isbn");
            assertThatThrownBy(() -> service.create(request))
                    .isInstanceOf(IncorrectISBNFormatException.class)
                    .hasMessageContaining("incorrect isbn number, please check");
        }
    }

    @Nested
    class WhenFindBookById {
        private Long bookId = 1L;
        @Test
        void should_return_the_book_information_given_the_book_id() {
            Optional<BookEntity> entity = Optional.of(BookEntityFixture.bookEntityFixture());
            given(repository.findById(any())).willReturn(entity);

            BookEntity result = service.findById(bookId);

            assertThat(result.getAuthor()).isEqualTo("dummy author");
            verify(repository).findById(1L);
        }

        @Test
        void should_return_null_given_the_id_not_found_any_book() {
            given(repository.findById(any())).willReturn(Optional.empty());

            BookEntity result = service.findById(bookId);

            assertThat(result).isNull();
        }
    }
}