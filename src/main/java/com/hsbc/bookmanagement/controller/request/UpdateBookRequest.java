package com.hsbc.bookmanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateBookRequest {
    String title;
    String author;
    String publicationYear;
    String isbn;
}
