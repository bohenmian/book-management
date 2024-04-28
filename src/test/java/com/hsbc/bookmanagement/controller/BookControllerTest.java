package com.hsbc.bookmanagement.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.bookmanagement.controller.request.CreateBookRequest;
import com.hsbc.bookmanagement.controller.request.UpdateBookRequest;
import com.hsbc.bookmanagement.fixture.BookEntityFixture;
import com.hsbc.bookmanagement.fixture.CreateBookFixture;
import com.hsbc.bookmanagement.repository.entity.BookEntity;
import com.hsbc.bookmanagement.service.BookService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService service;

    private final static String BASE_PATH = "/api/v1/books";
    private final Long bookId = 1L;

    @Nested
    class WhenCreateBook {
        @Test
        void should_return_201_given_the_create_book_success() throws Exception {
            CreateBookRequest request = CreateBookFixture.bookRequest();
            given(service.create(any())).willReturn(bookId);
            mockMvc.perform(post(BASE_PATH)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isCreated())
                    .andExpect(content().string("1"));
            verify(service, times(1)).create(request);
        }

        @Test
        void should_return_bad_request_given_the_book_title_is_null() throws Exception {
            CreateBookRequest request = new CreateBookRequest(null, "author", "2024", "962-215-001-2");
            mockMvc.perform(post(BASE_PATH)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
            verify(service, times(0)).create(any());
        }
    }

    @Nested
    class WhenFindBookById {
        @Test
        void should_return_the_book_information_given_the_book_id() throws Exception {
            BookEntity entity = BookEntityFixture.bookEntityFixture();
            given(service.findById(bookId)).willReturn(entity);
            mockMvc.perform(get(BASE_PATH + "/{id}/book", 1L))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.author").value("dummy author"));
        }
    }

    @Nested
    class WhenUpdateBookDetail {
        @Test
        void should_update_book_detail_given_the_new_book_information() throws Exception {
            UpdateBookRequest request = new UpdateBookRequest("title", "author", "2024", "962-215-001-2");
            doNothing().when(service).update(any(), any());
            mockMvc.perform(put(BASE_PATH + "/{id}/book", 1L)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk());
            verify(service, times(1)).update(1L, request);
        }
    }

    @Nested
    class WhenDeleteBook {
        @Test
        void should_delete_the_book_given_the_book_id() throws Exception {
            doNothing().when(service).delete(bookId);
            mockMvc.perform(delete(BASE_PATH + "/{id}/book", 1L))
                    .andExpect(status().isOk());
        }
    }
}