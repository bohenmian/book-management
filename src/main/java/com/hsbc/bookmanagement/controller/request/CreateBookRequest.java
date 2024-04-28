package com.hsbc.bookmanagement.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateBookRequest {
    @NotBlank
    String title;
    @NotBlank
    String author;
    @NotBlank
    String publicationYear;
    String isbn;
}
